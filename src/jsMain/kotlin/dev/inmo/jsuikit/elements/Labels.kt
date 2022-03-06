package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitLabel
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
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
