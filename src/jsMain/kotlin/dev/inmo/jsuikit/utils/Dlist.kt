package dev.inmo.jsuikit.utils

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

private object DListElementBuilder : ElementBuilder<HTMLDListElement> {
    private val el: Element by lazy { document.createElement("dl") }
    override fun create(): HTMLDListElement = el.cloneNode() as HTMLDListElement
}

private object DTermElementBuilder : ElementBuilder<HTMLElement> {
    private val el: Element by lazy { document.createElement("dt") }
    override fun create(): HTMLElement = el.cloneNode() as HTMLElement
}

private object DDescriptionElementBuilder : ElementBuilder<HTMLElement> {
    private val el: Element by lazy { document.createElement("dd") }
    override fun create(): HTMLElement = el.cloneNode() as HTMLElement
}

@Composable
fun DList(
    attrs: AttrBuilderContext<HTMLDListElement>? = null,
    content: ContentBuilder<HTMLDListElement>? = null
) {
    TagElement(
        DListElementBuilder,
        attrs,
        content
    )
}
@Composable
fun DTerm(
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: ContentBuilder<HTMLElement>? = null
) {
    TagElement(
        DTermElementBuilder,
        attrs,
        content
    )
}
@Composable
fun DDescription(
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: ContentBuilder<HTMLElement>? = null
) {
    TagElement(
        DDescriptionElementBuilder,
        attrs,
        content
    )
}
