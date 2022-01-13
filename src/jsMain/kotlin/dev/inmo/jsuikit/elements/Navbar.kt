package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLElement

@Composable
fun Navbar(
    leftBuilder: NavbarNavBuilder? = null,
    centerBuilder: NavbarNavBuilder? = null,
    rightBuilder: NavbarNavBuilder? = null,
    vararg navModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLElement> = {},
) {
    Nav(
        {
            attr("uk-navbar", "")
            classes("uk-navbar-container", "uk-navbar")
            include(*navModifiers)
            attributesCustomizer()
        }
    ) {
        leftBuilder ?.let {
            Div({ classes("uk-navbar-left") }) { it.draw() }
        }
        centerBuilder ?.let {
            Div({ classes("uk-navbar-center") }) { it.draw() }
        }
        rightBuilder ?.let {
            Div({ classes("uk-navbar-right") }) { it.draw() }
        }
    }
}
