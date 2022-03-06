package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.Attrs
import dev.inmo.jsuikit.utils.InputAttrs
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun DropArea(
    attrs: Attrs<HTMLDivElement> = Attrs.empty(),
    inputAttrs: InputAttrs<String> = Attrs.empty(),
    contentBuilder: ContentBuilder<HTMLDivElement> = {}
) = Div(
    {
        include(UIKitPlaceholder, UIKitForm.Custom())
        attrs.builder(this)
    }
) {
    FileInput {
        inputAttrs.builder.invoke(this)
    }
    contentBuilder(this)
}
