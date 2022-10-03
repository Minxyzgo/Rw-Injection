package rwij

import kotlin.reflect.KProperty

@Suppress("UNCHECKED_CAST")
fun <T> Any.get(property: KProperty<T>, accessible: Boolean = false): T {
    return this::class.java.getDeclaredField(property.name).apply {
        if(accessible) isAccessible = true
    }.get(this) as T
}

fun <T> Any.set(property: KProperty<T>, value: T?, accessible: Boolean = false) {
    this::class.java.getDeclaredField(property.name).apply {
        if(accessible) isAccessible = true
    }.set(this, value)
}