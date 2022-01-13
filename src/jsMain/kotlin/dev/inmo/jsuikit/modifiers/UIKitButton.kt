package dev.inmo.jsuikit.modifiers

sealed class UIKitButton(suffix: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-button-$suffix")

    sealed class Type(suffix: String) : UIKitButton(suffix) {
        object Default : Type("default")
        object Primary : Type("primary")
        object Secondary : Type("secondary")
        object Danger : Type("danger")
        object Text : Type("text")
        object Link : Type("link")
    }
}
