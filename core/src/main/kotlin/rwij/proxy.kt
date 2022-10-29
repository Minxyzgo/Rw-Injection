package rwij

import javassist.*
import javassist.bytecode.AnnotationsAttribute
import javassist.bytecode.Descriptor
import javassist.util.proxy.MethodHandler
import rwij.annotations.Proxy
import rwij.util.ClassTree
import rwij.util.property
import java.io.File
import java.lang.reflect.Method
import java.net.URL
import java.net.URLClassLoader
import java.util.Properties
import kotlin.jvm.functions.FunctionN
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.jvm.jvmErasure

/**
 * @param source must be [KFunction].
 */
@Suppress("UNCHECKED_CAST")
fun <T : Function<*>> Any.setFunction(source: T, target: T?) {
    if(this::class.java.getAnnotation(Proxy::class.java) == null) {
        throw IllegalAccessException("unsupported proxy object")
    }

    val method = this::class.getMethodByKFunction(source as KFunction<*>)
    val proxyMapField = this::class.java.getDeclaredField("__proxy_map__")
    val proxyMap = ((proxyMapField.get(this) as? java.util.HashMap<*, *>) ?: java.util.HashMap<Method, Function<*>?>().also { proxyMapField.set(this, it) }) as java.util.HashMap<Method, Function<*>?>
    proxyMap[method] = target
}

fun <K : Any> KClass<K>.setFunction(caller: FunctionAgent<K>.() -> Unit) {
    if(this.java.getAnnotation(Proxy::class.java) == null) {
        throw IllegalAccessException("unsupported proxy object")
    }

    ProxyFactory.addAgent(this.java, FunctionAgent(this).apply(caller))
}

private fun KClass<*>.getMethodByKFunction(source: KFunction<*>): Method {
    var typeParams = source.parameters.map { it.type.jvmErasure.java }.toTypedArray()
    if(source.instanceParameter != null) typeParams = typeParams.sliceArray(1 until typeParams.size)
    return this.java.getMethod(source.name, *typeParams)
}

@Suppress("unused")
object ProxyFactory {
    val proxyVersion = "0.0.2"

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
        val containKey = proxyMap0?.containsKey(thisMethod) ?: false
        //方法设置为空体时返回类型默认值
        if(kf == null && containKey) {
            return@MethodHandler thisMethod.returnType.normalTypeInitStatement()
        }

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

    /**
     * 提供简便的初始化模块。在[block]内调用[setProxy]执行复杂的加载操作
     */
    fun runInit(block: ProxyFactory.() -> Unit) {
        Builder.loadLib()
        block(this)
        load()
    }

    /**
     * 设置代理，根据给定的[tree]和要修改的类全称限定列表[proxyList]，可传入形如”empty:class"的方式为该class的所有方法设置空体.
     *
     * 同时，特殊的使用方法有 "empty:class".with(...)或withNon(...), 具体查看[String.with]和[String.withNon]
     * @param tree 要更改的jar tree，通常使用[Builder.getClassTreeByLibName]获取
     */
    @Suppress("UNCHECKED_CAST")
    fun setProxy(tree: ClassTree, vararg proxyList: Any) {
        fun Pair<String, Array<String>>.toStr(): String {
            return "${first}[${second.sorted().joinToString(";")}]"
        }

        val currentListStr = proxyList.joinToString(",") {
            when(it) {
                is String -> it
                is Pair<*, *> -> {
                    (it as Pair<String, Array<String>>).toStr()
                }
                else -> throw IllegalArgumentException()
            }
        }

        val fi = File("${Builder.libDir}/info.properties").apply {
            if(!exists()) createNewFile()
        }
        val info = Properties().apply {
            load(fi.inputStream())
        }

        fun fix(any: Any) {
            when(any) {
                is String -> {
                    if(any.startsWith("empty:"))
                        setEmpty(tree.defPool[any.removePrefix("empty:")].declaredMethods)
                    else
                        setProxy0(tree.defPool[any])
                }

                is Pair<*, *> -> {
                    any as Pair<String, Array<String>>
                    val isNon = any.first.endsWith(":non")
                    val clazz = tree.defPool[any.first.removePrefix("empty:").removeSuffix(":non")]
                    val allName = any.second
                    val methodArray = buildList {
                        if(isNon) {
                            addAll(clazz.declaredMethods.filter { !allName.contains(it.name) && !allName.contains(it.longName) })
                        } else {
                            allName.forEach { item ->
                                if(item.contains("("))
                                    add(clazz.declaredMethods.first { it.longName == item })
                                else addAll(clazz.declaredMethods.filter { it.name == item })
                            }
                        }
                    }

                    setEmpty(methodArray.toTypedArray())
                }

                else -> throw IllegalArgumentException()
            }
        }

        val version by info.property(proxyVersion, true)
        if(version != proxyVersion) {
            proxyList.forEach(::fix)
            return
        }

        val propertyName = tree.name + "_proxy_list"
        val proxyList0 = info.getProperty(propertyName, "").split(",")
        info.setProperty(propertyName, currentListStr)
        info.setProperty("last_mod_time", System.currentTimeMillis().toString())

        val subtract = proxyList.filter {
            when(it) {
                is String -> !proxyList0.contains(it)
                is Pair<*, *> -> !proxyList0.contains((it as Pair<String, Array<String>>).toStr())
                else -> throw RuntimeException()
            }
        }
        subtract.forEach(::fix)

        info.store(fi.outputStream(), "")
    }

