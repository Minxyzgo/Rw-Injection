package rwij

import javassist.*
import javassist.bytecode.AnnotationsAttribute
import javassist.util.proxy.MethodHandler
import rwij.annotations.Proxy
import rwij.util.NodeTree
import java.io.File
import java.lang.reflect.Method
import java.net.URL
import java.net.URLClassLoader
import kotlin.jvm.functions.FunctionN
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.extensionReceiverParameter
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.full.valueParameters
import kotlin.reflect.jvm.jvmErasure

/**
 * @param source must be [KFunction].
 */
@Suppress("UNCHECKED_CAST")
fun <K, T : Function<K>> Any.setFunction(source: T, target: T) {
    if(this::class.java.getAnnotation(Proxy::class.java) == null) {
        throw IllegalAccessException("unsupported proxy object")
    }

    val method = this::class.getMethodByKFunction(source as KFunction<*>)
    val proxyMapField = this::class.java.getDeclaredField("__proxy_map__")
    val proxyMap = (proxyMapField.get(this) as? MutMFMap) ?: java.util.HashMap<Method, Function<*>>().also { proxyMapField.set(this, it) }
    proxyMap[method] = target
}

fun <K : Any> KClass<K>.setFunction(caller: FunctionAgent<K>.() -> Unit) {
    if(this.java.getAnnotation(Proxy::class.java) == null) {
        throw IllegalAccessException("unsupported proxy object")
    }

    ProxyFactory.addAgent(this.java, FunctionAgent<K>(this).apply(caller))
}

private fun KClass<*>.getMethodByKFunction(source: KFunction<*>): Method {
    var typeParams = source.parameters.map { it.type.jvmErasure.java }.toTypedArray()
    if(source.instanceParameter != null) typeParams = typeParams.sliceArray(1 until typeParams.size)
    return this.java.getMethod(source.name, *typeParams)
}

@Suppress("unused")
object ProxyFactory {
    val pool: ClassPool
    val classTree: NodeTree

    @JvmField
    @Suppress("UNCHECKED_CAST")
    val handler = MethodHandler { self, thisMethod, proceed, args ->
        var isAgent = false
        val proxyMap0: MFMap? = (if(self != null) {
            val agent = self::class.java.getDeclaredField("__proxy_map__")
            agent.get(self) as? MFMap
        } else null) ?: agentMap[thisMethod.declaringClass]?.apply {
            isAgent = true
        }?.proxyMap

        val kf = proxyMap0?.get(thisMethod)

        if(kf != null) {
            if(isAgent) {
                kf.call(self, *args)
            } else {
                kf.call(*args)
            }
        } else {
            proceed.invoke(self, *args)
        }
    }

    private var isLoaded = false
    private val agentMap = mutableMapOf<Class<*>, FunctionAgent<*>>()

    init {
        val (cp, tree) = Builder.buildNewClassTree("game-lib.jar")
        pool = cp
        classTree = tree
    }

