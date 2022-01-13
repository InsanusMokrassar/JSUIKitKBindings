package dev.inmo.jsuikit.elements

import androidx.compose.runtime.*
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLInputElement

@Composable
fun <T> TextField(
    type: InputType<T>,
    state: MutableState<T>,
    disabledState: State<Boolean>? = null,
    placeholder: String? = null,
    attributesCustomizer: AttrBuilderContext<HTMLInputElement> = {},
    modifiers: Array<UIKitModifier> = emptyArray()
) {
    Input(type) {
        classes("uk-input")
        include(*modifiers)

        placeholder ?.let(::placeholder)

        onChange { state.value = it.value }
        disabledState ?.let {
            if (it.value) {
                disabled()
            }
        }
        attributesCustomizer()
    }
}
