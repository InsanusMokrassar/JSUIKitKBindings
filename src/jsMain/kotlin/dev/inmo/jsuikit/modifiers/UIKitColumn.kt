package dev.inmo.jsuikit.modifiers

sealed class UIKitColumn(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Two : UIKitColumn("uk-column-1-2")
    object Three : UIKitColumn("uk-column-1-3")
    object Four : UIKitColumn("uk-column-1-4")
    object Five : UIKitColumn("uk-column-1-5")
    object Six : UIKitColumn("uk-column-1-6")

    object Divider : UIKitColumn("uk-column-divider")

    object Span : UIKitColumn("uk-column-span")
}
