package rwij

import kotlin.reflect.KProperty

@Suppress("UNCHECKED_CAST")
fun <T, K : Any> K.get(property: K.() -> KProperty<T>): T {
    return this::class.java.getDeclaredMethod("get" + property(this).name).invoke(this) as T
}

fun <T, K : Any> K.set(property: KProperty<T>, value: T?) {
    this::class.java.declaredMethods.first { it.name == "set" + property.name }.invoke(this, value)
}