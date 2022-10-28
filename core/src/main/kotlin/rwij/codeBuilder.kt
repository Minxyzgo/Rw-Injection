package rwij

import com.squareup.javapoet.*
import javassist.*
import rwij.Builder.buildNewClassTree
import rwij.annotations.Additional
import rwij.annotations.RenameFrom
import rwij.util.*
import java.io.File
import javax.lang.model.SourceVersion

/**
 * 解析rw bytecode 生成仅包含签名的(可编译的)java文件
 * 可以解析绝大部分bytecode， 少数enum和构造函数需手动修改
 */
object CodeBuilder {
    lateinit var pool: ClassPool
    lateinit var tree: NodeTree

    private val ignoreMethodTypes = run {
        val commonMap = mapOf<String, List<Class<*>>>(
            "equals" to listOf(Object::class.java),
            "toString" to emptyList(),
            "hashCode" to emptyList(),
            "clone" to emptyList()
        )

        val enumMap = commonMap.toMutableMap().apply {
            this["values"] = emptyList()
            this["valueOf"] = listOf(String::class.java)
        }.toMap()

        fun(clazz: CtClass): Map<String, List<Class<*>>> {
            return when {
                clazz.isEnum -> enumMap
                else -> commonMap
            }
        }
    }

    internal fun build(file: File, modTime: Long) {
        val classTree: NodeTree
        val pair = buildNewClassTree()
        pool = pair.first
        classTree = pair.second
        tree = classTree
        buildCode(file, classTree, modTime)
    }

    private fun buildCode(file: File, classTree: NodeTree, modTime: Long) {
        classTree.filter {
            !(it.value as String).contains("$")
        }.forEach { node ->
            val ctClass = pool[node.value as String]

            val classFile = File(file.absolutePath + "\\" + ctClass.name.replace(".", "\\") + ".java")

            if(classFile.exists() && classFile.lastModified() != modTime && modTime != 0L)
                return@forEach

            try {
                fun TypeSpec.Builder.buildInnerClass(node_: Node = node) {
                    node_.forEach loop@{ node ->
                        val (name, isStatic, clazz) = node.value as Builder.CtClassData
                        val innerName = clazz.innerName
                        val oldName = "${clazz.name.substring(0, clazz.name.lastIndexOf('$'))}$$name".replace("$", "#")

                        if(ctClass.isEnum) {
                            addJavadoc("$oldName : $innerName\n")
                            buildInnerClass(node)
                            return@loop
                        }

                        //println("innername: $innerName name: $name clazzname:${clazz.name}")
                        val type = buildCtClass(clazz, innerName).apply {
                            if(isStatic) addModifiers(Modifier2.STATIC)
                            if(innerName != name) {
                                addJavadoc("Rename from: $oldName")
                            }
                            buildInnerClass(node)
                        }
                        addType(type.build())
                    }
                }

                val typeSpec = buildCtClass(ctClass).apply {
                    if(ctClass.isEnum) {
                        addJavadoc("lost enum classes:\n")
                    }
                    buildInnerClass()
                }.build()
                val javaFile = JavaFile.builder(ctClass.packageName, typeSpec).apply {
                    skipJavaLangImports(true)
                    indent("    ")
                }.build()
                javaFile.writeTo(file)
                classFile.setLastModified(latestModTime)
            } catch(e: Exception) {
                e.initCause(RuntimeException("build failed when parsing class. at class: ${ctClass.name}"))
                e.printStackTrace()
            }
        }
    }

    private fun addCommonModifiers(modifiers: Int, addModifiers: (Modifier2) -> Unit) {
        if(Modifier.isPublic(modifiers)) addModifiers(Modifier2.PUBLIC)
        if(Modifier.isProtected(modifiers)) addModifiers(Modifier2.PROTECTED)
        if(Modifier.isPrivate(modifiers)) addModifiers(Modifier2.PRIVATE)
        if(Modifier.isStatic(modifiers)) addModifiers(Modifier2.STATIC)
        if(Modifier.isNative(modifiers)) addModifiers(Modifier2.NATIVE)
    }

    private fun MethodSpec.Builder.baseBuild(behavior: CtBehavior, isStrict: Boolean): MethodSpec.Builder {
        addCommonModifiers(behavior.modifiers, this::addModifiers)
        if(Modifier.isFinal(behavior.modifiers)) addModifiers(Modifier2.FINAL)
        if(Modifier.isStrict(behavior.modifiers) && !isStrict) addModifiers(Modifier2.STRICTFP)

        for((index, param) in behavior.parameterTypes.withIndex()) {
            val paramSpec = ParameterSpec.builder(param.toTypeName(), "p${index}")
                .apply {
                    behavior.parameterAnnotations[index].map { it::class.java }.forEach(this::addAnnotation)
                }.build()
            addParameter(paramSpec)
        }
        behavior.annotations.map(Any::getAnnotationTypeName).forEach(this::addAnnotation)
        behavior.exceptionTypes.map { it.toTypeName() }.forEach(this::addException)
        return this
    }

