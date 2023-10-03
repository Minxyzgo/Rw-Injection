@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.github.minxyzgo.rwij

import com.github.minxyzgo.rwij.Builder.useCache
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
    val proxyMap = ((proxyMapField.get(this) as? HashMap<*, *>) ?: HashMap<Method, Function<*>?>().also { proxyMapField.set(this, it) }) as HashMap<Method, Function<*>?>
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
    const val proxyVersion = "0.1.0-alpha"

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
                            addAll(clazz.declaredMethods.filter { !allName.contains(it.name) && !allName.contains(it.longName) }.map { it to -1 })
                        } else {
                            allName.forEach { item ->
                                val list = item.split(":at")
                                val realName = list[0]
                                val line = list.getOrNull(1)?.toInt() ?: -1
                                if(item.contains("(")) {
                                    add((clazz.declaredMethods.firstOrNull {
                                        it.name + Descriptor.getParamDescriptor(it.signature) == realName
                                    } ?: throw IllegalArgumentException("Couldn't find method: $realName in class: ${clazz.name}. Did you enter the correct name?"))
                                            to line)
                                }

                                else addAll(clazz.declaredMethods.filter { it.name == realName }.map { it to line })
                            }
                        }
                    }

                    if(isEmpty) setEmpty(methodArray.map { it.first }.toTypedArray()) else methodArray.forEach { setProxyMethod(it.first, it.second) }
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
     * 给定一个列表，表示该字符串表示的类所有在列表中的方法设为空体/代理
     */
    //context(ProxyFactory)
    fun String.with(vararg list: String) = this to list

    /**
     * 给定一个列表，表示该字符串表示的类所有除了在列表中的方法设为空体/代理
     */
    //context(ProxyFactory)
    fun String.withNon(vararg list: String) = "$this:non" to list

    fun String.at(line: Int) = "$this:at$line"

    @JvmStatic
    fun getProxyFunction(className: String, thisMethodDesc: String): Pair<InjectMode, Function<*>?> {
        val proxyMap1 = agentMap[className]?.proxyMap
        return proxyMap1?.get(thisMethodDesc) ?: (InjectMode.Override to null)
    }

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
            setProxyMethod(it, -1)
        }
    }

    @LibRequiredApi
    private fun setProxyMethod(method: CtMethod, line: Int) {
        val clazz = method.declaringClass
        val pool = method.declaringClass.classPool
        val constPool = clazz.classFile2.constPool

        if(!clazz.fields.any { it.name == "__proxy_map__" }) {
            clazz.addField(
                CtField.make(
                    """
                        protected java.util.HashMap __proxy_map__ = null;
                    """.trimIndent(), clazz
                )
            )
        }

        if(line != -1) {
//            val args = "\$args"
//            val clazz0 = "\$class"
//            val sig = "\$sig"
//            method.insertAt(line, """
//                java.lang.reflect.Method m1 = $clazz0.getDeclaredMethod("${method.name}", $sig);
//                m1.setAccessible(true);
//                com.github.minxyzgo.rwij.ProxyFactory.handler.invoke(${if(!Modifier.isStatic(method.modifiers)) "this" else "null"}, m1, null, $args);
//            """.trimIndent())
            throw RuntimeException("Stop.")
        } else {
            val isNative = Modifier.isNative(method.modifiers)


            val proceedName = "__proxy__${method.name}"
            if(!isNative) {
                val proceed = CtNewMethod.copy(method, proceedName, clazz, null)
                proceed.modifiers = Modifier.setProtected(method.modifiers)
                clazz.addMethod(proceed)
            } else {
                method.modifiers = method.modifiers and Modifier.NATIVE.inv()
            }

            val r = "\$r"
            val sig = "\$sig"
            val args = "\$args"
            val arg2 = "$$"
            val clazz0 = "\$class"

            val proxyCode = """
                com.github.minxyzgo.rwij.ProxyFactory.call(fun, $args);
            """.trimIndent()
            val proceedCode = if(!Modifier.isNative(method.modifiers)) """
                ${if(Modifier.isStatic(method.modifiers)) "" else "this."}$proceedName($arg2);
            """.trimIndent() else "null"
            val returnTypeCode = """
                        Object result;
                        kotlin.Pair pair = com.github.minxyzgo.rwij.ProxyFactory.getProxyFunction("${Descriptor.toJavaName(clazz.name)}", "${method.getDesc()}");
                        com.github.minxyzgo.rwij.InjectMode mode = pair.getFirst();
                        Object fun = pair.getSecond();
                        if(mode == com.github.minxyzgo.rwij.InjectMode.InsertBefore) {
                            Object result1 = $proxyCode
                            if(result1 instanceof com.github.minxyzgo.rwij.InterruptResult) {
                                result = ((com.github.minxyzgo.rwij.InterruptResult)result1).getResult();
                            } else {
                                Object result2 = $proceedCode
                                if(result1 != kotlin.Unit.INSTANCE) {
                                    result = result1;
                                } else {
                                    result = result2;
                                }
                            }
                        } else if(mode == com.github.minxyzgo.rwij.InjectMode.Override) {
                            result = $proxyCode
                        } else if(mode == com.github.minxyzgo.rwij.InjectMode.InsertAfter) {
                            Object result1 = $proceedCode
                            Object result2 = $proxyCode
                            if(result2 != kotlin.Unit.INSTANCE) {
                                result = result2;
                            } else {
                                result = result1;
                            }
                        }
            """.trimIndent()
            val voidTypeCode = """
                        kotlin.Pair pair = com.github.minxyzgo.rwij.ProxyFactory.getProxyFunction("${Descriptor.toJavaName(clazz.name)}", "${method.getDesc()}");
                        com.github.minxyzgo.rwij.InjectMode mode = pair.getFirst();
                        kotlin.Function fun = pair.getSecond();
                        if(mode == com.github.minxyzgo.rwij.InjectMode.InsertBefore) {
                            Object result1 = $proxyCode
                            if(result1 instanceof com.github.minxyzgo.rwij.InterruptResult) {
                            } else {
                                $proceedCode
                            }
                        } else if(mode == com.github.minxyzgo.rwij.InjectMode.Override) {
                            $proxyCode
                        } else if(mode == com.github.minxyzgo.rwij.InjectMode.InsertAfter) {
                            $proceedCode
                            $proxyCode
                        }
            """.trimIndent()
            method.setBody(
                """
                    {
                        ${if(method.returnType == CtClass.voidType) voidTypeCode else returnTypeCode}
                        ${if(method.returnType != CtClass.voidType) "return ($r) result" else ""};
                    }
                """.trimIndent()
            )
        }

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

        val allLibFiles = Libs.values().filter { it.shouldLoad }.map(Libs::lib)

        allLibFiles.forEach {
            addURL.invoke(Thread.currentThread().contextClassLoader, it.toURI().toURL())
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

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    fun call(kf: Any?, vararg args: Any?): Any? {
        return with(kf as Function<*>) {
            when(this) {
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
    }
}

/**
 * Class代理解决方案，提供有用的函数便于实现代理
 */
class FunctionAgent<T : Any>(private val tClass: KClass<T>) {
    internal val proxyMap = mutableMapOf<String, Pair<InjectMode, Function<*>?>>()

    /**
     * @param source must be [KFunction].
     */
    fun <T : Function<*>> addProxy(source: T, mode: InjectMode = InjectMode.Override, target: T?) {
        tClass.getProxyMethodByKFunction(source as KFunction<*>)
        proxyMap[tClass.getProxyMethodByKFunction(source as KFunction<*>).also {
            checkMethodIfValid(it)
        }.getDesc()] = mode to target
    }

    /**
     * @param name 要代理的方法名
     * @param parameterTypes 要代理方法的参数类型
     */
    fun addProxy(name: String, vararg parameterTypes: KClass<*>, mode: InjectMode = InjectMode.Override, target: Function<*>?) {
        val classes = parameterTypes.map(KClass<*>::java).toTypedArray()
        val method = tClass.java.getDeclaredMethod(name, *classes).also {
            checkMethodIfValid(it)
        }
        proxyMap[method.getDesc()] = mode to target
    }

    /**
     * @param name 要代理的方法名
     * @param desc 要代理的方法的签名，一个合法的示例是： (IIZLjava/lang/String;)
     */
    fun addProxy(name: String, desc: String, mode: InjectMode = InjectMode.Override, target: Function<*>?) {
        val classes = getParameterTypes(desc)
        val method = tClass.java.getDeclaredMethod(name, *classes).also {
            checkMethodIfValid(it)
        }
        proxyMap[method.getDesc()] = mode to target
    }
}

class InterruptResult(val result: Any? = Unit)

enum class InjectMode {
    /**
     * 函数将运行在代理方法之前。若函数返回Unit, 则使用代理方法的返回值, 若返回[InterruptResult]，则中断代理方法进行并返回
     */
    InsertBefore,
    /**
     * 函数完全覆盖代理方法。代理方法不再执行
     */
    Override,
    /**
     * 函数将运行在代理方法之后。若函数返回Unit, 则使用代理方法的返回值
     */
    InsertAfter
}



private typealias MFMap = Map<String, Function<*>?>

//typealias Callable = (args: Array<Any?>) -> Any?
//typealias CallableBridge = (self: Any?) -> Callable

