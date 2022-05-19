package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLElement

@Composable
fun Navbar(
    attributesCustomizer: AttrBuilderContext<HTMLElement> = {},
    contentBuilder: ContentBuilder<HTMLElement>
) {
    Nav(
        {
            include(UIKitNavbar, UIKitNavbar(), UIKitNavbar.Container)
            attributesCustomizer()
        }
    ) {
        contentBuilder()
    }
}

@Composable
fun Navbar(
    leftBuilder: NavbarNavBuilder? = null,
    centerBuilder: NavbarNavBuilder? = null,
    rightBuilder: NavbarNavBuilder? = null,
    vararg navModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLElement> = {},
) {
    Navbar(
        {
            include(*navModifiers)
            attributesCustomizer()
        }
    ) {
        leftBuilder ?.let {
            Div({ include(UIKitNavbar.Alignment.Left) }) { it.draw() }
        }
        centerBuilder ?.let {
            Div({ include(UIKitNavbar.Alignment.Center) }) { it.draw() }
        }
        rightBuilder ?.let {
            Div({ include(UIKitNavbar.Alignment.Right) }) { it.draw() }
        }
    }
}
