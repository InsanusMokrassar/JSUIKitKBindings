package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun Spinner(
    modifiers: Array<UIKitModifier> = emptyArray(),
    ratio: Float? = null,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {}
) {
    Div(
        {
            attr("uk-spinner", ratio ?.let { "ratio: $it" } ?: "")
            classes("uk-icon", "uk-spinner")
            include(*modifiers)
            attributesCustomizer()
        }
    )
}

@Composable
fun DefaultSpinner() = Spinner(
    arrayOf(UIKitAlign.Center, UIKitMargin.Small, UIKitText.Alignment.Center)
)
