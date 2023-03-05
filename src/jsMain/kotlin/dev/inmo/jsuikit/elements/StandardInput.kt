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
    value: T? = null,
    vararg modifiers: UIKitModifier,
    disabled: Boolean = false,
    placeholder: String? = null,
    attributesCustomizer: AttrBuilderContext<HTMLInputElement> = {},
    onChange: HTMLInputElement.(T) -> Unit
) {
    Input(type) {
        classes("uk-input")
        include(*modifiers)

        placeholder ?.let(::placeholder)

        value ?.let {
            when (it) {
                is String -> value(it)
                is Number -> value(it)
                else -> {}
            }
        }

        onInput { event -> event.target.onChange(event.value) }

        if (disabled) {
            disabled()
        }
        attributesCustomizer()
    }
}

@Deprecated("Renamed", ReplaceWith("StandardInput(type, value, *modifiers, disabled, placeholder, attributesCustomizer, onChange)"))
@Composable
fun <T> DefaultInput(
    type: InputType<T>,
    value: T,
    disabled: Boolean = false,
    placeholder: String? = null,
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLInputElement> = {},
    onChange: (T) -> Unit
) = StandardInput(type, value, modifiers = modifiers, disabled, placeholder, attributesCustomizer) {
    onChange(it)
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
    modifiers = modifiers,
    disabledState ?.value == true,
    placeholder,
    attributesCustomizer = attributesCustomizer
) {
    state.value = it
}
