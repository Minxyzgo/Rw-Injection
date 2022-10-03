package rwij

import javassist.ClassPool
import javassist.CtField
import javassist.CtNewMethod
import javassist.Loader
import javassist.util.proxy.MethodHandler
import rwij.util.NodeTree
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.jvmErasure

fun <T> Any.setFunction(source: KFunction<T>, target: KFunction<T>) {
    if(!this::class.java.declaredFields.any { it.name == "__proxy__handler__" }) {
        throw IllegalAccessException("unsupported proxy object")
    }

    val method = this::class.java.getMethod(source.name, *source.parameters.map { it.type.jvmErasure.java }.toTypedArray())
    ClassBuilder.addProxy(method, target)
}

@Suppress("unused")
object ClassBuilder {
    val pool: ClassPool
    val classTree: NodeTree

    private var isLoaded = false
    private val methodMap = mutableMapOf<Method, KFunction<*>>()

    init {
        val (cp, tree) = Builder.buildNewClassTree()
        pool = cp
        classTree = tree
    }

    fun setProxy(name: String) {
        if(isLoaded) throw RuntimeException()

        val i = classTree.indexOfFirst { (it.value as String) == name }
        if(i != -1) {
            val clazz = pool[name]
            clazz.addField(
                CtField.make(
                    """
                        private final javassist.util.proxy.MethodHandler __proxy__handler__ = rwij.ClassBuilder.getHandler();
                    """.trimIndent(), clazz
                )
            )

            clazz.methods.filter {
                it.methodInfo2.codeAttribute.codeLength > 0
            }.forEach {
                val accessModifiers =
                    Modifier.PUBLIC or Modifier.PROTECTED or Modifier.PRIVATE

                val proceed = CtNewMethod.copy(it, "__proxy__${it.name}", clazz, null)
                proceed.modifiers = proceed.modifiers and accessModifiers.inv() or Modifier.PRIVATE
                clazz.addMethod(proceed)
                val sig = "\$sig"
                it.setBody("""
                    {
                        Class clazz = this.getClass();
                        java.lang.reflect.Method m1 = clazz.getDeclaredMethod(${it.name}, $sig);
                        m1.setAccessible(true);
                        java.lang.reflect.Method m2 = clazz.getDeclaredMethod(__proxy__${it.name}, $sig);
                        m2.setAccessible(true);
                        this.__proxy__handler__.invoke(this, m1, m2, $$);
                    }
                """.trimIndent())
            }
        } else {
            throw IllegalAccessException()
        }
    }

    @JvmStatic
    fun getHandler(): MethodHandler =  MethodHandler { self, thisMethod, proceed, args ->
        val kf = methodMap[thisMethod]
        if(kf != null) {
            kf.call(self, args)
        } else {
            proceed.invoke(self, args)
        }
    }

    fun load() {
        if(isLoaded) throw RuntimeException()

        isLoaded = true
        val cl = Loader(pool)
        classTree.forEach { cl.loadClass(it.value as String) }
    }

    fun addProxy(method: Method, kf: KFunction<*>) { methodMap[method] = kf }
}