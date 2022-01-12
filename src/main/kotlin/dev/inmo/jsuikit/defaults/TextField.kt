package dev.inmo.jsuikit.defaults

import androidx.compose.runtime.*
import dev.inmo.jsuikit.defaults.modifers.UIKitModifier
import dev.inmo.jsuikit.defaults.modifers.include
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
