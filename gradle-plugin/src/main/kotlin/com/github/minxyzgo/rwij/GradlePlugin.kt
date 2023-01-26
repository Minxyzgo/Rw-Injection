@file:Suppress("unused")

package com.github.minxyzgo.rwij

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.tasks.SourceSet
import java.io.File

@OptIn(LibRequiredApi::class)
open class GradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        rootProject = target
        Builder.libDir = rootProject.projectDir.absolutePath + "/lib"
        Builder.useCache = false
        Builder.releaseLibAction = {}

        target.extensions.create("injection", InjectionExtension::class.java)
        target.task("rebuildJar") { task ->
            task.doLast {
                with(Builder) {
                    val injectionExtension = target.extensions.getByType(InjectionExtension::class.java)
                    injectionExtension.initJadxActions.forEach { t -> t.second.initJadx(t.first, t.third.map { it.classTree }.toTypedArray()) }
                    injectionExtension.proxyList.forEach { ProxyFactory.setProxy(it.first.classTree, *it.second) }
                    injectionExtension.deobfActions.forEach { deobfuscation(it.classTree) }
                    saveLib()
                }
            }
        }

        target.afterEvaluate {
            releaseLib()
            Builder.loadLib()
        }
    }

    companion object {
        lateinit var rootProject: Project
        @JvmOverloads
        fun DependencyHandler.injectRwLib(
            version: String,
            useRuntimeLib: Boolean = false,
        ): Unit = with(rootProject){
            implementation("com.github.minxyzgo.rw-injection:core:$version")
            if(useRuntimeLib) {
                implementation("org.javassist:javassist:3.29.2-GA")
                implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4")
                val sourceSets = extensions.getByName("sourceSets") as org.gradle.api.tasks.SourceSetContainer
                val main = sourceSets.named("main", SourceSet::class.java)
                main.get().resources {
                    it.srcDir(Builder.libDir)
                }
            } else {
                implementation(fileTree(mapOf("dir" to "$projectDir/lib", "include" to "*.jar")))
            }
        }

        private fun DependencyHandler.implementation(dependencyNotation: Any) = add("implementation", dependencyNotation)
        private fun releaseLib() {
            val injectionExtension = rootProject.extensions.getByType(InjectionExtension::class.java)
            Libs.values().forEach { lib ->
                (injectionExtension.libMapping[lib]?.let { File(it) }?.inputStream()
                    ?:
                    GradlePlugin::class.java.classLoader
                        .getResourceAsStream("${lib.realName}.jar")!!).use {
                    val jarFile = File("${Builder.libDir}/${lib.realName}.jar")
                    if(!jarFile.exists()) {
                        jarFile.parentFile.mkdirs()
                        jarFile.createNewFile()
                    }

                    jarFile.writeBytes(it.readBytes())
                }
            }
        }
    }

    open class InjectionExtension {
        internal val proxyList = mutableListOf<Pair<Libs, Array<out Any>>>()
        internal val deobfActions = mutableListOf<Libs>()
        internal val initJadxActions = mutableListOf<Triple<File, Libs, Array<Libs>>>()

        val libMapping = mutableMapOf<Libs, String>()

        fun setProxy(
            lib: Libs = Libs.`game-lib`,
            vararg proxyList: Any
        ) {
            this.proxyList.add(lib to proxyList)
        }

        fun deobfuscation(
            classTree: Libs,
        ) {
            deobfActions.add(classTree)
        }
        fun initJadx(
            fileName: String,
            dir: String = rootProject.projectDir.absolutePath,
            lib: Libs = Libs.`game-lib`,
            otherTree: Array<Libs> = emptyArray()
        ) {
            initJadxActions.add(Triple(File("$dir/$fileName.jadx"), lib, otherTree))
        }
    }
}

