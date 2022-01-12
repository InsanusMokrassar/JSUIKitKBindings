package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.defaults.modifers.UIKitModifier
import dev.inmo.jsuikit.defaults.modifers.include
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
