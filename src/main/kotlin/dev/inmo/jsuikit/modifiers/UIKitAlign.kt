package dev.inmo.jsuikit.modifiers

sealed class UIKitAlign(classnameSuffix: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-align-$classnameSuffix")
    object Left : UIKitAlign("left")
    object Center : UIKitAlign("center")
    object Right : UIKitAlign("right")
}
