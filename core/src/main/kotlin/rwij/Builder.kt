package rwij

import com.squareup.javapoet.ArrayTypeName
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.TypeName
import javassist.*
import javassist.bytecode.AttributeInfo
import javassist.bytecode.Descriptor
import rwij.util.ClassTree
import rwij.util.NodeTree
import java.io.File
import java.util.*
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream
import javax.lang.model.SourceVersion
import kotlin.math.max

object Builder {
    var libDir = "lib"

    val defClassPool = ClassPool().apply {
        appendClassPath(LoaderClassPath(ClassLoader.getSystemClassLoader()))
    }

    val libraries = setOf(
        "game-lib",
        "android",
        "commons-codec-1.6",
        "commons-logging-1.1.3",
        "fluent-hc-4.3.3",
        "httpclient-4.3.3",
        "httpclient-cache-4.3.3",
        "httpcore-4.3.2",
        "httpmime-4.3.3",
        "ibxm",
        "jinput",
        "jnlp",
        "jogg-0.0.7",
        "jorbis-0.0.15",
        "lwjgl",
        "lwjgl_util",
        "lwjgl_util_applet",
        "natives-linux",
        "slick",
        "tinylinepp"
    ).associateWith {
        ClassTree(ClassPool(defClassPool)).apply {
            defPool.childFirstLookup = true
            name = it
            longName = it
        }
    }

    /**
     * 排除不必要加载为[ClassTree]的jar，但仍会写入[defClassPool]的路径。默认为不包括game-lib以外的所有jar库
     */
    val excludes = libraries.keys.toMutableSet().apply { remove("game-lib") }

    /**
     * 给定库名，获取对应的[ClassTree]，请注意，此方法应在[loadLib]后调用，否则返回的[ClassTree]内容为空
     */
    fun getClassTreeByLibName(name: String) = libraries[name]!!

    /**
     * 保存现有已修改的lib到[libDir]
     */
    fun saveLib() {
         libraries.forEach { (k, v) ->
             val jarFile = File("$libDir/$k.jar")
             buildJar(jarFile, v.allClasses)
         }
    }

    /**
     * 根据[libDir]加载lib，若[libDir]不存在，则调用[releaseLib]
     */
    fun loadLib() {
        val libFile = File(libDir)
        if(!libFile.exists()) {
            libFile.mkdirs()
            releaseLib()
        }

        libraries.forEach { (k, v) ->
            val jarFile = File("$libDir/$k.jar")
            if(excludes.contains(k) || !jarFile.exists()) return@forEach
            defClassPool.appendClassPath(jarFile.absolutePath)
            v.initByJarFile(jarFile)
        }
    }

    /**
     * 释放包内的lib资源到[libDir]
     */
    fun releaseLib() {
        val cl = ClassLoader.getSystemClassLoader()
        libraries.forEach { (k, _) ->
            cl.getResourceAsStream("$k.jar")!!.use {
                val jarFile = File("$libDir/$k.jar")
                if(!jarFile.exists()) jarFile.createNewFile()
                jarFile.writeBytes(it.readBytes())
            }
        }
    }

    /**
     * 仅用于生成代码用，应用程序应使用[saveLib]，[loadLib]或[releaseLib]
     */
    fun buildNewClassTree(resource: String = "game-lib.jar"): Pair<ClassPool, NodeTree> {
        val packageList: List<String>

        val child = ClassPool(defClassPool)
        child.childFirstLookup = true
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

            child.appendClassPath(tempFile.absolutePath)
        }

        deobfuscation(packageList, classTree, child)
        return child to classTree
    }

    /**
     * 给定文件和类列表生成jar
     * @param jar 生成jar的文件
     * @param classes 给定的类列表
     */
     fun buildJar(jar: File, classes: Iterable<CtClass>) {
        val tempFile = File.createTempFile("temp-${jar.name}", ".jar")
        val zipOut = ZipOutputStream(
            tempFile.outputStream()
        )

        zipOut.use { zip ->
            classes.forEach {
                zip.putNextEntry(ZipEntry(Descriptor.toJvmName(it) + ".class"))
                zip.write(it.toBytecode())
            }
        }

        val arr = tempFile.readBytes()
        jar.writeBytes(arr)
        tempFile.delete()
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
        }.map {
            cp.get(it.value as String)
        }.forEach { it.replaceClassName(renameMap) }
    }

    data class CtClassData(val simpleName: String, val isStatic: Boolean, val ctClazz: CtClass)
}

fun NodeTree.toClassList(cp: ClassPool) = this.map { cp[it.value as String] }

/**
 * ## 由于strictfp是编译时添加，此函数用于判断一个ctClass是否包含strictfp，现有以下规则：
 * ### 若类中所有声明的函数均包含strictfp修饰符，则该类包含strictfp修饰符 (自父类或接口中覆写的方法不计其中)。
 * ### 同时对所有方法进行检查是否覆写父类或接口方法，并将结果写入字节码中。(此方法可能会对ctClass进行[CtClass.defrost]操作，因此不应使用[CtClass.prune])
 */
val CtClass.isStrict: Boolean
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
fun CtClass.toTypeName(): TypeName {
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

fun Any.getAnnotationTypeName(): ClassName =
    CodeBuilder.pool[(this as Annotation).annotationClass.java.name].toTypeName() as ClassName

fun CtClass.normalTypeInitStatement(): String? = when(this) {
    CtClass.charType -> "' '"
    CtClass.booleanType -> "false"
    CtClass.byteType, CtClass.intType, CtClass.longType, CtClass.shortType -> "0"
    CtClass.floatType -> "0f"
    CtClass.doubleType -> "0d"
    CtClass.voidType -> null
    else -> "null"
}

fun CtClass.transformClass(): Class<*>  {
    return when(name) {
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
                ), false, ClassLoader.getSystemClassLoader()
            )
        }
    }
}

fun Class<*>.normalTypeInitStatement(): Any? = when(this) {
    Char::class.java -> ' '
    Boolean::class.java -> false
    Byte::class.java, Int::class.java, Long::class.java, Short::class.java -> 0
    Unit::class.java -> Unit
    Float::class.java, Double::class.java -> 0f
    else -> null
}

private val innerPattern = Regex("""(?<=\.|\$)\w+""")

/**
 * 获取[CtClass.getSimpleName] (以‘$'分割) 的最后一个元素，否则返回自身
 */
val CtClass.innerName: String
    get() = if(simpleName.contains("$"))
        simpleName.substring(simpleName.lastIndexOf('$') + 1)
    else simpleName


/**
 * 获取[CtClass.getSimpleName] (以‘$'分割) 的倒数第二个元素
 */
internal fun getInnerName2(name: String) = innerPattern.findAll(name).toList().let {
    it[max(0, it.size - 2)].value
}
