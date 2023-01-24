package com.github.minxyzgo.rwij.util

import java.util.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun Properties.property(defValue: String = "", replace: Boolean = false,) = GetProperty(this, defValue, replace)

class PropertyProvider(
    private val key: String,
    private val properties: Properties,
    private val defValue: String = "",
    private val replace: Boolean = false,
): ReadOnlyProperty<Nothing?, String> {
    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        val result = properties.getProperty(key, defValue)
        if(replace) properties.setProperty(key, defValue)
        return result
    }
}

/**
 * 委托方法。委托一个对象的get函数，并找到与其[KProperty.name]一样的键值
 *
 * 通常，这将返回String
 */
class GetProperty(
    private val properties: Properties,
    private val defValue: String = "",
    private val replace: Boolean = false,
) {
    operator fun provideDelegate(
        thisRef: Nothing?,
        prop: KProperty<*>
    ): PropertyProvider {
        val propertyName = prop.name
        return PropertyProvider(propertyName, properties, defValue, replace)
    }
}