package dev.inmo.jsuikit.utils

import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.Element

class AttributesCollection<T : Element> (
    private vararg val modifiers: UIKitModifier,
    private val attrs: AttrBuilderContext<T> = {}
) {
    val builder: AttrBuilderContext<T> = {
        include(*modifiers)
        attrs()
    }

    operator fun plus(other: AttributesCollection<T>) = AttributesCollection<T>(
        *(modifiers + other.modifiers).distinct().toTypedArray()
    ) {
        this@AttributesCollection.attrs.invoke(this)
        other.attrs.invoke(this)
    }

    companion object {
        val Empty = Attrs<Element>()

        @Suppress("UNCHECKED_CAST")
        fun <T : Element> empty() = Empty as Attrs<T>
    }
}

typealias Attrs<T> = AttributesCollection<T>
