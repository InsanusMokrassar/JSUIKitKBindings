package dev.inmo.jsuikit.modifiers

sealed class UIKitNav(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object ParentIcon : UIKitNav("uk-nav-parent-icon")
    object SubNav : UIKitNav("uk-nav-sub")

    object Header : UIKitNav("uk-nav-header")
    object Divider : UIKitNav("uk-nav-divider")

    object Default : UIKitNav("uk-nav-default")

    object Primary : UIKitNav("uk-nav-primary")

    object Center : UIKitNav("uk-nav-center")

    companion object : UIKitNav("uk-nav")
}
