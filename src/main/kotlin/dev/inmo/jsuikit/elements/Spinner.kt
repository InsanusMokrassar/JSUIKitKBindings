package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun Spinner(
    vararg modifier: UIKitModifier,
    ratio: Float? = null
) {
    Div(
        {
            attr("uk-spinner", ratio ?.let { "ratio: $it" } ?: "")
            classes("uk-icon", "uk-spinner")
            include(*modifier)
        }
    )
}

@Composable
fun DefaultSpinner() = Spinner(UIKitAlign.Center, UIKitMargin.Small, UIKitText.Alignment.Center)
