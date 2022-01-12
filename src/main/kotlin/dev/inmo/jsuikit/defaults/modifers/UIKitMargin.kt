package dev.inmo.jsuikit.defaults.modifers

sealed class UIKitMargin(val classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Top : Small("uk-margin-top")
    object Bottom : Small("uk-margin-bottom")
    object Left : Small("uk-margin-left")
    object Right : Small("uk-margin-right")
    companion object : Small("uk-margin")

    sealed class Small(classname: String) : UIKitMargin(classname) {

        object Top : Small("uk-margin-small-top")
        object Bottom : Small("uk-margin-small-bottom")
        object Left : Small("uk-margin-small-left")
        object Right : Small("uk-margin-small-right")
        companion object : Small("uk-margin-small")

    }
    sealed class Medium(classname: String) : UIKitMargin(classname) {

        object Top : Medium("uk-margin-medium-top")
        object Bottom : Medium("uk-margin-medium-bottom")
        object Left : Medium("uk-margin-medium-left")
        object Right : Medium("uk-margin-medium-right")
        companion object : Medium("uk-margin-medium")

    }
    sealed class Large(classname: String) : UIKitMargin(classname) {

        object Top : Large("uk-margin-large-top")
        object Bottom : Large("uk-margin-large-bottom")
        object Left : Large("uk-margin-large-left")
        object Right : Large("uk-margin-large-right")
        companion object : Large("uk-margin-large")

    }
    sealed class XLarge(classname: String) : UIKitMargin(classname) {

        object Top : XLarge("uk-margin-xlarge-top")
        object Bottom : XLarge("uk-margin-xlarge-bottom")
        object Left : XLarge("uk-margin-xlarge-left")
        object Right : XLarge("uk-margin-xlarge-right")
        companion object : XLarge("uk-margin-xlarge")

    }
    sealed class Auto(classname: String) : UIKitMargin(classname) {

        object Top : Auto("uk-margin-auto-top")
        object Bottom : Auto("uk-margin-auto-bottom")
        object Left : Auto("uk-margin-auto-left")
        object Right : Auto("uk-margin-auto-right")
        object Vertical : Auto("uk-margin-auto-vertical")
        companion object : Auto("uk-margin-auto")

    }

    sealed class Remove(classname: String) : UIKitMargin(classname) {

        object Top : Remove("uk-margin-remove-top")
        object Bottom : Remove("uk-margin-remove-bottom")
        object Left : Remove("uk-margin-remove-left")
        object Right : Remove("uk-margin-remove-right")
        object Vertical : Remove("uk-margin-remove-vertical")
        object Adjacent : Remove("uk-margin-remove-adjacent")
        object FirstChild : Remove("uk-margin-remove-first-child")
        object LastChild : Remove("uk-margin-remove-last-child")
        companion object : Remove("uk-margin-remove")

    }
}
