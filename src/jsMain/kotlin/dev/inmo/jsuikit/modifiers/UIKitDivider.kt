package dev.inmo.jsuikit.modifiers

sealed class UIKitDivider(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Icon : UIKitDivider("uk-divider-icon")
    object Small : UIKitDivider("uk-divider-small")
    object Vertical : UIKitDivider("uk-divider-vertical")

}
