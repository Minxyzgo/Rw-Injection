package rwij.annotations.impl

import com.sun.tools.javac.code.Symbol.ClassSymbol
import javassist.CtClass
import javassist.CtMethod
import javassist.CtNewMethod
import javassist.bytecode.AnnotationsAttribute
import javassist.bytecode.ConstPool
import rwij.Builder
import rwij.CodeBuilder
import rwij.annotations.*
import rwij.toClassList
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.*

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedOptions("buildDir")
@SupportedAnnotationTypes(
    "rwij.annotations.RenameFrom",
)
internal class ProcessorImpl : AbstractProcessor() {

    private val allData = mutableListOf<BuilderData>()

    //这地方写的没脸看将就了。。。
    override fun process(elements: MutableSet<out TypeElement>, env: RoundEnvironment): Boolean {
        //val trees = Trees.instance(processingEnv as JavacProcessingEnvironment)
        env.getElementsAnnotatedWith(RenameFrom::class.java).forEach { elem ->
            val r = elem.getAnnotation(RenameFrom::class.java)
            val type = when(elem) {
                is ExecutableElement -> RenameType.Method
                is VariableElement -> RenameType.Field
                is TypeElement -> RenameType.Clazz
                else -> throw UnknownError("unknown element type: ${elem::class.qualifiedName}")
            }

            var packageName: String? = null
            val declaringClassName = if(elem is TypeElement) {
                packageName = (elem.enclosingElement as PackageElement).qualifiedName.toString()
                elem.qualifiedName
            } else (elem.enclosingElement as TypeElement).qualifiedName

            allData.add(BuilderData(
                type = type,
                name = r.oldName,
                declaringClassName = declaringClassName.toString(),
                packageName = packageName,
            ).apply {
                rename = elem.simpleName.toString()
                if(type == RenameType.Method) {
                    // 可能会有更好方法，但尽量避免重名
                    args = (elem as ExecutableElement).typeParameters.map { it.simpleName.toString() }
                }
            })
        }

        val (cp, classTree) = Builder.buildNewClassTree("game-lib.jar")
        fun addProxyToMethod(method: CtMethod, constPool: ConstPool = method.declaringClass.classFile.constPool) {
            method.methodInfo
            val annotationsAttribute = AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag)
            val proxyAnnotation = javassist.bytecode.annotation.Annotation(Proxy::class.java.canonicalName, constPool)
            annotationsAttribute.addAnnotation(proxyAnnotation)
            method.methodInfo.addAttribute(annotationsAttribute)
        }
        //println(classTree.map { it.value  as String}.filter { it.startsWith("com.corrodinggames.rts.gameFramework.f") }.joinToString(","))
        allData.forEach { (name, type, declaringClassName, rename, packageName, args) ->
            if(type == RenameType.Clazz) {
                val oldName = "$packageName.$name"
                //麻了，但毕竟这玩意调用也就一次（）能跑就行
                classTree.first { (it.value as String) == oldName }.value = declaringClassName
                cp[oldName].name = declaringClassName
                return@forEach
            }

            val clazz = cp[declaringClassName]
            if(type == RenameType.Field) {
                val field = clazz.getField(name)
                clazz.addMethod(
                    CtNewMethod.getter("get$rename", field).apply(::addProxyToMethod)
                )
                clazz.addMethod(
                    CtNewMethod.setter("set$rename", field).apply(::addProxyToMethod)
                )
            } else if(type == RenameType.Method) {
                val method = clazz.getDeclaredMethods(name).first {
                    if(it.parameterTypes.size != args!!.size) return@first false
                    args.forEachIndexed { i, str ->
                        if(str != it.parameterTypes[i].simpleName) return@first false
                    }
                    true
                }
//                clazz.addMethod(CtNewMethod.copy(method, rename, clazz, null).apply {
//                    setBody("{${if(returnType != CtClass.voidType) "return" else ""} $name(\$$);}")
//                    addProxyToMethod(this)
//                })
                method.name = rename
            }
        }

        Builder.buildJar(File(processingEnv.options["buildDir"]!!), classTree.toClassList(cp))
        return true
    }

    data class BuilderData(
        val name: String,
        val type: RenameType,
        val declaringClassName: String,
        var rename: String = name,
        val packageName: String? = null,
        var args: List<String>? = null,
    )

    enum class RenameType {
        Clazz, Field, Method, Package
    }
}