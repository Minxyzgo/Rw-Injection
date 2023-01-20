@file:Suppress("unused")

package rwij

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import rwij.util.ClassTree
import java.io.File

class GradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        rootProject = target
        target.extensions.create("injection", InjectionExtension::class.java)

        target.tasks.getByName("build").doFirst {
            Builder.saveLib()
        }
    }

    companion object {
        lateinit var rootProject: Project
        @JvmOverloads
        fun DependencyHandler.injectRwCore(version: String, libDir: String = "lib") = with(rootProject){
            extensions.configure(InjectionExtension::class.java) {
                it.libDir = libDir
            }

            add("compileOnly","com.github.minxyzgo.rw-injection:source:$version")
            val fi = File("${projectDir.absolutePath}/$libDir/game-lib.jar")
            if(!fi.exists()) {
                fi.outputStream().use {
                    it.write(
                        this::class.java.classLoader.getResourceAsStream("game-lib-output.jar")!!.readBytes()
                    )
                }
            }

            add("runtimeOnly", fileTree(mapOf("dir" to "$rootDir/$libDir", "include" to "game-lib.jar")))
        }
    }

    class InjectionExtension {
        var libDir: String = "lib"

        init {
            with(Builder) {
                this@with.libDir = rootProject.projectDir.absolutePath + "/" + this@InjectionExtension.libDir
                loadLib()
            }
        }

        @OptIn(ProxyFactory.LibRequiredApi::class)
        fun setProxy(tree: ClassTree, vararg proxyList: Any) = ProxyFactory.setProxy(tree, *proxyList)
    }
}

