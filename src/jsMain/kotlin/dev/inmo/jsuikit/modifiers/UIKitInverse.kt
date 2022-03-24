package dev.inmo.jsuikit.modifiers

sealed class UIKitInverse(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Light : UIKitInverse("uk-light")
    object Dark : UIKitInverse("uk-dark")
}
