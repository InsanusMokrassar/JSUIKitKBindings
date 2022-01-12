package dev.inmo.jsuikit.defaults.modifers

sealed class UIKitGrid(suffix: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-grid-$suffix")

    sealed class Gap(suffix: String) : UIKitGrid(suffix) {

        object Small : Gap("small")
        object Medium : Gap("medium")
        object Large : Gap("large")
        object Collapse : Gap("collapse")

    }

    object Divider : UIKitGrid("divider")

    object MatchHeight : UIKitGrid("match")
    object ItemMatchHeight : UIKitGrid("item-match")

}
