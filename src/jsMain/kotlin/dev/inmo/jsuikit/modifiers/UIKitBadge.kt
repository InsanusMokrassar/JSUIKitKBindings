package dev.inmo.jsuikit.modifiers

sealed class UIKitBadge(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    companion object : UIKitBadge("uk-badge")
}
