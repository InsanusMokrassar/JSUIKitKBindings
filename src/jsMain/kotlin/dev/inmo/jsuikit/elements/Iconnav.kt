package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitIconnav
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLUListElement

@Composable
fun <T> Iconnav(
    data: Iterable<T>,
    listAttrs: Attrs<HTMLUListElement> = Attrs.empty(),
    elementAttrsBuilder: AttrsScope<HTMLLIElement>.(T) -> Unit = {},
    elementBuilder: @Composable ElementScope<HTMLLIElement>.(T) -> Unit
) {
    Ul(
        {
            include(UIKitIconnav)
            listAttrs.builder(this)
        }
    ) {
        data.forEach {
            Li(
                {
                    elementAttrsBuilder.invoke(this, it)
                }
            ) { elementBuilder(this, it) }
        }
    }
}
