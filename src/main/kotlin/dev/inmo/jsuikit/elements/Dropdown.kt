package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.buildAndAddAttribute
import dev.inmo.jsuikit.defaults.modifers.*
import dev.inmo.jsuikit.utils.Milliseconds
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun Dropdown(
    vararg modifiers: UIKitModifier,
    toggle: String? = null,
    pos: UIKitDropdown.Position? = null,
    mode: UIKitDropdown.Mode? = null,
    delayShow: Milliseconds? = null,
    delayHide: Milliseconds? = null,
    boundary: String? = null,
    boundaryAlign: Boolean? = null,
    flip: UIKitDropdown.Flip? = null,
    offset: Int? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    contentBuilder: ContentBuilder<HTMLDivElement>
) {
    Div(
        {
            buildAndAddAttribute("uk-dropdown") {
                "toggle" to toggle
                "pos" to pos
                "mode" to mode
                "delayShow" to delayShow
                "delayHide" to delayHide
                "boundary" to boundary
                "boundaryAlign" to boundaryAlign
                "flip" to flip
                "offset" to offset
                "animation" to animation
                "duration" to duration
            }
            classes("uk-dropdown")
            include(*modifiers)
        },
        contentBuilder
    )
}
