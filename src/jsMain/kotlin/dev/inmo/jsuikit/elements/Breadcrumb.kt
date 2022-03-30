package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitBreadcrumb
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@Composable
fun <T> Breadcrumb(
    data: Iterable<T>,
    rootAttrs: Attrs<HTMLUListElement> = Attrs.empty(),
    elementAttrs: Attrs<HTMLLIElement> = Attrs.empty(),
    elementContent: @Composable ElementScope<HTMLLIElement>.(T) -> Unit = {},
) {
    Ul(
        {
            include(UIKitBreadcrumb)
            rootAttrs.builder(this)
        }
    ) {
        data.forEach {
            Li({ elementAttrs.builder(this) }) {
                elementContent(it)
            }
        }
    }
}

@Composable
fun BreadcrumbActiveElement(
    href: String? = "#",
    elementAttrs: Attrs<HTMLAnchorElement> = Attrs.empty(),
    elementContent: @Composable ElementScope<HTMLAnchorElement>.() -> Unit = {},
) {
    A(href, { elementAttrs.builder(this) }) {
        elementContent()
    }
}

@Composable
fun BreadcrumbInactiveElement(
    elementAttrs: Attrs<HTMLSpanElement> = Attrs.empty(),
    elementContent: @Composable ElementScope<HTMLSpanElement>.() -> Unit = {},
) {
    Span({ elementAttrs.builder(this) }) {
        elementContent()
    }
}
