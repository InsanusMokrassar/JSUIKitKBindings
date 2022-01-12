package dev.inmo.jsuikit.elements

import androidx.compose.runtime.*
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.Input

@Composable
fun <T> TextField(
    type: InputType<T>,
    state: MutableState<T>,
    disabledState: State<Boolean>? = null,
    placeholder: String? = null,
    vararg modifiers: UIKitModifier
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
    }
}
