package dev.inmo.jsuikit.modifiers

sealed class UIKitWidth(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Auto : UIKitWidth("uk-width-auto")
    object Expand : UIKitWidth("uk-width-expand")
    object Full : UIKitWidth("uk-width-1-1")

    object Half : UIKitWidth("uk-width-1-2")

    object OneThird : UIKitWidth("uk-width-1-3")
    object TwoThird : UIKitWidth("uk-width-2-3")

    object OneFourth : UIKitWidth("uk-width-1-4")
    object ThreeFourth : UIKitWidth("uk-width-3-4")

    object OneFifth : UIKitWidth("uk-width-1-5")
    object TwoFifth : UIKitWidth("uk-width-2-5")
    object ThreeFifth : UIKitWidth("uk-width-3-5")
    object FourFifth : UIKitWidth("uk-width-4-5")

    object OneSixth : UIKitWidth("uk-width-1-6")
    object FiveSixth : UIKitWidth("uk-width-5-6")

    sealed class Child(suffix: String) : UIKitWidth("uk-child-width-$suffix") {
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

    sealed class Fixed(suffix: String) : UIKitWidth("uk-width-$suffix") {

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
