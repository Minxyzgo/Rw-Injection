package com.github.minxyzgo.rwij

import com.github.minxyzgo.rwij.util.ClassTree
import javassist.ClassMap
import javassist.CtClass
import javassist.bytecode.Descriptor
import java.io.File
import java.io.FileNotFoundException
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.lang.model.SourceVersion

@Suppress("MemberVisibilityCanBePrivate")
object Builder {
    var libDir = "lib"
    var useCache = true
    var releaseLibActions = mutableMapOf<Libs, (Libs, File, ClassLoader) -> Unit>()

    /**
     * 保存现有已修改的lib到[libDir]
     */
    @LibRequiredApi
    fun saveLib() {
         Libs.includes.forEach { v ->
             val jarFile = File("$libDir/${v.realName}.jar")
             buildJar(jarFile, v.classTree.allClasses)
         }
    }

    /**
     * 根据[libDir]加载lib，若[libDir]不存在，则返回[FileNotFoundException]
     *
     * 如果[useCache]为false，则调用[releaseLibAction]释放资源
     */
    @LibRequiredApi
    fun loadLib() {
        val libFile = File(libDir)
        if(!libFile.exists()) {
            throw FileNotFoundException("libFile: $libDir is not exists")
        }

        if(!useCache) releaseLibs()

        Libs.values().forEach {
            it.load(libDir)
        }
    }

    /**
     * 释放包内的lib资源到[libDir]
     */
    fun releaseLibs(cl: ClassLoader = Thread.currentThread().contextClassLoader) {
        Libs.values().forEach { releaseLib(cl, it) }
    }

    /**
     * 释放包内指定的lib资源到[libDir]
     */
    fun releaseLib(cl: ClassLoader = Thread.currentThread().contextClassLoader, lib: Libs, libName: String = lib.realName) {
        val jarFile = File("$libDir/${libName}.jar")
        releaseLibActions[lib]?.let {
            it(lib, jarFile, cl)
        } ?: cl.getResourceAsStream("${libName}.jar")!!.use {
            if(!jarFile.exists()) {
                jarFile.parentFile.mkdirs()
                jarFile.createNewFile()
            }

            jarFile.writeBytes(it.readBytes())
        }
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
                it.defrost()
            }
        }

        val arr = tempFile.readBytes()
        jar.writeBytes(arr)
        tempFile.delete()
    }

    /**
     * 反混淆类，对于所给的类列表和包列表， 将进行以下操作
     * 重命名与包名冲突的类
     */
    @LibRequiredApi
    fun deobfuscation(
        classTree: ClassTree,
    ) {
        var index = 0
        val renameMap = buildList {
            classTree.forEachAllClassesWithTree { ctClazz, classTree ->
                if(ctClazz.name in classTree.allPackageFromRoot.map { it.key } || SourceVersion.isKeyword(ctClazz.simpleName)) {
                    val oldName = ctClazz.name
                    val newName = oldName + index
                    classTree.classesName.remove(ctClazz.simpleName)
                    classTree.classesName.add(ctClazz.simpleName + index)
                    index++
                    ctClazz.name = Descriptor.toJavaName(newName)
                    add(oldName to newName)
                }
            }
        }.associate { it }.run {
                val classMap = ClassMap()
                this.forEach(classMap::put)
                classMap
            }
        classTree.allClasses.forEach { it.replaceClassName(renameMap) }
    }
}

@LibRequiredApi
fun CtClass.normalTypeInitStatement(): String? = when(this) {
    CtClass.charType -> "' '"
    CtClass.booleanType -> "false"
    CtClass.byteType, CtClass.intType, CtClass.longType, CtClass.shortType -> "0"
    CtClass.floatType -> "0f"
    CtClass.doubleType -> "0d"
    CtClass.voidType -> null
    else -> "null"
}

@LibRequiredApi
@Suppress("unused")
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

@LibRequiredApi
fun Class<*>.normalTypeInitStatement(): Any? = when(this) {
    Char::class.java -> ' '
    Boolean::class.java -> false
    Byte::class.java, Int::class.java, Long::class.java, Short::class.java -> 0
    Unit::class.java -> Unit
    Float::class.java, Double::class.java -> 0f
    else -> null
}
