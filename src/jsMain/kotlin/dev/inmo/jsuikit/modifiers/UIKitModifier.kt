package dev.inmo.jsuikit.modifiers

import org.jetbrains.compose.web.attributes.AttrsScope

interface UIKitModifier {
    val classes: Array<String>
        get() = emptyArray()
    val otherAttrs: Map<String, String>
        get() = emptyMap()
}

fun AttrsScope<*>.include(vararg container: UIKitModifier?) {
    container.forEach {
        it ?.classes ?.let { newClasses -> classes(*newClasses) }
        it ?.otherAttrs ?.let { attrs -> attrs.forEach { (k, v) -> attr(k, v) } }
    }
}
