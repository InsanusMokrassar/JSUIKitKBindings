package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.buildAndAddAttribute
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.Milliseconds
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLUListElement

@Composable
fun Nav(
    modifiers: Array<UIKitModifier> = emptyArray(),
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    attributesCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    dataAllocator: ContentBuilder<HTMLUListElement>
) {
    Ul(
        {
            buildAndAddAttribute("uk-nav") {
                "multiple" to multiple ?.toString()
                "collapsible" to collapsible ?.toString()
                "animation" to animation
                "duration" to duration ?.toString()
            }
            classes("uk-nav")
            include(*modifiers)
            attributesCustomizer()
        }
    ) {
        dataAllocator()
    }
}

@Composable
fun NavElement(
    modifiers: Array<UIKitModifier> = emptyArray(),
    attributesCustomizer: AttrBuilderContext<HTMLLIElement> = {},
    contentAllocator: ContentBuilder<HTMLLIElement>
) {
    Li(
        {
            include(*modifiers)
            attributesCustomizer
        }
    ) {
        contentAllocator()
    }
}
