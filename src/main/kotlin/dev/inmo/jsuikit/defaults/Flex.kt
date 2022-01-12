package dev.inmo.jsuikit.defaults

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.defaults.modifers.UIKitModifier
import dev.inmo.jsuikit.defaults.modifers.include
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
