package dev.inmo.jsuikit.modifiers

sealed class UIKitButton(suffix: String?) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-button${suffix?.let { "-$it" } ?: ""}")

    sealed class Type(suffix: String) : UIKitButton(suffix) {
        object Default : Type("default")
        object Primary : Type("primary")
        object Secondary : Type("secondary")
        object Danger : Type("danger")
        object Text : Type("text")
        object Link : Type("link")
    }

    sealed class Size(suffix: String) : UIKitButton(suffix) {
        object Small : Size("small")
        object Large : Size("large")
    }

    object Group : UIKitButton("group")

    companion object : UIKitButton(null)
}
