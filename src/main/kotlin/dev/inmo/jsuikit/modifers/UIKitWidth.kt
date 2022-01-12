package dev.inmo.jsuikit.modifers

sealed class UIKitWidth(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-width-$classname")

    object Full : UIKitWidth("1-1")
    object Expand : UIKitWidth("expand")

    object Half : UIKitWidth("1-2")

    object OneThird : UIKitWidth("1-3")
    object TwoThird : UIKitWidth("2-3")

    object OneFourth : UIKitWidth("1-4")
    val TwoFourth get() = Half
    object ThreeFourth : UIKitWidth("3-4")
    val FourFourth get() = Full

    object OneFifth : UIKitWidth("1-5")
    object TwoFifth : UIKitWidth("2-5")
    object ThreeFifth : UIKitWidth("3-5")
    object FourFifth : UIKitWidth("4-5")
    val FiveFifth get() = Full

    object OneSixth : UIKitWidth("1-6")
    val TwoSixth get() = OneThird
    val ThreeSixth get() = Half
    val FourSixth get() = TwoThird
    object FiveSixth : UIKitWidth("5-6")
    val SixSixth get() = Full

    override fun toString() = classes.first()
}
