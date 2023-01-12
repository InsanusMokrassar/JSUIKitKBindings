package dev.inmo.jsuikit.utils

import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.Element

operator fun <T : Element> AttrBuilderContext<T>.plus(other: AttrBuilderContext<T>): AttrBuilderContext<T> = {
    this@plus()
    other()
}
