package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement
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
    leftBuilder: AttrsWithContentBuilder<HTMLDivElement>? = null,
    centerBuilder: AttrsWithContentBuilder<HTMLDivElement>? = null,
    rightBuilder: AttrsWithContentBuilder<HTMLDivElement>? = null,
    vararg navModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLElement> = {},
) {
    Navbar(
        attributesCustomizer = {
            include(*navModifiers)
            attributesCustomizer()
        }
    ) {
        leftBuilder ?.let {
            Div({ include(UIKitNavbar.Alignment.Left);leftBuilder.attributesBuilderContext(this) }, leftBuilder.builder)
        }
        centerBuilder ?.let {
            Div({ include(UIKitNavbar.Alignment.Center);centerBuilder.attributesBuilderContext(this) }, centerBuilder.builder)
        }
        rightBuilder ?.let {
            Div({ include(UIKitNavbar.Alignment.Right);rightBuilder.attributesBuilderContext(this) }, rightBuilder.builder)
        }
    }
}
