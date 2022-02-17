package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.buildAttribute

sealed class UIKitForm(
    vararg classnames: String,
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {
    @Suppress("UNCHECKED_CAST")
    override val classes: Array<String> = classnames as Array<String>

    object Fieldset : UIKitForm("uk-fieldset")
    object Legend : UIKitForm("uk-legend")

    object Input : UIKitForm("uk-input")
    object Select : UIKitForm("uk-select")
    object TextArea : UIKitForm("uk-textarea")
    object Radio : UIKitForm("uk-radio", otherAttrs = mapOf("type" to "radio"))
    object Checkbox : UIKitForm("uk-checkbox", otherAttrs = mapOf("type" to "checkbox"))
    object Range : UIKitForm("uk-range", otherAttrs = mapOf("type" to "range"))

    sealed class State(vararg classnames: String) : UIKitForm(*classnames) {
        object Danger : State("uk-form-danger")
        object Success : State("uk-form-success")
    }
    sealed class Size(vararg classnames: String) : UIKitForm(*classnames) {
        object Large : Size("uk-form-large")
        object Default : Size() // :)
        object Small : Size("uk-form-small")
    }
    sealed class Width(vararg classnames: String) : UIKitForm(*classnames) {
        object Large : Width("uk-form-width-large")
        object Medium : Width("uk-form-width-medium")
        object Small : Width("uk-form-width-small")
        object XSmall : Width("uk-form-width-xsmall")
    }

    object Blank : UIKitForm("uk-form-blank")

    sealed class Layout(vararg classnames: String) : UIKitForm(*classnames) {
        object Stacked : Layout("uk-form-stacked")
        object Horizontal : Layout("uk-form-horizontal")
        object Label : Layout("uk-form-label")
        object Controls : Layout("uk-form-controls")
    }

    object Icon : UIKitForm("uk-form-icon")

    class Custom(
        target: String = "true"
    ) : UIKitForm(
        otherAttrs = mapOf(
            buildAttribute("uk-form-custom") {
                "target" to target
            }
        )
    )
}