    /**
     * 给定一个列表，表示该字符串表示的类所有在列表中的方法设为空体
     */
    context(ProxyFactory)
    fun String.with(vararg list: String) = this to list

    /**
     * 给定一个列表，表示该字符串表示的类所有除了在列表中的方法设为空体
     */
    context(ProxyFactory)
    fun String.withNon(vararg list: String) = "$this:non" to list

    private fun setEmpty(methods: Array<CtMethod>) {
        methods.forEach {
            it.modifiers = it.modifiers and (it.modifiers xor Modifier.NATIVE xor Modifier.ABSTRACT)
            it.setBody(if(it.returnType != CtClass.voidType) "{ return ${it.returnType.normalTypeInitStatement()}; }" else "{ }")
        }
    }

    private fun setProxy0(clazz: CtClass) {
        if(!clazz.fields.any { it.name == "__proxy_map__" }) {
            clazz.addField(
                CtField.make(
                    """
                        public java.util.HashMap __proxy_map__ = null;
                    """.trimIndent(), clazz
                )
            )
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
        }

        val constPool = clazz.classFile2.constPool
        val annotationsAttribute = AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag)
        val proxyAnnotation = javassist.bytecode.annotation.Annotation(Proxy::class.java.canonicalName, constPool)
        annotationsAttribute.addAnnotation(proxyAnnotation)
        clazz.classFile.addAttribute(annotationsAttribute)
    }

    fun load() {
        if(isLoaded) throw RuntimeException()

        isLoaded = true
        Builder.saveLib()

        val addURL: Method = URLClassLoader::class.java.getDeclaredMethod("addURL", URL::class.java).apply {
            isAccessible = true
        }

        val allLibFiles = Builder.libraries.keys.map { File("${Builder.libDir}/$it.jar") }

        allLibFiles.forEach {
            addURL.invoke(ClassLoader.getSystemClassLoader(), it.toURI().toURL())
        }
    }

    fun <T : Any> addAgent(clazz: Class<T>, agent: FunctionAgent<T>) {
        agentMap[clazz] = agent
    }
}

class FunctionAgent<T : Any>(private val tClass: KClass<T>) {
    val proxyMap = mutableMapOf<Method, Function<*>?>()

    /**
    * @param source must be [KFunction].
    */
    fun <T : Function<*>> addProxy(source: T, target: T?) {
        proxyMap[tClass.getMethodByKFunction(source as KFunction<*>)] = target
    }

    fun addProxy(name: String, vararg parameterTypes: KClass<*>, target: Function<*>?) {
        val classes = parameterTypes.map(KClass<*>::java).toTypedArray()
        val method = tClass.java.getDeclaredMethod(name, *classes)
        proxyMap[method] = target
    }

    fun addProxy(name: String, desc: String, target: Function<*>?) {
        val classes = Descriptor.getParameterTypes(desc, Builder.defClassPool).map(CtClass::transformClass).toTypedArray()
        val method = tClass.java.getDeclaredMethod(name, *classes)
        proxyMap[method] = target
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

private typealias MFMap = Map<Method, Function<*>?>

//typealias Callable = (args: Array<Any?>) -> Any?
//typealias CallableBridge = (self: Any?) -> Callable


