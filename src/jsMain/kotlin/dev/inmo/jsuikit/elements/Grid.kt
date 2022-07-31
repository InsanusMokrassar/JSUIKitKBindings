package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.buildAttribute
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun GridColumn(
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    builder: @Composable ElementScope<HTMLDivElement>.() -> Unit = {}
) {
    Div(
        {
            include(*modifiers)
            attributesCustomizer()
        }
    ) {
        builder()
    }
}

@Composable
fun Grid(
    vararg modifiers: UIKitModifier,
    masonry: Boolean = false,
    parallax: UInt? = null,
    marginClass: UIKitMargin? = null,
    firstColumnClass: String? = null,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    builder: ContentBuilder<HTMLDivElement> = {}
) {
    Div(
        {
            include(
                UIKitGrid.invoke(marginClass, firstColumnClass, masonry, parallax),
                *modifiers
            )
            attributesCustomizer()
        }
    ) {
        builder()
    }
}
