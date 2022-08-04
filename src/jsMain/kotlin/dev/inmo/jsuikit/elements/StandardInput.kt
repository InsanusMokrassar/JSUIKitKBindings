package dev.inmo.jsuikit.elements

import androidx.compose.runtime.*
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLInputElement

@Composable
fun <T> StandardInput(
    type: InputType<T>,
    state: MutableState<T>,
    disabledState: State<Boolean>? = null,
    placeholder: String? = null,
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLInputElement> = {},
) {
    Input(type) {
        classes("uk-input")
        include(*modifiers)

        placeholder ?.let(::placeholder)

        state.value.let {
            when (it) {
                is String -> value(it)
                is Number -> value(it)
                else -> {}
            }
        }

        onInput { state.value = it.value }

        disabledState ?.let {
            if (it.value) {
                disabled()
            }
        }
        attributesCustomizer()
    }
}
