package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement

@Composable
fun DropArea(
    attrs: Attrs<HTMLDivElement> = Attrs.empty(),
    inputAttrs: Attrs<HTMLInputElement> = Attrs.empty(),
    contentBuilder: ContentBuilder<HTMLDivElement> = {}
) = Div(
    {
        include(UIKitPlaceholder, UIKitForm.Custom())
        attrs.builder(this)
    }
) {
    Input(InputType.File, attrs = { inputAttrs.builder.invoke(this) })
    contentBuilder(this)
}
