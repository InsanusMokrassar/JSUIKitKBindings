package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitBadge
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

@Composable
fun Badge(
    text: String,
    onAfterText: ContentBuilder<HTMLSpanElement>? = null,
    onBeforeText: ContentBuilder<HTMLSpanElement>? = null,
    attrs: AttrBuilderContext<HTMLSpanElement>? = null
) = Span({
    include(UIKitBadge)
    attrs ?.invoke(this)
}) {
    onAfterText ?.invoke(this)
    Text(text)
    onBeforeText ?.invoke(this)
}
