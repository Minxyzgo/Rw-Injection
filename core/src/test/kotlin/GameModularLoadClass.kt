/*
 * Copyright 2020-2023 RW-HPS Team and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/RW-HPS/RW-HPS/blob/master/LICENSE
 */

import java.io.ByteArrayInputStream
import java.io.InputStream

/**
 * Broken Java parent delegation mechanism
 * To complete the isolation loading Class
 *
 * Java Class 加载机制
 * ```
 * The Java platform uses a delegation model for loading classes.
 * The basic idea is that every class loader has a "parent" class loader.
 * When loading a class, a class loader first "delegates" the search for the class to its parent class loader before attempting to find the class itself.
 *
 * ```
 *
 * @property mainClassLoader MainClassLoader (Load RW-HPS.class ...)
 * @property jdkClassLoader ClassLoader (Load Java.lang.* class)
 * @property classPathMap OrderedMap<String, ByteArray>
 *
 * @author RW-HPS/Dr
 */
class GameModularLoadClass(
    private val mainClassLoader: ClassLoader,
    private val jdkClassLoader: ClassLoader,
    private val classPathMap: MutableMap<String, ByteArray> = mutableMapOf()
) : ClassLoader() {
    private val hashCode = Integer.toHexString(hashCode())

    /**
     * Get all the Bytes of this loader, for the next reuse, and at the same time make each loader share the byte pool
     */
    val classPathMapData get() = classPathMap

    /**
     * Add Jar to loader (load with bytes)
     * @param bytes ByteArray
     */
    fun addSourceJar(bytes: ByteArray) {
        addSourceJar(ByteArrayInputStream(bytes))
    }

    /**
     * Add Jar to loader (load with stream)
     * @param inStream InputStream
     */
    fun addSourceJar(inStream: InputStream) {
        // [CompressionDecoderUtils.zipStream] cannot be used here, otherwise it will prompt ZIP 0x0
        // I do not know why either
//        CompressionDecoderUtils.zipSeek(inStream).also {
//            it.getZipAllBytes().forEach {
//                var name = it.key
//                if (name.startsWith("/")) {
//                    name = name.substring(1)
//                }
//                name = name.replace(".class","")
//                classPathMap.put(name,it.value)
//            }
//        }.close()
    }

    /**
     * Add byte hot to this loader
     *
     * @param name String
     * @param bytes ByteArray
     */
    fun addClassBytes(name: String, bytes: ByteArray, cove: Boolean = false) {
        if (!classPathMap.containsKey(name.replace(".","/")) || cove) {
            classPathMap.put(name.replace(".", "/"), bytes)
        }
    }

    /**
     * Add byte hot to this loader
     * If it has been hot loaded, then use [Class.forName] directly
     *
     * @param name String
     * @param bytes ByteArray
     * @return Class<*>?
     */
    fun loadClassBytes(name: String, bytes: ByteArray): Class<*>? {
        if (classPathMap.containsKey(name.replace(".","/"))) {
            return name.toClass(this)
        }
        classPathMap.put(name.replace(".", "/"), bytes)
        return name.toClass(this)
    }

    /**
     * Finds the class with the specified binary name
     * This method should be overridden by class loader implementations that
     * follow the delegation model for loading classes, and will be invoked by
     * the [loadClass] method after checking the
     * parent class loader for the requested class.
     *
     * @param   nameIn The name of the class
     * @return  The resulting {@code Class} object
     * @throws  ClassNotFoundException If the class could not be found
     */
    @Throws(ClassNotFoundException::class)
    public override fun findClass(nameIn: String): Class<*>? {
        val name = nameIn.replace(".","/")
        var classBytes: ByteArray? = classPathMap[name]
        if (classBytes == null || classBytes.isEmpty()) {
            throw ClassNotFoundException()
        }

        return defineClass(null,classBytes, 0, classBytes.size)
    }

    @Throws(ClassNotFoundException::class)
    override fun loadClass(nameIn: String, resolve: Boolean): Class<*>? {
        var result: Class<*>? = null
        try {
            //Here we need to u se the JDK class loader to load the classes in the java.lang package
            result = jdkClassLoader.loadClass(nameIn)
        } catch (_: Exception) {
            //忽略
        }
        if (result != null) {
            return result
        }

        val name = nameIn.replace(".","/")
        var classBytes: ByteArray? = classPathMap[name]

        if (classBytes == null || classBytes.isEmpty()) {
            try {
                result = mainClassLoader.loadClass(nameIn)
            } catch (_: Exception) {
                //忽略
            }

            if (result != null) {
                return result
            }

            throw ClassNotFoundException()
        }
        return defineClass(null,classBytes, 0, classBytes.size)
    }

    /**
     * Make [ClassLoader.getResourceAsStream] get valid bytes
     * Compatible with [net.rwhps.asm.transformer.SafeClassWriter]
     *
     * @param  path
     * @return [ByteArrayInputStream]
     */
    override fun getResourceAsStream(path: String): InputStream? {
        val classBytes: ByteArray? = classPathMap[path.replace(".class","")]
        return if (classBytes == null) {
            return null
        } else {
            ByteArrayInputStream(classBytes)
        }
    }

    override fun toString(): String {
        return "${javaClass.simpleName}@$hashCode"
    }

    fun String.toClass(loader: ClassLoader?): Class<*>? {
        return loader?.let {
            Class.forName(this,false,loader)
        } ?: Class.forName(this)

    }
}