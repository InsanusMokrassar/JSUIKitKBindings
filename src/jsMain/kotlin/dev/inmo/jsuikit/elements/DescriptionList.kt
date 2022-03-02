package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitDescriptionList
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDListElement
import org.w3c.dom.HTMLElement

@Composable
fun DescriptionList(
    attrs: Attrs<HTMLDListElement>,
    contentBuilder: ContentBuilder<HTMLDListElement>
) {
    DList(
        {
            include(UIKitDescriptionList)
            attrs.builder(this)
        },
        contentBuilder
    )
}

@Composable
fun <T> DescriptionList(
    data: Iterable<T>,
    attrs: Attrs<HTMLDListElement>,
    beforeTermContent: (@Composable ElementScope<HTMLElement>.(Int, T) -> Unit)? = null,
    itemTermAttrs: ((Int, T) -> Attrs<HTMLElement>?)? = null,
    itemTermContent: (@Composable ElementScope<HTMLElement>.(Int, T) -> Unit)? = null,
    betweenTermAndDescriptionContent: (@Composable ElementScope<HTMLElement>.(Int, T) -> Unit)? = null,
    afterDescriptionContent: (@Composable ElementScope<HTMLElement>.(Int, T) -> Unit)? = null,
    itemDescriptionAttrs: ((Int, T) -> Attrs<HTMLElement>?)? = null,
    itemDescriptionContent: (@Composable ElementScope<HTMLElement>.(Int, T) -> Unit)? = null
) {
    DescriptionList(attrs) {
        data.forEachIndexed { i, t ->
            beforeTermContent ?.invoke(this, i, t)
            if (itemTermAttrs != null || itemTermContent != null) {
                DTerm(
                    itemTermAttrs ?.let { { it(i, t) } },
                    itemTermContent ?.let { { it(i, t) } },
                )
            }
            betweenTermAndDescriptionContent ?.invoke(this, i, t)
            if (itemDescriptionAttrs != null || itemDescriptionContent != null) {
                DDescription(
                    itemDescriptionAttrs ?.let { { it(i, t) } },
                    itemDescriptionContent ?.let { { it(i, t) } },
                )
            }
            afterDescriptionContent ?.invoke(this, i, t)
        }
    }
}
