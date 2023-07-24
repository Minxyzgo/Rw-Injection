package com.github.minxyzgo.rwij

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.minxyzgo.rwij.util.ClassTree
import com.github.minxyzgo.rwij.util.RenameFactory
import javassist.ClassPool
import javassist.bytecode.Descriptor
import java.io.File
import java.io.FileNotFoundException
import java.util.regex.Pattern

enum class Libs {
    `game-lib`,
    `android`,
    `android-platform-lib`,
    `commons-codec` { init {
        realName = "$name-1.6"
    } },
    `commons-logging` { init {
        realName = "$name-1.1.3"
    } },
    `fluent-hc` { init {
        realName = "$name-4.3.3"
    } },
    `httpclient` { init {
        realName = "$name-4.3.3"
    } },
    `httpclient-cache` { init {
        realName = "$name-4.3.3"
    } },
    `httpcore` { init {
        realName = "$name-4.3.2"
    } },
    `httpmime` { init {
        realName = "$name-4.3.3"
    } },
    `ibxm`,
    `jinput`,
    `jnlp`,
    `jogg` { init {
        realName = "$name-0.0.7"
    } },
    `jorbis` { init {
        realName = "$name-0.0.15"
    } },
    `lwjgl`,
    `lwjgl_util`,
    `lwjgl_util_applet`,
    `natives-linux`,
    `slick`,
    `tinylinepp`;

    var realName = name
    var isLoaded = false
        private set

    lateinit var lib: File
    lateinit var cp: Any // ClassPath

    @LibRequiredApi
    val classTree by lazy {
        ClassTree(ClassPool(defClassPool)).apply {
            defPool.childFirstLookup = true
            name = this@Libs.name
        }
    }

    @LibRequiredApi
    fun load(libPath: String) {
        isLoaded = true
        lib = File("${libPath}/$realName.jar")
        if(!lib.exists()) throw FileNotFoundException("cannot find lib: $name")
        cp = defClassPool.appendClassPath(lib.absolutePath)
        if(this in includes) classTree.initByJarFile(lib)
    }

    @LibRequiredApi
    fun initJadx(projectFile: File, otherTree: Array<ClassTree> = emptyArray()) {
        if(!isLoaded) throw RuntimeException("You must load this lib firstly")
        val mapper = ObjectMapper()
        val renameFactory = RenameFactory(classTree, otherTree)
        val descPattern = Pattern.compile("""(^.*)([\(|（].*[\)|）])""")

        val elems = mapper.readTree(projectFile)["codeData"]["renames"].elements()
        for(elem in elems) {
            val newName = elem["newName"].asText()
            val nodeRef = elem["nodeRef"]
            if(!nodeRef.isNull) {
                val declClass = nodeRef["declClass"].asText()
                when(val refType = nodeRef["refType"].asText()) {
                    "METHOD" -> {
                        val shortId = nodeRef["shortId"].asText()
                        val str = descPattern.matcher(shortId)
                        str.find()
                        val name = str.group(1)
                        val desc = str.group(2)
                        println("$name $desc")
                        val method = classTree.defPool[declClass].getDeclaredMethod(
                            name, Descriptor.getParameterTypes(desc, Libs.defClassPool)
                        )
                        renameFactory.renameMethod(method, newName)
                    }

                    "FIELD" -> {
                        val shortId = nodeRef["shortId"].asText()
                        val str = shortId.split(":")
                        val name = str[0]
                        val desc = str[1]
                        renameFactory.renameField(classTree.defPool[declClass].getDeclaredField(name, desc), newName)
                    }

                    "CLASS" -> {
                        renameFactory.renameClass(classTree.defPool[declClass], newName)
                    }

                    "PKG" -> {
                        renameFactory.renamePackage(declClass, newName)
                    }

                    else -> throw java.lang.IllegalArgumentException("unknown refType: $refType")
                }
            }
        }

        renameFactory.rename()
    }

    companion object {
        @JvmStatic
        @LibRequiredApi
        val defClassPool by lazy {
            ClassPool().apply {
                appendSystemPath()
            }
        }

        /**
         * 需要被加载为[ClassTree]的lib, 默认只需要game-lib被加载
         */
        val includes by lazy { mutableListOf(`game-lib`) }
    }
}