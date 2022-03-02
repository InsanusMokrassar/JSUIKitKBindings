package dev.inmo.jsuikit.utils

import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsBuilder
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.Element
import org.w3c.dom.HTMLInputElement

class AttributesCollection<T : Element, Builder : AttrsBuilder<T>> (
    private vararg val modifiers: UIKitModifier,
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
        fun <T : Element, Builder : AttrsBuilder<T>> empty() = Empty as AttributesCollection<T, Builder>
    }
}

typealias Attrs<T> = AttributesCollection<T, AttrsBuilder<T>>
typealias InputAttrs<T> = AttributesCollection<HTMLInputElement, InputAttrsBuilder<T>>
