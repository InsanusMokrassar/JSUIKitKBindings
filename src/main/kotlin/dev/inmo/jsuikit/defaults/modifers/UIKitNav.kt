package dev.inmo.jsuikit.defaults.modifers

sealed class UIKitNav(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Accordion : UIKitNav("uk-nav-parent-icon")
    object Subnav : UIKitNav("uk-nav-sub")

    object Header : UIKitNav("uk-nav-header")
    object Divider : UIKitNav("uk-nav-divider")

    object Default : UIKitNav("uk-nav-default")

    object Primary : UIKitNav("uk-nav-primary")

    object Center : UIKitNav("uk-nav-center")
}
