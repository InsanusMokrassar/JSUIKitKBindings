package dev.inmo.jsuikit.modifiers

sealed class UIKitWidth(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-width-$classname")

    object Auto : UIKitWidth("auto")
    object Expand : UIKitWidth("expand")
    object Full : UIKitWidth("1-1")

    object Half : UIKitWidth("1-2")

    object OneThird : UIKitWidth("1-3")
    object TwoThird : UIKitWidth("2-3")

    object OneFourth : UIKitWidth("1-4")
    object ThreeFourth : UIKitWidth("3-4")

    object OneFifth : UIKitWidth("1-5")
    object TwoFifth : UIKitWidth("2-5")
    object ThreeFifth : UIKitWidth("3-5")
    object FourFifth : UIKitWidth("4-5")

    object OneSixth : UIKitWidth("1-6")
    object FiveSixth : UIKitWidth("5-6")

    sealed class Child(suffix: String) : UIKitWidth("child-$suffix") {
        object Full : Child("1-1")

        object Half : Child("1-2")

        object OneThird : Child("1-3")
        object TwoThird : Child("2-3")

        object OneFourth : Child("1-4")
        object ThreeFourth : Child("3-4")

        object OneFifth : Child("1-5")
        object TwoFifth : Child("2-5")
        object ThreeFifth : Child("3-5")
        object FourFifth : Child("4-5")

        object OneSixth : Child("1-6")
        object FiveSixth : Child("5-6")

        object Auto : Child("auto")
        object Expand : Child("expand")

        companion object {

            val TwoFourth get() = Half
            val TwoSixth get() = OneThird
            val ThreeSixth get() = Half
            val FourSixth get() = TwoThird
            val FourFourth get() = Full
            val FiveFifth get() = Full
            val SixSixth get() = Full
        }
    }

    sealed class Fixed(suffix: String) : UIKitWidth("fixed-$suffix") {

        object Small : Fixed("small")
        object Medium : Fixed("medium")
        object Large : Fixed("large")
        object XLarge : Fixed("xlarge")
        object XXLarge : Fixed("2xlarge")

    }

    override fun toString() = classes.first()

    companion object {

        val TwoFourth get() = Half
        val TwoSixth get() = OneThird
        val ThreeSixth get() = Half
        val FourSixth get() = TwoThird
        val FourFourth get() = Full
        val FiveFifth get() = Full
        val SixSixth get() = Full
    }
}
