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
        Builder.libDir = target.buildDir.absolutePath + "/generated/lib"
        Builder.useCache = false

        extension = target.extensions.create("injectionMultiplatform", InjectionMultiplatformExtension::class.java)

        target.task("rebuildJar") { task ->
            task.doLast {
                with(Builder) {
                    extension.multiplatformTargets.forEach { (target, injectionExtension) ->
                        if(target == MultiplatformTarget.Android) {
                            // for android - only need to load game-lib
                            releaseLib(lib = Libs.`android-game-lib`)
                            releaseLib(lib = Libs.android)
                            Libs.`android-game-lib`.load(libDir)
                            // for android, Changing android .jar is useless
                            Libs.android.load(libDir)
                        } else if(target == MultiplatformTarget.Jvm) {
                            val jvmLibs = Libs.values().toMutableList().apply { remove(Libs.`android-game-lib`) }
                            jvmLibs.forEach { releaseLib(lib = it) }
                            jvmLibs.forEach { it.load(libDir) }
                        }

                        injectionExtension.initJadxActions.forEach { t -> t.second.initJadx(t.first, t.third.map { it.classTree }.toTypedArray()) }
                        injectionExtension.proxyList.forEach { ProxyFactory.setProxy(it.first.classTree, *it.second) }
                        injectionExtension.action?.invoke()
                        injectionExtension.deobfActions.forEach { deobfuscation(it.classTree) }
                    }

                    saveLib()
                }
            }
        }
    }

    companion object {
        lateinit var rootProject: Project
        lateinit var extension: InjectionMultiplatformExtension
        @JvmOverloads
        fun DependencyHandler.injectRwLib(
            version: String,
            useRuntimeLib: Boolean = false,
            jvmUseResource: Boolean = false
        ): Unit = with(rootProject){
            api("com.github.minxyzgo.rw-injection:core:$version")
            fun compileOnlyMultiplatform(ext: InjectionExtension) {
                add("${ext.target}CompileOnly".let { if(it == "CompileOnly") "compileOnly" else it }, fileTree(
                    generateFileTreeArgs(ext)
                ))
            }
            if(useRuntimeLib) {
                api("org.javassist:javassist:3.29.2-GA")
                api("com.fasterxml.jackson.core:jackson-databind:2.13.4")

                if(!extension.enable && extension.multiplatformTargets[MultiplatformTarget.Jvm] != null) {
                    val sourceSets = extensions.getByName("sourceSets") as org.gradle.api.tasks.SourceSetContainer
                    val main = sourceSets.named("main", SourceSet::class.java)
                    main.get().resources {
                        it.srcDir(Builder.libDir)
                    }
                }

                extension.multiplatformTargets[MultiplatformTarget.Jvm]?.let(::compileOnlyMultiplatform)
            } else {
                extension.multiplatformTargets.forEach { (_, u) ->
                    if(jvmUseResource && u.platform == MultiplatformTarget.Jvm) return@forEach
                    val t = u.target
                    add("${t}Api".let { if(it == "Api") "api" else it }, fileTree(generateFileTreeArgs(u)))
                }

                if(jvmUseResource) {
                    extension.multiplatformTargets[MultiplatformTarget.Jvm]?.let(::compileOnlyMultiplatform)
                }
            }
        }


        @OptIn(ExperimentalStdlibApi::class)
        private fun generateFileTreeArgs(ext: InjectionExtension) = buildMap<String, Any> {
            put("dir", Builder.libDir)
            put("include", "${if(ext.target.isBlank() || ext.platform == MultiplatformTarget.Jvm) "" else ext.target.removeSuffix("Main") + "-"}**.jar")
            when(ext.platform) {
                MultiplatformTarget.Jvm -> put("exclude", "android-game-lib.jar")
                MultiplatformTarget.Android -> put("exclude", "android-platform-lib.jar")
            }
        }
        private fun DependencyHandler.api(dependencyNotation: Any) = add(if(extension.enable) "commonMainApi" else "api", dependencyNotation)
    }

    open class InjectionMultiplatformExtension {
        internal val multiplatformTargets = mutableMapOf<MultiplatformTarget, InjectionExtension>()
        var enable: Boolean = false

        fun android(configuration: InjectionExtension.() -> Unit) {
            Libs.includes.add(Libs.`android-game-lib`)
            configuration(multiplatformTargets.getOrPut(MultiplatformTarget.Android) { InjectionExtension(MultiplatformTarget.Android) })
        }

        fun jvm(configuration: InjectionExtension.() -> Unit) {
            configuration(multiplatformTargets.getOrPut(MultiplatformTarget.Jvm) { InjectionExtension(MultiplatformTarget.Jvm) })
        }
    }

    enum class MultiplatformTarget {
        Jvm, Android // maybe we will support ios, who knows?
    }

    class InjectionExtension(val platform: MultiplatformTarget = MultiplatformTarget.Jvm) {
        internal val proxyList = mutableListOf<Pair<Libs, Array<out Any>>>()
        internal val deobfActions = mutableListOf<Libs>()
        internal val initJadxActions = mutableListOf<Triple<File, Libs, Array<Libs>>>()
        internal var action: (() -> Unit)? = null

        var target: String = if(platform == MultiplatformTarget.Jvm) "" else "androidMain"

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

        fun action(action: () -> Unit) { this.action = action }
    }
}

