package rwij

import com.squareup.javapoet.*
import javassist.*
import javassist.bytecode.AttributeInfo
import javassist.bytecode.Descriptor
import rwij.annotations.Additional
import rwij.annotations.RenameFrom
import rwij.util.Node
import rwij.util.NodeTree
import java.io.File
import java.net.URLClassLoader
import java.util.*
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream
import javax.lang.model.SourceVersion
import kotlin.math.max

/**
 * 解析rw bytecode 生成仅包含签名的(可编译的)java文件
 * 可以解析绝大部分bytecode， 少数enum和构造函数需手动修改
 */
object Builder {
    lateinit var urlClassLoader: URLClassLoader
    lateinit var pool: ClassPool

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

    fun buildNewClassTree(resource: String = "game-lib.jar"): Pair<ClassPool, NodeTree> {
        val packageList: List<String>
        val cp = ClassPool.getDefault()
        //用于解析内部类
        val classTree = NodeTree()
        // classTree struct:
        /*
        class name - class data
         */
        val cl = javaClass.classLoader
        cl.getResourceAsStream(resource)!!.use { lib ->
            val tempFile = File.createTempFile("$resource-temp", ".jar")
            tempFile.deleteOnExit()
            tempFile.writeBytes(lib.readBytes())
            packageList = buildList {
                ZipFile(tempFile).entries().toList().mapNotNull {
                    if(it.isDirectory) {
                        add(Descriptor.toJavaName(it.name).removeSuffix("."))
                        return@mapNotNull null
                    }

                    if(it.name.endsWith(".class")) it.name.removeSuffix(".class").replace("/", ".") else null
                }.forEach(classTree::addChild)
            }

            cp.appendClassPath(tempFile.absolutePath)
            cp.appendClassPath(LoaderClassPath(cl))

            urlClassLoader = URLClassLoader(arrayOf(tempFile.toURI().toURL()), cl)
            classTree.map { it.value as String }.forEach(urlClassLoader::loadClass)
        }

        deobfuscation(packageList, classTree, cp)
        return cp to classTree
    }

    fun buildJar(jar: File, classList: NodeTree, cp: ClassPool) {
        val zipOut = ZipOutputStream(
            jar.outputStream()
        )

        zipOut.use { zip ->
            classList.toClassList(cp).forEach {
                zip.putNextEntry(ZipEntry(Descriptor.toJvmName(it) + ".class"))
                zip.write(it.toBytecode())
            }
        }
    }


    fun NodeTree.toClassList(cp: ClassPool) = this.map { cp[it.value as String] }

    internal fun build(file: File, modTime: Long) {
        val classTree: NodeTree
        val pair = buildNewClassTree()
        pool = pair.first
        classTree = pair.second
        buildCode(file, classTree, modTime)
    }

