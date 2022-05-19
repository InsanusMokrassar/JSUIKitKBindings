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

@Deprecated("Will be removed soon. Use NavbarNavPart with AttrsWithContentBuilder instead")
interface NavbarNavElement {
    fun AttrsScope<HTMLLIElement>.setup() {}
    @Composable
    fun ElementScope<HTMLLIElement>.fill()

    class Default(
        private val setupCallback: AttrsScope<HTMLLIElement>.() -> Unit,
        private val fillCallback: @Composable ElementScope<HTMLLIElement>.() -> Unit
    ) : NavbarNavElement {
        override fun AttrsScope<HTMLLIElement>.setup() {
            setupCallback()
        }

        @Composable
        override fun ElementScope<HTMLLIElement>.fill() {
            fillCallback()
        }
    }
}

@Deprecated("Will be removed soon. Use NavbarNavPart with AttrsWithContentBuilder instead")
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
                include(UIKitNavbar.Nav, *modifiers)
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
