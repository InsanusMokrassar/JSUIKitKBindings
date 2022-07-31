package dev.inmo.jsuikit.modifiers

sealed class UIKitIconnav(
    override val classes: Array<String>
) : UIKitModifier {

    object Vertical : UIKitIconnav(arrayOf("uk-iconnav-vertical"))

    companion object : UIKitIconnav(arrayOf("uk-iconnav"))

}
