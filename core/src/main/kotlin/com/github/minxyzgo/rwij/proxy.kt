package com.github.minxyzgo.rwij

import com.github.minxyzgo.rwij.util.ClassTree
import com.github.minxyzgo.rwij.util.getDesc
import com.github.minxyzgo.rwij.util.getParameterTypes
import com.github.minxyzgo.rwij.util.property
import javassist.*
import javassist.bytecode.AnnotationsAttribute
import javassist.bytecode.Descriptor
import javassist.bytecode.annotation.StringMemberValue
import java.io.File
import java.lang.reflect.Method
import java.net.URL
import java.net.URLClassLoader
import java.util.*
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

    val method = this::class.getProxyMethodByKFunction(source as KFunction<*>)
    checkMethodIfValid(method)
    val proxyMapField = this::class.java.getDeclaredField("__proxy_map__").apply { isAccessible = true }
    val proxyMap = ((proxyMapField.get(this) as? java.util.HashMap<*, *>) ?: java.util.HashMap<Method, Function<*>?>().also { proxyMapField.set(this, it) }) as java.util.HashMap<Method, Function<*>?>
    proxyMap[method] = target
}

fun <K : Any> KClass<K>.setFunction(caller: FunctionAgent<K>.() -> Unit) {
    if(this.java.getAnnotation(Proxy::class.java) == null) {
        throw IllegalAccessException("unsupported proxy object")
    }

    ProxyFactory.addAgent(this.java, FunctionAgent(this).apply(caller))
}

private fun KClass<*>.getProxyMethodByKFunction(source: KFunction<*>): Method {
    var typeParams = source.parameters.map { it.type.jvmErasure.java }.toTypedArray()
    if(source.instanceParameter != null) typeParams = typeParams.sliceArray(1 until typeParams.size)
    return this.java.getMethod(source.name, *typeParams)
}

private fun checkMethodIfValid(method: Method) {
    if(method.getAnnotation(Proxy::class.java) == null) {
        throw IllegalAccessException("unsupported proxy method: ${method.name}")
    }
}

@Suppress("unused")
object ProxyFactory {
    val proxyVersion = "0.0.4-beta"
    var useCache = true

    /**
     * 防kt不防java (笑
     */
    @LibRequiredApi
    @JvmField
    @Suppress("UNCHECKED_CAST")
    internal val handler = object : MethodHandler {
        override fun invoke(self: Any?, thisMethod: Method, proceed: Method, args: Array<Any>): Any? {
            var isAgent = false
            val proxyMap0: MFMap? = (if(self != null) {
                val agent = self::class.java.getDeclaredField("__proxy_map__").apply { isAccessible = true }
                agent.get(self) as? MFMap
            } else null) ?: agentMap[thisMethod.declaringClass.name]?.apply {
                isAgent = true
            }?.proxyMap

            val desc = thisMethod.getDeclaredAnnotation(Proxy::class.java).desc

            val kf = proxyMap0?.get(desc)
            val containKey = proxyMap0?.containsKey(desc) ?: false
            //方法设置为空体时返回类型默认值
            if(kf == null && containKey) {
                return thisMethod.returnType.normalTypeInitStatement()
            }

            return if(kf != null) {
                if(isAgent) {
                    kf.call(self, *args)
                } else {
                    kf.call(*args)
                }
            } else {
                proceed.invoke(self, *args)
            }
        }
    }

    private var isLoaded = false
    internal val agentMap = mutableMapOf<String, FunctionAgent<*>>()

    /**
     * 提供简便的初始化模块。在[block]内调用[setProxy]执行复杂的加载操作
     */
    @LibRequiredApi
    fun runInit(block: ProxyFactory.() -> Unit) {
        Builder.loadLib()
        block(this)
        load()
    }

