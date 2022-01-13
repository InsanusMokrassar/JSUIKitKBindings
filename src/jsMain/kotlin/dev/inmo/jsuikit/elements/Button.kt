package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event

@Composable
fun DefaultButton(
    vararg modifiers: UIKitModifier,
    disabled: Boolean = false,
    buttonType: UIKitButton.Type = UIKitButton.Type.Default,
    onClick: ((SyntheticMouseEvent) -> Unit)? = null,
    attributesCustomizer: AttrBuilderContext<HTMLButtonElement> = {},
    contentAllocator: ContentBuilder<HTMLButtonElement>
) {
    Button(
        {
            onClick ?.let { onClick(it) }
            classes("uk-button")
            include(*modifiers, buttonType)
            if (disabled) {
                disabled()
            }
            attributesCustomizer()
        }
    ) {
        contentAllocator()
    }
}

@Composable
fun DefaultButton(
    text: String,
    vararg modifiers: UIKitModifier,
    disabled: Boolean = false,
    buttonType: UIKitButton.Type = UIKitButton.Type.Default,
    preTextContentAllocator: ContentBuilder<HTMLButtonElement>? = null,
    afterTextContentAllocator: ContentBuilder<HTMLButtonElement>? = null,
    attributesCustomizer: AttrBuilderContext<HTMLButtonElement> = {},
    onClick: ((SyntheticMouseEvent) -> Unit)? = null
) = DefaultButton(*modifiers, disabled = disabled, buttonType = buttonType, onClick = onClick, attributesCustomizer = attributesCustomizer) {
    preTextContentAllocator ?.apply { preTextContentAllocator() }
    Text(text)
    afterTextContentAllocator ?.apply { afterTextContentAllocator() }
}

@Composable
fun UploadButton(
    text: String,
    vararg buttonModifiers: UIKitModifier,
    containerModifiers: Array<UIKitModifier> = emptyArray(),
    disabled: Boolean = false,
    buttonType: UIKitButton.Type = UIKitButton.Type.Default,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    onChange: (Event) -> Unit
) {
    Div(
        {
            classes("js-upload", "uk-form-custom")
            attr("uk-form-custom", "")
            include(*containerModifiers)
            attributesCustomizer()
        }
    ) {
        Input(InputType.File) { onChange { onChange(it.nativeEvent) } }
        Button(
            {
                classes("uk-button")
                include(*buttonModifiers, buttonType)
                if (disabled) {
                    disabled()
                }
            }
        ) {
            Text(text)
        }
    }
}