    fun setProxy(name: String) {
        if(isLoaded) throw RuntimeException()

        val i = classTree.indexOfFirst { (it.value as String) == name }
        if(i != -1) {
            val clazz = pool[name]
            if(!clazz.fields.any { it.name == "__proxy_map__" }) {
                clazz.addField(CtField.make("""
                public java.util.HashMap __proxy_map__ = null;
            """.trimIndent(), clazz))
            }

            clazz.methods.filter {
                it.methodInfo2.codeAttribute != null && !it.hasAnnotation(Proxy::class.java)
            }.forEach {
                val proceed = CtNewMethod.copy(it, "__proxy__${it.name}", clazz, null)
                clazz.addMethod(proceed)
                val r = "\$r"
                val sig = "\$sig"
                val args = "\$args"
                val clazz0 = "\$class"
                it.setBody(
                    """
                    {
                        java.lang.reflect.Method m1 = $clazz0.getDeclaredMethod("${it.name}", $sig);
                        m1.setAccessible(true);
                        java.lang.reflect.Method m2 = $clazz0.getDeclaredMethod("__proxy__${it.name}", $sig);
                        m2.setAccessible(true);
                        ${if(it.returnType != CtClass.voidType) "return" else ""} ($r) rwij.ProxyFactory.handler.invoke(
                            ${if(!Modifier.isStatic(it.modifiers)) "this" else "null"}, m1, m2, $args);
                    }
                """.trimIndent()
                )

                val constPool = clazz.classFile2.constPool
                val annotationsAttribute = AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag)
                val proxyAnnotation = javassist.bytecode.annotation.Annotation(Proxy::class.java.canonicalName, constPool)
                annotationsAttribute.addAnnotation(proxyAnnotation)
                clazz.classFile.addAttribute(annotationsAttribute)
            }
        } else {
            throw RuntimeException()
        }
    }

    fun load() {
        if(isLoaded) throw RuntimeException()

        isLoaded = true
        val tempFile = File.createTempFile("proxy-temp", ".jar").apply {
            deleteOnExit()
        }
        Builder.buildJar(tempFile, classTree, pool)
        val addURL: Method = URLClassLoader::class.java.getDeclaredMethod("addURL", URL::class.java).apply {
            isAccessible = true
        }

        addURL.invoke(ClassLoader.getSystemClassLoader(), tempFile.toURI().toURL())
    }

    fun <T : Any> addAgent(clazz: Class<T>, agent: FunctionAgent<T>) {
        agentMap[clazz] = agent
    }
}

class FunctionAgent<T : Any>(private val tClass: KClass<T>) {
    val proxyMap = mutableMapOf<Method, Function<*>>()

    /**
    * @param source must be [KFunction].
    */
    fun <K, T : Function<K>> addProxy(source: T, target: T) {
        proxyMap[tClass.getMethodByKFunction(source as KFunction<*>)] = target
    }
}

@Suppress("UNCHECKED_CAST")
fun Function<*>.call(vararg args: Any?): Any? {
    return when(this) {
        is Function0 -> {
            invoke()
        }
        is Function1<*,*> -> {
            (this as Function1<Any?,Any?>).invoke(args[0])
        }
        is Function2<*,*,*> -> {
            (this as Function2<Any?,Any?,Any?>).invoke(args[0],args[1])
        }
        is Function3<*,*,*,*> -> {
            (this as Function3<Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2])
        }
        is Function4<*,*,*,*,*> -> {
            (this as Function4<Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3])
        }
        is Function5<*,*,*,*,*,*> -> {
            (this as Function5<Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4])
        }
        is Function6<*,*,*,*,*,*,*> -> {
            (this as Function6<Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5])
        }
        is Function7<*,*,*,*,*,*,*,*> -> {
            (this as Function7<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6])
        }
        is Function8<*,*,*,*,*,*,*,*,*> -> {
            (this as Function8<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7])
        }
        is Function9<*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function9<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8])
        }
        is Function10<*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function10<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9])
        }
        is Function11<*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function11<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10])
        }
        is Function12<*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function12<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11])
        }
        is Function13<*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function13<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12])
        }
        is Function14<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function14<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13])
        }
        is Function15<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function15<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14])
        }
        is Function16<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function16<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],args[15])
        }
        is Function17<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function17<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],args[15],args[16])
        }
        is Function18<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function18<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],args[15],args[16],args[17])
        }
        is Function19<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function19<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],args[15],args[16],args[17],args[18])
        }
        is Function20<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function20<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],args[15],args[16],args[17],args[18],args[19])
        }
        is Function21<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function21<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],args[15],args[16],args[17],args[18],args[19],args[20])
        }
        is Function22<*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*,*> -> {
            (this as Function22<Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?,Any?>).invoke(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],args[15],args[16],args[17],args[18],args[19],args[20],args[21])
        }
        is FunctionN<*> -> {
            (this as FunctionN<Any?>).invoke(*args)
        }

        else -> { throw RuntimeException() }
    }
}

private typealias MFMap = Map<Method, Function<*>>
private typealias MutMFMap = MutableMap<Method, Function<*>>
//
//typealias Callable = (args: Array<Any?>) -> Any?
//typealias CallableBridge = (self: Any?) -> Callable


