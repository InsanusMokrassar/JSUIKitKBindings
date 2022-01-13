package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Progress
import org.w3c.dom.HTMLProgressElement

@Composable
fun Progress(
    value: Int,
    modifiers: Array<UIKitModifier> = emptyArray(),
    max: Int = 100,
    attributesCustomizer: AttrBuilderContext<HTMLProgressElement> = {}
) {
    Progress(
        {
            classes("uk-progress")
            include(*modifiers)
            attr("max", max.toString())
            attr("value", value.toString())
            attributesCustomizer()
        }
    )
}
