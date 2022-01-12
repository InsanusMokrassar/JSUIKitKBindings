package dev.inmo.jsuikit.defaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import dev.inmo.jsuikit.defaults.modifers.UIKitModifier
import dev.inmo.jsuikit.defaults.modifers.include
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLUListElement

@Composable
fun <T> List(
    title: String,
    data: SnapshotStateList<T>,
    titleModifiers: Array<UIKitModifier> = emptyArray(),
    ulModifiers: Array<UIKitModifier> = emptyArray(),
    besidesTitleAndList: (@Composable () -> Unit)? = null,
    elementAllocator: @Composable ElementScope<HTMLUListElement>.(T) -> Unit
) {
    H4({ include(*titleModifiers) }) {
        Text(title)
    }
    besidesTitleAndList ?.invoke()
    Ul(
        {
            classes("uk-list")
            include(*ulModifiers)
        }
    ) {
        data.forEach {
            elementAllocator(it)
        }
    }
}
