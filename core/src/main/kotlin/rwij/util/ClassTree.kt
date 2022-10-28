package rwij.util

import javassist.ClassPool
import javassist.CtClass
import javassist.bytecode.Descriptor
import java.io.File
import java.util.zip.ZipFile

@Suppress("unused")
class ClassTree(
    val defPool: ClassPool,
) {
    val packages = mutableSetOf<ClassTree>()
    val classesName = mutableSetOf<String>()
    var longName: String = ""
    var name: String = ""
    var root: ClassTree = this

    val allClasses: Set<CtClass> by lazy {
        if(this != root) {
            root.allClasses
        } else {
            val result = mutableSetOf<CtClass>()
            var next = root

            fun add() {
                result.addAll(next.classesName.map { defPool["${next.longName}.$it"] })
                next.packages.forEach {
                    next = it
                    add()
                }
            }

            add()
            result.toSet()
        }
    }

    val allPackageFromRoot: MutableMap<String, ClassTree> by lazy {
        if(this != root) {
            root.allPackageFromRoot
        } else {
            mutableMapOf()
        }
    }

    fun findTreeByPackage(
        packageName: String,
        findFromRoot: Boolean = false,
        index: Int = 0,
        arr: List<String> = packageName.split("."),
    ): ClassTree {
        if(findFromRoot) return allPackageFromRoot[packageName]
            ?: throw IllegalArgumentException("package:$packageName is not in the root.")
        val first = packages.firstOrNull { arr[index] == packageName }
        return (if(index == arr.size - 1) first else
            first?.findTreeByPackage(name))
            ?: throw IllegalArgumentException("Cannot find package: $packageName by the given name from the current tree.")
    }

    fun loadCtClass(name: String, findByChildren: Boolean = false): CtClass {
        val ctClassName = loadCtClass0(name, findByChildren)
        return defPool[ctClassName
            ?: throw IllegalArgumentException("Cannot find ctClass by the given name from the current tree.")]
    }

    fun initByJarFile(jar: File) {
        defPool.appendClassPath(jar.absolutePath)
        ZipFile(jar).entries().toList().mapNotNull {
            if(it.name.contains("META-INF")) {
                return@mapNotNull null
            }

            if(it.name.endsWith(".class")) it.name.removeSuffix(".class").replace("/", ".") else null
        }.forEach {
            val packageName = it.substring(0, it.lastIndexOf('.'))
            addPackageTree(packageName)
            allPackageFromRoot[packageName]!!.classesName.add(it.substring(it.lastIndexOf('.') + 1, it.lastIndex + 1))
        }
    }

    private fun addPackageTree(name: String) {
        if(this.root != this) throw RuntimeException()
        if(allPackageFromRoot[name] != null) return

        fun newTree(str: String, fullName: String): ClassTree {
            val tree = ClassTree(defPool).apply {
                this.name = str
                this@apply.root = this@ClassTree.root
                this.longName = fullName
            }

            allPackageFromRoot[fullName] = tree
            return tree
        }

        var nextTree = root

        val arr = name.split(".")
        for((i ,str) in arr.withIndex()) {
            val fullName = arr.take(i + 1).joinToString(".")
            nextTree = nextTree.packages.firstOrNull { it.name == str } ?: newTree(str, fullName).also { nextTree.packages.add(it) }
        }
    }

    private fun loadCtClass0(name: String, findByChildren: Boolean): String? {
        var realName: String? = null
        if(name in classesName) realName = name
        if(realName == null && findByChildren) {
            for(tree in packages) {
                realName = tree.loadCtClass0(name, true)
                if(realName != null) break
            }
        }

        return realName
    }
}