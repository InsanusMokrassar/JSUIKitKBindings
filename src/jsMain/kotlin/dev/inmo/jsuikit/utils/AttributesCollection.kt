package dev.inmo.jsuikit.utils

import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.HtmlAttrMarker
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.Element
import org.w3c.dom.HTMLInputElement

class AttributesCollection<T : Element, Builder : AttrsScope<T>> (
    private vararg val modifiers: UIKitModifier?,
    private val attrs: Builder.() -> Unit = {}
) {
    val builder: Builder.() -> Unit = {
        include(*modifiers)
        attrs()
    }

    operator fun plus(other: AttributesCollection<T, Builder>) = AttributesCollection<T, Builder>(
        *(modifiers + other.modifiers).distinct().toTypedArray()
    ) {
        this@AttributesCollection.attrs.invoke(this)
        other.attrs.invoke(this)
    }

    companion object {
        val Empty = Attrs<Element>()

        @Suppress("UNCHECKED_CAST")
        fun <T : Element, Builder : AttrsScope<T>> empty() = Empty as AttributesCollection<T, Builder>
    }
}

typealias Attrs<T> = AttributesCollection<T, AttrsScope<T>>
typealias InputAttrs<T> = AttributesCollection<HTMLInputElement, InputAttrsScope<T>>
