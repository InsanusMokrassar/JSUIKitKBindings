package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLUListElement

interface NavbarNavElement {
    fun AttrsBuilder<HTMLLIElement>.setup() {}
    @Composable
    fun ElementScope<HTMLLIElement>.fill()

    class Default(
        private val setupCallback: AttrsBuilder<HTMLLIElement>.() -> Unit,
        private val fillCallback: @Composable ElementScope<HTMLLIElement>.() -> Unit
    ) : NavbarNavElement {
        override fun AttrsBuilder<HTMLLIElement>.setup() {
            setupCallback()
        }

        @Composable
        override fun ElementScope<HTMLLIElement>.fill() {
            fillCallback()
        }
    }
}

class NavbarNavBuilder(
    private val modifiers: Array<UIKitModifier>,
    private val elements: List<NavbarNavElement>,
    private val attributesCustomizer: AttrBuilderContext<HTMLUListElement> = {}
) {
    constructor(
        modifiers: Array<UIKitModifier>,
        vararg elements: NavbarNavElement,
        attributesCustomizer: AttrBuilderContext<HTMLUListElement> = {}
    ) : this(modifiers, elements.toList(), attributesCustomizer)
    constructor(
        vararg elements: NavbarNavElement,
        attributesCustomizer: AttrBuilderContext<HTMLUListElement> = {}
    ) : this(emptyArray(), elements.toList(), attributesCustomizer)
    @Composable
    fun draw() {
        Ul(
            {
                classes("uk-navbar-nav")
                include(*modifiers)
                attributesCustomizer()
            }
        ) {
            elements.forEach { element ->
                Li(
                    { element.apply { setup() } }
                ) {
                    element.apply { fill() }
                }
            }
        }
    }
}
