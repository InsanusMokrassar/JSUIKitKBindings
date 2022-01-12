package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifers.UIKitModifier
import dev.inmo.jsuikit.modifers.include
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@Composable
fun GridColumn(
    vararg modifiers: UIKitModifier,
    builder: @Composable ElementScope<HTMLDivElement>.() -> Unit
) {
    Div(
        {
            include(*modifiers)
        }
    ) {
        builder()
    }
}

@Composable
fun Grid(
    vararg modifiers: UIKitModifier,
    masonry: Boolean = false,
    parallax: Int? = null,
    marginClass: String? = null,
    firstColumnClass: String? = null,
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
        }
    ) {
        builder()
    }
}
