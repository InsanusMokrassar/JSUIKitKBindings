package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitTile
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun Tile(
    attrs: Attrs<HTMLDivElement> = Attrs.empty(),
    contentBuilder: ContentBuilder<HTMLDivElement>
) = Div(
    {
        include(UIKitTile)
        attrs.builder(this)
    },
    contentBuilder
)
