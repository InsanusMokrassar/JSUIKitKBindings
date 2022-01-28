package dev.inmo.jsuikit.modifiers

sealed class UIKitSubNav(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Divider : UIKitSubNav("uk-subnav-divider")
    object Pill : UIKitSubNav("uk-subnav-pill")

    companion object : UIKitSubNav("uk-subnav")
}
