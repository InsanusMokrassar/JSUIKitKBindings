package dev.inmo.jsuikit.utils

import dev.inmo.jsuikit.modifiers.UIKitModifier
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.Element

typealias AttrsWithContentBuilder<T> = Pair<Attrs<T>, ContentBuilder<T>>

@Suppress("NOTHING_TO_INLINE")
inline fun <T : Element> AttrsWithContentBuilder(noinline builder: ContentBuilder<T>) = AttrsWithContentBuilder(
    Attrs.empty(),
    builder
)

@Suppress("NOTHING_TO_INLINE")
inline fun <T : Element> AttrsWithContentBuilder(attrs: Attrs<T>) = AttrsWithContentBuilder(
    attrs
) {}

@Suppress("NOTHING_TO_INLINE")
inline fun <T : Element> AttrsWithContentBuilder(
    modifier: UIKitModifier?,
    vararg modifiers: UIKitModifier?,
    noinline attrs: AttrsScope<T>.() -> Unit = {}
) = AttrsWithContentBuilder(
    Attrs(modifier, *modifiers, attrs = attrs)
)

inline val <T : Element> AttrsWithContentBuilder<T>.attrs
    get() = first

inline val <T : Element> AttrsWithContentBuilder<T>.attributesBuilderContext
    get() = attrs.builder

inline val <T : Element> AttrsWithContentBuilder<T>.builder
    get() = second