    private fun buildCode(file: File, classList: NodeTree, modTime: Long) {
        classList.filter {
            !(it.value as String).contains("$")
        }.forEach { node ->
            val ctClass = pool[node.value as String]

            val classFile = File(file.absolutePath + "\\" + ctClass.name.replace(".", "\\") + ".java")

            if(classFile.exists() && classFile.lastModified() != modTime && modTime != 0L)
                return@forEach

            try {
                fun TypeSpec.Builder.buildInnerClass(node_: Node = node) {
                    node_.forEach loop@{ node ->
                        val (name, isStatic, clazz) = node.value as CtClassData
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

    /**
     * 反混淆类，对于所给的类列表和包列表， 将进行以下操作
     * 重命名与包名冲突的类
     * 重命名不符合命名规范的类
     * @param classTree 同于内联内部类， 方便javapoet输出
     */
    private fun deobfuscation(
        packageList: List<String>,
        classTree: NodeTree,
        cp: ClassPool
    ) {
        var index = 0
        val classList_ = classTree.sortedBy { (it.value as String).count { c -> c == '$' } }
        val classRenames = mutableMapOf<String, String>()

        val renameMap = classList_
            .mapNotNull { node ->
                val ctClazz = cp.get(node.value as String)
                if(ctClazz.name.contains("$")) {
                    val list = ctClazz.name.split("$")
                    val mutList = list.toMutableList()

                    //提取要内联的内部类
                    var node2 = /*classTree.firstNotNullOfOrNull {
                        if(it.value == classRenames[list[0]]) it else null
                    }  ?: */classTree.first { it.value == list[0] }

                    classRenames[list[0]]?.let { mutList[0] = cp[it].name }

                    //获取路径前一个node
                    list.subList(1, list.size - 1).forEachIndexed { i, str ->
                        node2 = node2.first { (it.value as CtClassData).simpleName == str }
                        mutList[i + 1] = (node2.value as CtClassData).ctClazz.innerName
                    }
                    //拼接完整路径以获取类
                    val path = list.joinToString("$")
                    val clazz = cp[path]

                    val name = list.last()

                    var newPath = path

                    //判断名称是否规范， 并重命名
                    if(name.first().isDigit()) {
                        val newName = "${getInnerName2(mutList.joinToString("$"))}$index"
                        newPath = mutList.subList(0, mutList.size - 1).joinToString("$") + "$$newName"
                        clazz.name = Descriptor.toJavaName(newPath)
                        index++
                    }

                    val isStatic = !clazz.declaredFields.any { it.name.contains("this$") }
                    node2.addChild(CtClassData(name, isStatic, clazz))
                    path to newPath
                } else if(ctClazz.name in packageList || SourceVersion.isKeyword(ctClazz.simpleName)) {
                    val oldName = ctClazz.name
                    val newName = oldName + index
                    index++
                    ctClazz.name = Descriptor.toJavaName(newName)
                    classRenames[oldName] = newName
                    oldName to newName
                } else {
                    null
                }
            }.associate { it }.run {
                val classMap = ClassMap()
                this.forEach(classMap::put)
                classMap
            }
        classList_.onEach {
            it.value =
                Descriptor.toJavaName(renameMap[Descriptor.toJvmName(it.value as String)] ?: (it.value as String))
        }.map { cp.get(it.value as String) }.forEach { it.replaceClassName(renameMap) }
    }

    data class CtClassData(val simpleName: String, val isStatic: Boolean, val ctClazz: CtClass)
}

/**
 * ## 由于strictfp是编译时添加，此函数用于判断一个ctClass是否包含strictfp，现有以下规则：
 * ### 若类中所有声明的函数均包含strictfp修饰符，则该类包含strictfp修饰符 (自父类或接口中覆写的方法不计其中)。
 * ### 同时对所有方法进行检查是否覆写父类或接口方法，并将结果写入字节码中。(此方法可能会对ctClass进行[CtClass.defrost]操作，因此不应使用[CtClass.prune])
 */
private val CtClass.isStrict: Boolean
    get() {
        var contain = false
        if(declaredBehaviors.isNotEmpty()) {
            contain = true
            for(method in declaredBehaviors) {
                if(Modifier.isAbstract(method.modifiers)) continue
                if(method is CtMethod && method.isOverride) {
                    if(this.isFrozen) defrost()
                    method.methodInfo.addAttribute(AttributeInfo(classFile.constPool, "override", byteArrayOf()))
                    method.methodInfo.rebuildStackMap(classPool)
                    continue
                }

                if(contain) contain = Modifier.isStrict(method.modifiers)
            }
        }


        return if(!isInterface)
            this.declaredConstructors.any { Modifier.isStrict(it.modifiers) }
        else contain
    }

/**
 * 检查方法是否自接口或父类覆写， 注意不会检查自Object内覆写的方法
 */
private val CtMethod.isOverride: Boolean
    get() {
        var result = false

        fun checkIfMethodInClass(target: CtClass): Boolean {
            return target.declaredMethods.let { methods ->
                if(Modifier.isStatic(this.modifiers)
                    || Modifier.isAbstract(this.modifiers)
                ) return@let false
                loop@ for(ctMethod in methods) {
                    if(ctMethod.name != this.name || Modifier.isPrivate(ctMethod.modifiers)
                        || this.parameterTypes.size != ctMethod.parameterTypes.size
                    ) continue
                    for((index, clazz) in this.parameterTypes!!.withIndex()) {
                        if(ctMethod.parameterTypes[index] != clazz) {
                            continue@loop
                        }
                    }

                    return@let true
                }

                false
            }
        }

        fun checkDeclaredMethodInSuperclass(superClass: CtClass) {
            result = checkIfMethodInClass(superClass)

            if(!result && superClass.superclass != null)
                checkDeclaredMethodInSuperclass(superClass.superclass)
        }

        fun checkDeclaredMethodInInterface(classes: Array<CtClass>) {
            val stack = Stack<CtClass>().apply { addAll(classes) }
            while(stack.isNotEmpty()) {
                val ctClass = stack.pop()
                result = checkIfMethodInClass(ctClass)
                if(!result && ctClass.interfaces.isNotEmpty()) {
                    checkDeclaredMethodInInterface(ctClass.interfaces)
                    if(result) break
                } else {
                    break
                }
            }
        }

        checkDeclaredMethodInSuperclass(declaringClass.superclass)
        if(!result && declaringClass.interfaces.isNotEmpty()) {
            checkDeclaredMethodInInterface(declaringClass.interfaces)
        }

        return result
    }

/**
 * 将[CtClass]的name转换为符合javaPoet规范的[TypeName]
 */
private fun CtClass.toTypeName(): TypeName {
    val countRegex = Regex("""\[]""")

    fun getOuterClass(clazz: CtClass): CtClass = if(clazz.isArray) getOuterClass(clazz.componentType) else clazz

    val outerClass = getOuterClass(this)
    val baseType = when(outerClass.name) {
        "int" -> Int::class.java
        "byte" -> Byte::class.java
        "long" -> Long::class.java
        "short" -> Short::class.java
        "float" -> Float::class.java
        "double" -> Double::class.java
        "char" -> Char::class.java
        "boolean" -> Boolean::class.java
        "void" -> Void.TYPE
        else -> null
    }
    val clazzName = if(baseType != null) {
        TypeName.get(baseType)
    } else if(outerClass.name.contains("$")) {
        val allName = innerPattern.findAll(".${outerClass.name.removePrefix(outerClass.packageName)}").toList()
            .map(MatchResult::value)
        ClassName.get(outerClass.packageName, allName[0], *allName.run { takeLast(size - 1).toTypedArray() })
    } else {
        ClassName.get(outerClass.packageName, outerClass.simpleName)
    }

    return if(isArray) {
        var arrayTypeName = ArrayTypeName.of(clazzName)
        var i = 0
        while(i < (countRegex.findAll(name).toList().size - 1)) {
            arrayTypeName = ArrayTypeName.of(arrayTypeName)
            i++
        }

        arrayTypeName
    } else clazzName
}

private fun Any.getAnnotationTypeName(): ClassName =
    Builder.pool[(this as Annotation).annotationClass.java.name].toTypeName() as ClassName

private fun CtClass.toClass0_(): Class<*> = try {
    when(name) {
        "int" -> Int::class.java
        "byte" -> Byte::class.java
        "long" -> Long::class.java
        "short" -> Short::class.java
        "float" -> Float::class.java
        "double" -> Double::class.java
        "char" -> Char::class.java
        "boolean" -> Boolean::class.java
        "void" -> Void.TYPE
        else -> {
            Class.forName(
                Descriptor.toJavaName(
                    if(isArray) Descriptor.of(this) else name
                ), false, Builder.urlClassLoader
            )
        }
    }

} catch(e: ClassNotFoundException) {
    if(isArray) {
        componentType.toClass0_()
        toClass0_()
    } else {
        toClass(Builder.urlClassLoader)
    }
}

private fun CtClass.normalTypeInitStatement(): String? = when(this) {
    CtClass.charType -> "' '"
    CtClass.booleanType -> "false"
    CtClass.byteType, CtClass.intType, CtClass.longType, CtClass.shortType -> "0"
    CtClass.floatType -> "0f"
    CtClass.doubleType -> "0d"
    CtClass.voidType -> null
    else -> "null"
}

private val innerPattern = Regex("""(?<=\.|\$)\w+""")

/**
 * 获取[CtClass.getSimpleName] (以‘$'分割) 的最后一个元素，否则返回自身
 */
private val CtClass.innerName: String
    get() = if(simpleName.contains("$"))
        simpleName.substring(simpleName.lastIndexOf('$') + 1)
    else simpleName


/**
 * 获取[CtClass.getSimpleName] (以‘$'分割) 的倒数第二个元素
 */
private fun getInnerName2(name: String) = innerPattern.findAll(name).toList().let {
    it[max(0, it.size - 2)].value
}

private typealias Modifier2 = javax.lang.model.element.Modifier