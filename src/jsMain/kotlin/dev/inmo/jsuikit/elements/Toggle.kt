package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitToggle
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.HTMLButtonElement

@Composable
fun Toggle(
    attrs: Attrs<HTMLButtonElement>,
    contentBuilder: ContentBuilder<HTMLButtonElement>
) {
    Button(
        {
            include(UIKitToggle)
            type(ButtonType.Button)
            attrs.builder(this)
        },
        contentBuilder
    )
}
