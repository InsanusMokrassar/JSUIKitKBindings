package dev.inmo.jsuikit.modifiers

sealed class UIKitFlex(suffix: String?) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-flex${suffix ?.let { "-$it" } ?: ""}")

    object Inline : UIKitFlex("inline")

    sealed class Alignment(suffix: String) : UIKitFlex(suffix) {

        sealed class Horizontal(suffix: String) : Alignment(suffix) {

            object Left : Horizontal("left")
            object Center : Horizontal("center")
            object Right : Horizontal("right")
            object Between : Horizontal("between")
            object Around : Horizontal("around")

        }

        sealed class Vertical(suffix: String) : Alignment(suffix) {

            object Stretch : Vertical("stretch")
            object Top : Vertical("top")
            object Middle : Vertical("middle")
            object Bottom : Vertical("bottom")

        }

    }

    sealed class Direction(suffix: String) : UIKitFlex(suffix) {

        sealed class Row(suffix: String) : Direction(suffix) {

            object Reverse : Row("row-reverse")
            companion object : Row("row")

        }

        sealed class Column(suffix: String) : Direction(suffix) {

            object Reverse : Column("column-reverse")
            companion object : Column("column")

        }

    }

    sealed class Wrap(suffix: String) : UIKitFlex(suffix) {

        object Reverse : Wrap("wrap-reverse")
        object Stretch : Wrap("wrap-stretch")
        object Between : Wrap("wrap-between")
        object Around : Wrap("wrap-around")
        object Top : Wrap("wrap-top")
        object Middle : Wrap("wrap-middle")
        object Bottom : Wrap("wrap-bottom")
        companion object : Wrap("wrap")

    }

    sealed class Order(suffix: String) : UIKitFlex(suffix) {

        object First : Order("first")
        object Last : Order("last")

    }

    sealed class Dimensions(suffix: String) : UIKitFlex(suffix) {

        object None : Dimensions("none")
        object Auto : Dimensions("auto")
        object BasedOnFlex : Dimensions("1")

    }

    object NoWrap : UIKitFlex("nowrap")

    companion object : UIKitFlex(null)

}
