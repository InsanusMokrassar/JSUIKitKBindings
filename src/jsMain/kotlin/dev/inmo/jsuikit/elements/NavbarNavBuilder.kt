package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLUListElement

@Composable
fun NavbarNav(
    elements: List<AttrsWithContentBuilder<HTMLLIElement>>,
    attrs: Attrs<HTMLUListElement> = Attrs.empty()
) {
    Ul(
        {
            include(UIKitNavbar.Nav)
            attrs.builder(this)
        }
    ) {
        elements.forEach { element ->
            Li(element.attributesBuilderContext, element.builder)
        }
    }
}

@Composable
fun NavbarNav(
    vararg elements: AttrsWithContentBuilder<HTMLLIElement>,
    attrs: Attrs<HTMLUListElement> = Attrs.empty()
) = NavbarNav(elements.toList(), attrs)
