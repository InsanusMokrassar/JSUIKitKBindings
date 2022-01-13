package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun Flex(
    modifiers: Array<UIKitModifier> = emptyArray(),
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    filler: @Composable ElementScope<HTMLDivElement>.() -> Unit
) {
    Div(
        {
            classes("uk-flex")
            include(*modifiers)
            attributesCustomizer()
        }
    ) {
        filler()
    }
}
