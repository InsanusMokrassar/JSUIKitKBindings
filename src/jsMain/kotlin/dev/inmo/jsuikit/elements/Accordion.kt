package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitAccordion
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@Composable
fun <T> Accordion(
    data: Iterable<T>,
    attrs: Attrs<HTMLUListElement> = Attrs.empty(),
    itemAttrsBuilder: AttrsBuilder<HTMLLIElement>.(Int, T) -> Unit = { _, _ -> },
    itemContentBuilder: @Composable ElementScope<HTMLLIElement>.(Int, T) -> Unit
) {
    Ul(
        {
            include(UIKitAccordion)
            attrs.builder(this)
        }
    ) {
        data.forEachIndexed { i, t ->
            Li({ itemAttrsBuilder(i, t) }) {
                itemContentBuilder(i, t)
            }
        }
    }
}

@Composable
fun <T> DefaultAccordion(
    data: Iterable<T>,
    attrs: Attrs<HTMLUListElement> = Attrs.empty(),
    itemAttrsBuilder: AttrsBuilder<HTMLLIElement>.(Int, T) -> Unit = { _, _ -> },
    titleAttrsBuilder: AttrsBuilder<HTMLAnchorElement>.(Int, T) -> Unit = { _, _ -> },
    titleContentBuilder: @Composable ElementScope<HTMLAnchorElement>.(Int, T) -> Unit = { _, _ -> },
    beforeTitleContentBuilder: @Composable ElementScope<HTMLLIElement>.(Int, T) -> Unit = { _, _ -> },
    afterTitleContentBuilder: @Composable ElementScope<HTMLLIElement>.(Int, T) -> Unit = { _, _ -> },
    afterContentContentBuilder: @Composable  ElementScope<HTMLLIElement>.(Int, T) -> Unit = { _, _ -> },
    contentAttrsBuilder: AttrsBuilder<HTMLDivElement>.(Int, T) -> Unit = { _, _ -> },
    contentContentBuilder: @Composable ElementScope<HTMLDivElement>.(Int, T) -> Unit
) = Accordion(
    data,
    attrs,
    itemAttrsBuilder
) { i, t ->
    beforeTitleContentBuilder(i, t)
    A(
        attrs = {
            include(UIKitAccordion.Title)
            titleAttrsBuilder(i, t)
        }
    ) {
        titleContentBuilder(i, t)
    }
    afterTitleContentBuilder(i, t)
    Div(
        {
            include(UIKitAccordion.Content)
            contentAttrsBuilder(i, t)
        }
    ) {
        contentContentBuilder(i, t)
    }
    afterContentContentBuilder(i, t)
}

@Composable
fun <T> DefaultAccordion(
    data: Iterable<T>,
    titleResolver: (Int, T) -> String,
    attrs: Attrs<HTMLUListElement> = Attrs.empty(),
    itemAttrsBuilder: AttrsBuilder<HTMLLIElement>.(Int, T) -> Unit = { _, _ -> },
    titleAttrsBuilder: AttrsBuilder<HTMLAnchorElement>.(Int, T) -> Unit = { _, _ -> },
    contentAttrsBuilder: AttrsBuilder<HTMLDivElement>.(Int, T) -> Unit = { _, _ -> },
    contentContentBuilder: @Composable ElementScope<HTMLDivElement>.(Int, T) -> Unit
) = DefaultAccordion(
    data,
    attrs,
    itemAttrsBuilder,
    titleAttrsBuilder,
    { i, t ->
        org.jetbrains.compose.web.dom.Text(titleResolver(i, t))
    },
    contentAttrsBuilder = contentAttrsBuilder,
    contentContentBuilder = contentContentBuilder
)
