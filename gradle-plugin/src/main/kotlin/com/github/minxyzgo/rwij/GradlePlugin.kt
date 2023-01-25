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
        val libFile = File(Builder.libDir)
        if(!libFile.exists()) Builder.releaseLib(GradlePlugin::class.java.classLoader)
        Builder.loadLib()
        target.extensions.create("injection", InjectionExtension::class.java)
        target.task("rebuildJar") { task ->
            task.doFirst { Builder.releaseLib(GradlePlugin::class.java.classLoader) }
            task.doLast {
                val injectionExtension = target.extensions.getByType(InjectionExtension::class.java)
                with(Builder) {
                    injectionExtension.initJadxActions.forEach { t -> t.second.initJadx(t.first, t.third.map { it.classTree }.toTypedArray()) }
                    injectionExtension.proxyList.forEach { ProxyFactory.setProxy(it.first.classTree, *it.second) }
                    injectionExtension.deobfActions.forEach { deobfuscation(it.classTree) }
                    saveLib()
                }
            }
        }
    }

    companion object {
        lateinit var rootProject: Project
        @JvmOverloads
        fun DependencyHandler.injectRwLib(
            version: String,
            useRuntimeLib: Boolean = false,
            libDir: String = "lib"
        ): Unit = with(rootProject){
            Builder.libDir = rootProject.projectDir.absolutePath + "/" + libDir

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
                implementation(fileTree(mapOf("dir" to "$rootDir/$libDir", "include" to "*.jar")))
            }
        }

        private fun DependencyHandler.implementation(dependencyNotation: Any) = add("implementation", dependencyNotation)
    }

    open class InjectionExtension {
        internal val proxyList = mutableListOf<Pair<Libs, Array<out Any>>>()
        internal val deobfActions = mutableListOf<Libs>()
        internal val initJadxActions = mutableListOf<Triple<File, Libs, Array<Libs>>>()

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

