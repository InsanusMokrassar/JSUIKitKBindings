package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitContainer
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun Container(
    attrs: Attrs<HTMLDivElement> = Attrs.empty(),
    contentBuilder: ContentBuilder<HTMLDivElement> = {}
) = Div(
    {
        include(UIKitContainer)
        attrs.builder.invoke(this)
    },
    contentBuilder
)
