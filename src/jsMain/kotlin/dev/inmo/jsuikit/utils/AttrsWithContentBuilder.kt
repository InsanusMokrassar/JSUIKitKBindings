package dev.inmo.jsuikit.utils

import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.Element

typealias AttrsWithContentBuilder<T> = Pair<Attrs<T>, ContentBuilder<T>>

inline val <T : Element> AttrsWithContentBuilder<T>.attrs
    get() = first

inline val <T : Element> AttrsWithContentBuilder<T>.attributesBuilderContext
    get() = attrs.builder

inline val <T : Element> AttrsWithContentBuilder<T>.builder
    get() = second