    /**
     * 设置代理，根据给定的[tree]和要修改的类全称限定列表[proxyList]，可传入形如”empty:class"的方式为该class的所有方法设置空体.
     *
     * 同时，特殊的使用方法有 "empty:class".with(...)或withNon(...), 具体查看[String.with]和[String.withNon]
     * @param tree 要更改的jar tree，通常在[Libs]的枚举常量中获取
     */
    @LibRequiredApi
    @Suppress("UNCHECKED_CAST")
    fun setProxy(tree: ClassTree, vararg proxyList: Any) {
        fun Pair<String, Array<String>>.toStr(): String {
            return "${first}[${second.sorted().joinToString(";") { it.replace(",", ";") }}]"
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
                    val isEmpty = any.first.startsWith("empty:")
                    val clazz = tree.defPool[any.first.removePrefix("empty:").removeSuffix(":non")]
                    val allName = any.second
                    val methodArray = buildList {
                        if(isNon) {
                            addAll(clazz.declaredMethods.filter { !allName.contains(it.name) && !allName.contains(it.longName) })
                        } else {
                            allName.forEach { item ->
                                if(item.contains("("))
                                    add(clazz.declaredMethods.first { it.name + Descriptor.toString(it.signature) == item })
                                else addAll(clazz.declaredMethods.filter { it.name == item })
                            }
                        }
                    }

                    if(isEmpty) setEmpty(methodArray.toTypedArray()) else methodArray.forEach(::setProxyMethod)
                }

                else -> throw IllegalArgumentException()
            }
        }

        val version by info.property(proxyVersion, true)
        if(version != proxyVersion || !useCache) {
            proxyList.forEach(::fix)
            info.setProperty("version", proxyVersion)
        } else {
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
        }

        info.store(fi.outputStream(), "")
    }

    /**
     * 给定一个列表，表示该字符串表示的类所有在列表中的方法设为空体
     */
    //context(ProxyFactory)
    fun String.with(vararg list: String) = this to list

    /**
     * 给定一个列表，表示该字符串表示的类所有除了在列表中的方法设为空体
     */
    //context(ProxyFactory)
    fun String.withNon(vararg list: String) = "$this:non" to list

    @LibRequiredApi
    private fun setEmpty(methods: Array<CtMethod>) {
        methods.forEach {
            it.modifiers = it.modifiers and (it.modifiers xor Modifier.NATIVE xor Modifier.ABSTRACT)
            it.setBody(if(it.returnType != CtClass.voidType) "{ return ${it.returnType.normalTypeInitStatement()}; }" else "{ }")
        }
    }

    @LibRequiredApi
    private fun setProxy0(clazz: CtClass) {
        clazz.methods.filter {
            it.methodInfo2.codeAttribute != null && !it.name.startsWith("__proxy__") && !it.hasAnnotation(Proxy::class.java)
        }.forEach {
            setProxyMethod(it)
        }
    }

    @LibRequiredApi
    private fun setProxyMethod(method: CtMethod) {
        val clazz = method.declaringClass
        val constPool = clazz.classFile2.constPool

        if(!clazz.fields.any { it.name == "__proxy_map__" }) {
            clazz.addField(
                CtField.make(
                    """
                        private java.util.HashMap __proxy_map__ = null;
                    """.trimIndent(), clazz
                )
            )
        }

        val proceedName = "__proxy__${method.name}"
        val proceed = CtNewMethod.copy(method, proceedName, clazz, null)
        clazz.addMethod(proceed)
        proceed.modifiers = method.modifiers and Modifier.PRIVATE

        val r = "\$r"
        val sig = "\$sig"
        val args = "\$args"
        val clazz0 = "\$class"
        method.setBody(
            """
                    {
                        java.lang.reflect.Method m1 = $clazz0.getDeclaredMethod("${method.name}", $sig);
                        m1.setAccessible(true);
                        java.lang.reflect.Method m2 = $clazz0.getDeclaredMethod("__proxy__${method.name}", $sig);
                        m2.setAccessible(true);
                        ${if(method.returnType != CtClass.voidType) "return" else ""} ($r) com.github.minxyzgo.rwij.ProxyFactory.handler.invoke(
                            ${if(!Modifier.isStatic(method.modifiers)) "this" else "null"}, m1, m2, $args);
                    }
                """.trimIndent()
        )

        val annotationsAttribute = AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag)
        val proxyAnnotation = javassist.bytecode.annotation.Annotation(Proxy::class.java.canonicalName, constPool)
        proxyAnnotation.addMemberValue("desc", StringMemberValue(method.getDesc(), constPool))
        annotationsAttribute.addAnnotation(proxyAnnotation)
        method.methodInfo.addAttribute(annotationsAttribute)

        if(clazz.hasAnnotation(Proxy::class.java)) return
        val annotationsAttribute0 = AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag)
        val proxyAnnotation0 = javassist.bytecode.annotation.Annotation(Proxy::class.java.canonicalName, constPool)
        annotationsAttribute0.addAnnotation(proxyAnnotation0)
        clazz.classFile.addAttribute(annotationsAttribute0)
    }

    /**
     * 加载所有的lib到classpath，这在使用动态代理模式下是必须的
     */
    @LibRequiredApi
    fun load() {
        if(isLoaded) throw RuntimeException()

        isLoaded = true
        Builder.saveLib()

        val addURL: Method = URLClassLoader::class.java.getDeclaredMethod("addURL", URL::class.java).apply {
            isAccessible = true
        }

        val allLibFiles = Libs.values().map(Libs::lib)

        allLibFiles.forEach {
            addURL.invoke(ClassLoader.getSystemClassLoader(), it.toURI().toURL())
        }
    }

    /**
     * 为单一class添加全局代理，一般可以使用[KClass.setFunction]
     */
    fun <T : Any> addAgent(clazz: Class<T>, agent: FunctionAgent<T>) {
        agentMap[clazz.name] = agent
    }

    private fun CtMethod.getDesc() =
        "$name(${this.parameterTypes.joinToString(",") { it.name }})"
}

