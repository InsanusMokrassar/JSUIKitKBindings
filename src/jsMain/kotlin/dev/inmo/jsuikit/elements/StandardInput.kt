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
    value: T,
    disabled: Boolean = false,
    placeholder: String? = null,
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLInputElement> = {},
    onChange: (T) -> Unit
) {
    Input(type) {
        classes("uk-input")
        include(*modifiers)

        placeholder ?.let(::placeholder)

        value.let {
            when (it) {
                is String -> value(it)
                is Number -> value(it)
                else -> {}
            }
        }

        onInput { onChange(it.value) }

        if (disabled) {
            disabled()
        }
        attributesCustomizer()
    }
}

@Composable
fun <T> StandardInput(
    type: InputType<T>,
    state: MutableState<T>,
    disabledState: State<Boolean>? = null,
    placeholder: String? = null,
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLInputElement> = {},
) = StandardInput(
    type,
    state.value,
    disabledState ?.value == true,
    placeholder,
    modifiers = modifiers,
    attributesCustomizer = attributesCustomizer
) {
    state.value = it
}
