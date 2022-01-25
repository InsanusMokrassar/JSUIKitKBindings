package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLSpanElement

@Composable
fun Label(
    text: String,
    attrs: Attrs<HTMLSpanElement>
) = Span(
    {
        include(UIKitLabel)
        attrs.builder(this)
    }
) {
    Text(text)
}
