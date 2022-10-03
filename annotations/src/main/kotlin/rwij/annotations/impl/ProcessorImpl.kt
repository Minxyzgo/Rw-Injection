package rwij.annotations.impl

import javassist.CtClass
import javassist.CtMethod
import javassist.CtNewMethod
import rwij.Builder
import rwij.annotations.*
import rwij.jarFile
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.*

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes(
    "rwij.annotations.Rename",
    "rwij.annotations.Overwrite"
)
internal class ProcessorImpl : AbstractProcessor() {

    private val allData = mutableListOf<BuilderData>()

    override fun process(elements: MutableSet<out TypeElement>, env: RoundEnvironment): Boolean {

        //val trees = Trees.instance(processingEnv as JavacProcessingEnvironment)

        env.getElementsAnnotatedWith(RenameFrom::class.java).forEach { elem ->
            val r = elem.getAnnotation(RenameFrom::class.java)
            val type = when(elem) {
                is ExecutableElement -> RenameType.Method
                is VariableElement -> RenameType.Field
                else -> throw UnknownError("unknown element type")
            }

            val declaringClassName = (elem.enclosingElement as TypeElement).qualifiedName

            allData.add(BuilderData(type = type, name = r.oldName, declaringClassName = declaringClassName.toString()).apply {
                rename = elem.simpleName.toString()
                if(type == RenameType.Method) {
                    // 可能会有更好方法，但尽量避免重名
                    args = (elem as ExecutableElement).typeParameters.map { it.simpleName.toString() }
                }
            })
        }

        val (cp, classTree) = Builder.buildNewClassTree()
        allData.forEach { (name, type, declaringClassName, rename, args) ->
            val clazz = cp[declaringClassName]
            if(type == RenameType.Field) {
                val field = clazz.getField(name)
                clazz.addMethod(CtMethod.make("public ${field.type.name} get$rename() { return this.$name; }", clazz))
                clazz.addMethod(CtMethod.make("public void set$rename(${field.type.name} p) { this.$name = p; }", clazz))
            } else if(type == RenameType.Method) {
                val method = clazz.getDeclaredMethods(name).first {
                    if(it.parameterTypes.size != args!!.size) return@first false
                    args.forEachIndexed { i, str ->
                        if(str != it.parameterTypes[i].simpleName) return@first false
                    }
                    true
                }
                clazz.addMethod(CtNewMethod.copy(method, rename, clazz, null).apply {
                    setBody("{${if(returnType != CtClass.voidType) "return" else ""} $name(\$$);}")
                })
            }
        }

        Builder.buildJar(jarFile, classTree, cp)
        return true
    }

    data class BuilderData(
        val name: String,
        val type: RenameType,
        val declaringClassName: String,
        var rename: String = name,
        var args: List<String>? = null,
    )

    enum class RenameType {
        Clazz, Field, Method, Package
    }
}