package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLLIElement

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
    private val elements: List<NavbarNavElement>
) {
    constructor(
        modifiers: Array<UIKitModifier>,
        vararg elements: NavbarNavElement
    ) : this(modifiers, elements.toList())
    constructor(
        vararg elements: NavbarNavElement
    ) : this(emptyArray(), elements.toList())
    @Composable
    fun draw() {
        Ul(
            {
                classes("uk-navbar-nav")
                include(*modifiers)
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