    private fun buildCtClass(ctClass: CtClass, name: String = ctClass.simpleName): TypeSpec.Builder {
        val isStrict = ctClass.isStrict
        val methodSpecs = mutableSetOf<MethodSpec>()
        val fieldSpecs = mutableSetOf<FieldSpec>()

        ctClass.declaredBehaviors.forEach label@{ behavior ->
            if(behavior is CtMethod) {
                val returnClazz = behavior.returnType
                val types = ignoreMethodTypes(ctClass)
                if(types.keys.contains(behavior.name) &&
                    types[behavior.name]!!.size == behavior.parameterTypes.size
                ) {
                    var result = true
                    loop@ for((index, clazz) in types[behavior.name]!!.withIndex()) {
                        if(behavior.parameterTypes[index].name != clazz.canonicalName) {
                            result = false
                            break@loop
                        }
                    }
                    if(result) return@label
                }

                val newName = if(SourceVersion.isKeyword(behavior.name)) behavior.name + "0" else behavior.name
                val methodSpec = MethodSpec.methodBuilder(newName)
                    .apply {
                        baseBuild(behavior, isStrict)
                        returns(returnClazz.toTypeName())

                        if(behavior.getAttribute("override") != null) addAnnotation(Override::class.java)
                        if(Modifier.isAbstract(behavior.modifiers)) {
                            addModifiers(Modifier2.ABSTRACT)
                        }

                        if(!Modifier.isAbstract(behavior.modifiers) && !Modifier.isNative(behavior.modifiers))
                            behavior.returnType.normalTypeInitStatement()?.let { addStatement("return $it") }
                        if(ctClass.isInterface && !Modifier.isStatic(behavior.modifiers) && !Modifier.isAbstract(
                                behavior.modifiers
                            )
                        ) addModifiers(Modifier2.DEFAULT)
                        if(behavior.name != newName) addAnnotation(AnnotationSpec.get(RenameFrom(behavior.name), true))
                    }.build()
                methodSpecs.add(methodSpec)
            } else if(behavior is CtConstructor) {
                if(Modifier.isStatic(behavior.modifiers)) return@label
                val constructorSpec = MethodSpec.constructorBuilder()
                    .apply {
                        baseBuild(behavior, isStrict)
                        if(ctClass.superclass != null && !ctClass.isEnum) {
                            fun tryToAddSuperStatement(clazz: CtClass) {
                                val first = clazz.declaredConstructors.firstOrNull { !Modifier.isPrivate(it.modifiers) }
                                if(first != null) {
                                    val args = first.parameterTypes.map { it.normalTypeInitStatement()!! }
                                    addStatement("super(${args.joinToString(",")})")
                                } else {
                                    if(clazz.superclass != null) tryToAddSuperStatement(clazz.superclass)
                                }
                            }

                            tryToAddSuperStatement(ctClass.superclass)
                        }
                    }.build()
                methodSpecs.add(constructorSpec)
            }
        }

        ctClass.declaredFields.forEach { ctField ->
            if(ctField.name.contains("this$")) return@forEach
            val newName = if(SourceVersion.isKeyword(ctField.name)) ctField.name + "0" else ctField.name
            val fieldSpec = FieldSpec.builder(ctField.type.toTypeName(), newName)
                .apply {

                    addCommonModifiers(ctField.modifiers, this::addModifiers)
                    if(Modifier.isFinal(ctField.modifiers)) addModifiers(Modifier2.FINAL)
                    if(Modifier.isVolatile(ctField.modifiers)) addModifiers(Modifier2.VOLATILE)
                    if(Modifier.isTransient(ctField.modifiers)) addModifiers(Modifier2.TRANSIENT)
                    if(Modifier.isFinal(ctField.modifiers)) ctField.type.normalTypeInitStatement()?.let {
                        initializer(it)
                    }

                    if(ctField.name != newName) addAnnotation(AnnotationSpec.get(RenameFrom(ctField.name), true))
                    ctField.annotations.map(Any::getAnnotationTypeName).forEach(this::addAnnotation)
                }.build()
            fieldSpecs.add(fieldSpec)
        }

        return when {
            ctClass.isAnnotation -> {
                TypeSpec.annotationBuilder(name)
            }

            ctClass.isEnum -> {
                TypeSpec.enumBuilder(name).apply {
                    fieldSpecs.map { it.name }.forEach(this::addEnumConstant)
                }
            }

            ctClass.isInterface -> {
                TypeSpec.interfaceBuilder(name)
            }

            else -> {
                TypeSpec.classBuilder(name).apply {
                    if(Modifier.isAbstract(ctClass.modifiers)) addModifiers(Modifier2.ABSTRACT)

                    addFields(fieldSpecs)
                    ctClass.superclass?.let {
                        superclass(it.toTypeName())
                    }
                }
            }
        }.apply {
            addCommonModifiers(ctClass.modifiers, this::addModifiers)
            if(!ctClass.isEnum) if(Modifier.isFinal(ctClass.modifiers)) addModifiers(Modifier2.FINAL)
            if(isStrict) addModifiers(Modifier2.STRICTFP)

            addMethods(methodSpecs)

            if(!ctClass.declaredConstructors.any { it.parameterTypes.isEmpty() } && ctClass.isEnum) {
                addMethod(MethodSpec.constructorBuilder().apply {
                    addAnnotation(Additional::class.java)
                }.build())
            }

            ctClass.annotations.map(Any::getAnnotationTypeName).forEach(this::addAnnotation)
            ctClass.interfaces.filter { it.name != "java.lang.annotation.Annotation" }.map { it.toTypeName() }
                .forEach(this::addSuperinterface)
        }
    }
}

private typealias Modifier2 = javax.lang.model.element.Modifier