package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

@Composable
fun Flex(
    vararg modifiers: UIKitModifier,
    filler: @Composable ElementScope<HTMLDivElement>.() -> Unit
) {
    Div(
        {
            classes("uk-flex")
            include(*modifiers)
        }
    ) {
        filler()
    }
}
