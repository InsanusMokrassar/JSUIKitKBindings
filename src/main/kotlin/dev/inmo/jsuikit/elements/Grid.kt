package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun GridColumn(
    modifiers: Array<UIKitModifier> = emptyArray(),
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    builder: @Composable ElementScope<HTMLDivElement>.() -> Unit
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
    modifiers: Array<UIKitModifier> = emptyArray(),
    masonry: Boolean = false,
    parallax: Int? = null,
    marginClass: String? = null,
    firstColumnClass: String? = null,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    builder: @Composable ElementScope<HTMLDivElement>.() -> Unit
) {
    val attrs = listOfNotNull(
        if (masonry) "masonry" to "true" else null,
        parallax ?.let { "parallax" to it.toString() },
        marginClass ?.let { "margin" to it },
        firstColumnClass ?.let { "first-column" to it },
    )
    Div(
        {
            attr("uk-grid", attrs.joinToString(";") { (k, v) -> "$k: $v" })
            classes("uk-grid")
            include(*modifiers)
            attributesCustomizer()
        }
    ) {
        builder()
    }
}
