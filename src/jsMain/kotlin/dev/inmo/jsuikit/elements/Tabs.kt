package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitTab
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.optionallyDraw
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLUListElement

@Composable
fun <T> Tabs(
    data: Iterable<T>,
    tabsItemBuilder: @Composable ElementScope<HTMLLIElement>.(i: Int, data: T) -> Unit,
    tabsItemAttrs: AttrsScope<HTMLLIElement>.(i: Int, data: T) -> Unit = { _, _ -> },
    tabsContainerAttrs: AttrsScope<HTMLUListElement>.() -> Unit = {},
    contentContainerAttrs: (AttrsScope<HTMLUListElement>.() -> Unit)? = null,
    contentItemAttrs: (AttrsScope<HTMLLIElement>.(i: Int, data: T) -> Unit)? = null,
    contentItemBuilder: (@Composable ElementScope<HTMLLIElement>.(i: Int, data: T) -> Unit)? = null
) {
    Ul({
        include(UIKitTab);
        tabsContainerAttrs()
    }) {
        data.forEachIndexed { i, data ->
            Li({ tabsItemAttrs(i, data) }) {
                tabsItemBuilder(i, data)
            }
        }
    }

    optionallyDraw(contentItemAttrs != null, contentItemBuilder != null, contentContainerAttrs != null) {
        Ul({
            contentContainerAttrs ?.invoke(this)
        }) {
            optionallyDraw(contentItemAttrs != null, contentItemBuilder != null) {
                data.forEachIndexed { i, data ->
                    Li({ contentItemAttrs ?.invoke(this, i, data) }) {
                        contentItemBuilder ?.invoke(this, i, data)
                    }
                }
            }
        }
    }
}
