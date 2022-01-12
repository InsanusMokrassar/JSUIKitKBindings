package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.Progress

@Composable
fun Progress(
    value: Int,
    vararg modifiers: UIKitModifier,
    max: Int = 100
) {
    Progress(
        {
            classes("uk-progress")
            include(*modifiers)
            attr("max", max.toString())
            attr("value", value.toString())
        }
    )
}
