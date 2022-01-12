package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Nav

@Composable
fun Navbar(
    vararg navModifiers: UIKitModifier,
    leftBuilder: NavbarNavBuilder? = null,
    centerBuilder: NavbarNavBuilder? = null,
    rightBuilder: NavbarNavBuilder? = null,
) {
    Nav(
        {
            attr("uk-navbar", "")
            classes("uk-navbar-container", "uk-navbar")
            include(*navModifiers)
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
