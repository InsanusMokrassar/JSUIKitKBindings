package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitUtility
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun Inline(
    attrBuilderContext: AttrBuilderContext<HTMLDivElement>? = null,
    contentBuilder: ContentBuilder<HTMLDivElement>
) = Div({
    include(UIKitUtility.Inline)
    attrBuilderContext ?.invoke(this)
}, contentBuilder)
