package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLUListElement

@Composable
fun <T> List(
    data: SnapshotStateList<T>,
    ukAttrs: Attrs<HTMLUListElement> = Attrs.empty(),
    elementAllocator: @Composable ElementScope<HTMLUListElement>.(T) -> Unit
) {
    Ul(
        {
            include(UIKitList)
            ukAttrs.builder(this)
        }
    ) {
        data.forEach {
            elementAllocator(it)
        }
    }
}

@Composable
fun <T> ListWithTitle(
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
    List(data, Attrs(*ulModifiers) { ulCustomizer(this) }, elementAllocator)
}
