package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitDrop
import dev.inmo.jsuikit.modifiers.attrsBuilder
import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

@Composable
fun Drop(
    buttonBuilder: AttrsWithContentBuilder<HTMLButtonElement>,
    dropBuilder: AttrsWithContentBuilder<HTMLDivElement>
) {
    DefaultButton(
        attributesCustomizer = buttonBuilder.attributesBuilderContext,
        contentAllocator = buttonBuilder.builder
    )
    Div(
        (Attrs<HTMLDivElement>(UIKitDrop.Custom()) + dropBuilder.attrs).builder,
        dropBuilder.builder
    )
}
