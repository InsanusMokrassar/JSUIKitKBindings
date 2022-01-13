package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLUListElement

@Composable
fun <T> List(
    title: String,
    data: SnapshotStateList<T>,
    vararg titleModifiers: UIKitModifier,
    ulModifiers: Array<UIKitModifier> = emptyArray(),
    besidesTitleAndList: (@Composable () -> Unit)? = null,
    titleCustomizer: AttrBuilderContext<HTMLHeadingElement> = {},
    ulCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    elementAllocator: @Composable ElementScope<HTMLUListElement>.(T) -> Unit
) {
    H4({ include(*titleModifiers); titleCustomizer() }) {
        Text(title)
    }
    besidesTitleAndList ?.invoke()
    Ul(
        {
            classes("uk-list")
            include(*ulModifiers)
            ulCustomizer()
        }
    ) {
        data.forEach {
            elementAllocator(it)
        }
    }
}