/**
 * Class代理解决方案，提供有用的函数便于实现代理
 */
class FunctionAgent<T : Any>(private val tClass: KClass<T>) {
    internal val proxyMap = mutableMapOf<String, Function<*>?>()

    /**
     * @param source must be [KFunction].
     */
    fun <T : Function<*>> addProxy(source: T, target: T?) {
        tClass.getProxyMethodByKFunction(source as KFunction<*>)
        proxyMap[tClass.getProxyMethodByKFunction(source as KFunction<*>).also {
            checkMethodIfValid(it)
        }.getDesc()] = target
    }

    /**
     * @param name 要代理的方法名
     * @param parameterTypes 要代理方法的参数类型
     */
    fun addProxy(name: String, vararg parameterTypes: KClass<*>, target: Function<*>?) {
        val classes = parameterTypes.map(KClass<*>::java).toTypedArray()
        val method = tClass.java.getDeclaredMethod(name, *classes).also {
            checkMethodIfValid(it)
        }
        proxyMap[method.getDesc()] = target
    }

    /**
     * @param name 要代理的方法名
     * @param desc 要代理的方法的签名，一个合法的示例是： (IIZLjava/lang/String;)
     */
    fun addProxy(name: String, desc: String, target: Function<*>?) {
        val classes = getParameterTypes(desc)
        val method = tClass.java.getDeclaredMethod(name, *classes).also {
            checkMethodIfValid(it)
        }
        proxyMap[method.getDesc()] = target
    }
}

interface MethodHandler {
    /**
     * Is called when a method is invoked on a proxy instance associated
     * with this handler.  This method must process that method invocation.
     *
     * @param self          the proxy instance.
     * @param thisMethod    the overridden method declared in the super
     * class or interface.
     * @param proceed       the forwarder method for invoking the overridden
     * method.  It is null if the overridden method is
     * abstract or declared in the interface.
     * @param args          an array of objects containing the values of
     * the arguments passed in the method invocation
     * on the proxy instance.  If a parameter type is
     * a primitive type, the type of the array element
     * is a wrapper class.
     * @return              the resulting value of the method invocation.
     *
     * @throws Throwable    if the method invocation fails.
     */
    @Throws(Throwable::class)
    operator fun invoke(
        self: Any?, thisMethod: Method, proceed: Method,
        args: Array<Any>
    ): Any?
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

private typealias MFMap = Map<String, Function<*>?>

//typealias Callable = (args: Array<Any?>) -> Any?
//typealias CallableBridge = (self: Any?) -> Callable

