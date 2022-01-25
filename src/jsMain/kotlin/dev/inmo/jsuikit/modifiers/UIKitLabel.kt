package dev.inmo.jsuikit.modifiers

sealed class UIKitLabel(suffix: String?) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-label${suffix?.let { "-$it" } ?: ""}")

    object Success : UIKitLabel("success")
    object Warning : UIKitLabel("warning")
    object Error : UIKitLabel("danger")

    companion object : UIKitLabel(null)
}
