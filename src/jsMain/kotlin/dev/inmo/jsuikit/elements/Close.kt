package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import dev.inmo.jsuikit.modifiers.UIKitClose
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement

object Close {
    @Composable
    fun drawAsLink(
        href: String = "#",
        attrs: Attrs<HTMLAnchorElement> = Attrs.empty(),
        contentBuilder: ContentBuilder<HTMLAnchorElement> = {}
    ) = A(
        href,
        {
            include(UIKitClose)
            attrs.builder(this)
        },
        contentBuilder
    )

    @Composable
    fun drawAsButton(
        attrs: Attrs<HTMLButtonElement> = Attrs.empty(),
        contentBuilder: ContentBuilder<HTMLButtonElement> = {},
        onClick: ((SyntheticMouseEvent) -> Unit)? = null
    ) = Button(
        {
            type(ButtonType.Button)
            include(UIKitClose)
            attrs.builder(this)
            onClick ?.let {
                onClick(onClick)
            }
        },
        contentBuilder
    )
}
