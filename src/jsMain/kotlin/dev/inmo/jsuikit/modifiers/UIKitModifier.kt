package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.Element

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

fun <T : Element> UIKitModifier.asAttributesBuilder(): AttrBuilderContext<T> = {
    include(this@asAttributesBuilder)
}
operator fun UIKitModifier.plus(other: UIKitModifier): UIKitModifier = UIKitCustom(
    classes + other.classes,
    otherAttrs + other.otherAttrs
)
fun <T: Element> UIKitModifier?.builder() = Attrs<T>(this).builder
fun <T: Element> Array<out UIKitModifier?>.builder() = Attrs<T>(*this).builder
inline fun <T: Element> attrsBuilder(vararg modifiers: UIKitModifier?) = modifiers.builder<T>()
@JsName("plusBuilder")
operator fun <T: Element> UIKitModifier?.plus(other: UIKitModifier?): AttrBuilderContext<T> = Attrs<T>(this@plus, other).builder
