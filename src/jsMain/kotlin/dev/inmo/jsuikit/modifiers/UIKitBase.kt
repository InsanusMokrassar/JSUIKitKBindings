package dev.inmo.jsuikit.modifiers

sealed class UIKitBase(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    sealed class Heading(suffix: String) : UIKitBase("uk-h$suffix") {
        object H1 : Heading("1")
        object H2 : Heading("2")
        object H3 : Heading("3")
        object H4 : Heading("4")
        object H5 : Heading("5")
        object H6 : Heading("6")
    }
}
