package dev.inmo.jsuikit.modifiers

sealed class UIKitIcon(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    companion object : UIKitIcon("uk-icon")
}
