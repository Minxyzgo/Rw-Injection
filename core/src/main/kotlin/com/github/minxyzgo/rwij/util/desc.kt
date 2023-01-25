package com.github.minxyzgo.rwij.util

import java.lang.reflect.Method

/*
        ----This File----
    用于去除对javassist的依赖
 */

internal fun Method.getDesc() =
    "$name(${this.parameterTypes.joinToString(",") { it.name }})"

@Suppress("UNCHECKED_CAST")
internal fun getParameterTypes(desc: String): Array<Class<*>> {
    if(desc[0] != '(') throw IllegalArgumentException()
    val num = numOfParameters(desc)
    val args = arrayOfNulls<Class<*>>(num)
    var n = 0
    var i = 1
    do {
        i = toClass(desc, i, args, n++)
    } while(i > 0)
    return args as Array<Class<*>>
}

internal fun numOfParameters(desc: String): Int {
    var n = 0
    var i = 1
    while(true) {
        var c = desc[i]
        if(c == ')') break
        while(c == '[') c = desc[++i]
        if(c == 'L') {
            i = desc.indexOf(';', i) + 1
            if(i <= 0) throw IndexOutOfBoundsException("bad descriptor")
        } else ++i
        ++n
    }
    return n
}

internal fun toClass(
    desc: String, i_: Int,
    args: Array<Class<*>?>, n: Int
): Int {
    var i = i_
    var i2: Int
    var name: String
    var arrayDim = 0
    var c = desc[i]
    while(c == '[') {
        ++arrayDim
        c = desc[++i]
    }
    if(c == 'L') {
        i2 = desc.indexOf(';', ++i)
        name = desc.substring(i, i2++).replace('/', '.')
    } else {
        val type = toPrimitiveClass(c) ?: return -1
        // error
        i2 = i + 1
        if(arrayDim == 0) {
            args[n] = type
            return i2 // neither an array type or a class type
        }
        name = type.name
    }
    if(arrayDim > 0) {
        val sbuf = StringBuilder(name)
        while(arrayDim-- > 0) sbuf.append("[]")
        name = sbuf.toString()
    }
    args[n] = Class.forName(name)
    return i2
}

internal fun toPrimitiveClass(c: Char) = when(c) {
    'Z' -> Boolean::class.java
    'C' -> Char::class.java
    'B' -> Byte::class.java
    'S' -> Short::class.java
    'I' -> Int::class.java
    'J' -> Long::class.java
    'F' -> Float::class.java
    'D' -> Double::class.java
    'V' -> Unit::class.java
    else -> null
}