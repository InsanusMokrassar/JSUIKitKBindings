package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.buildAndAddAttribute
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.types.DropdownOptions
import dev.inmo.jsuikit.utils.Milliseconds
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun Dropdown(
    vararg modifiers: UIKitModifier,
    dropdownOptions: DropdownOptions,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    contentBuilder: ContentBuilder<HTMLDivElement>
) {
    Div(
        {
            include(UIKitDropdown(dropdownOptions), *modifiers)
            attributesCustomizer()
        },
        contentBuilder
    )
}
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
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    contentBuilder: ContentBuilder<HTMLDivElement>
) {
    Div(
        {
            include(
                UIKitDropdown(
                    DropdownOptions(
                        toggle = toggle,
                        pos = pos,
                        mode = mode,
                        delayShow = delayShow,
                        delayHide = delayHide,
                        boundary = boundary,
                        boundaryAlign = boundaryAlign,
                        flip = flip,
                        offset = offset,
                        animation = animation,
                        duration = duration
                    )
                ),
                *modifiers
            )
            attributesCustomizer()
        },
        contentBuilder
    )
}
