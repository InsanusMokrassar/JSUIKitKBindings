package dev.inmo.jsuikit.modifers

sealed class UIKitTable(suffix: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-table-$suffix")

    object Divider : UIKitTable("divider")
    object Size {
        object Small : UIKitTable("small")
        object Large : UIKitTable("large")
    }
    object Hover : UIKitTable("hover")
    object Justify : UIKitTable("justify")
}
