package dev.inmo.jsuikit.modifiers

sealed class UIKitMargin(vararg classnames: String) : UIKitModifier {
    @Suppress("UNCHECKED_CAST")
    override val classes: Array<String> = classnames as Array<String>

    object Top : UIKitMargin("uk-margin-top")
    object Bottom : UIKitMargin("uk-margin-bottom")
    object Left : UIKitMargin("uk-margin-left")
    object Right : UIKitMargin("uk-margin-right")
    object Vertical : UIKitMargin() { override val classes: Array<String> = Top.classes + Bottom.classes }
    object Horizontal : UIKitMargin() { override val classes: Array<String> = Left.classes + Right.classes }
    companion object : Small("uk-margin")

    sealed class Small(vararg classnames: String) : UIKitMargin(*classnames) {

        object Top : Small("uk-margin-small-top")
        object Bottom : Small("uk-margin-small-bottom")
        object Left : Small("uk-margin-small-left")
        object Right : Small("uk-margin-small-right")

        object Vertical : Small() {
            override val classes: Array<String> = Top.classes + Bottom.classes
        }
        object Horizontal : Small() {
            override val classes: Array<String> = Left.classes + Right.classes
        }

        companion object : Small("uk-margin-small")

    }
    sealed class Medium(vararg classnames: String) : UIKitMargin(*classnames) {

        object Top : Medium("uk-margin-medium-top")
        object Bottom : Medium("uk-margin-medium-bottom")
        object Left : Medium("uk-margin-medium-left")
        object Right : Medium("uk-margin-medium-right")
        object Vertical : Medium() { override val classes: Array<String> = Top.classes + Bottom.classes }
        object Horizontal : Medium() { override val classes: Array<String> = Left.classes + Right.classes }
        companion object : Medium("uk-margin-medium")

    }
    sealed class Large(vararg classnames: String) : UIKitMargin(*classnames) {

        object Top : Large("uk-margin-large-top")
        object Bottom : Large("uk-margin-large-bottom")
        object Left : Large("uk-margin-large-left")
        object Right : Large("uk-margin-large-right")
        object Vertical : Large() { override val classes: Array<String> = Top.classes + Bottom.classes }
        object Horizontal : Large() { override val classes: Array<String> = Left.classes + Right.classes }
        companion object : Large("uk-margin-large")

    }
    sealed class XLarge(vararg classnames: String) : UIKitMargin(*classnames) {

        object Top : XLarge("uk-margin-xlarge-top")
        object Bottom : XLarge("uk-margin-xlarge-bottom")
        object Left : XLarge("uk-margin-xlarge-left")
        object Right : XLarge("uk-margin-xlarge-right")
        object Vertical : XLarge() { override val classes: Array<String> = Top.classes + Bottom.classes }
        object Horizontal : XLarge() { override val classes: Array<String> = Left.classes + Right.classes }
        companion object : XLarge("uk-margin-xlarge")

    }
    sealed class Auto(vararg classnames: String) : UIKitMargin(*classnames) {

        object Top : Auto("uk-margin-auto-top")
        object Bottom : Auto("uk-margin-auto-bottom")
        object Left : Auto("uk-margin-auto-left")
        object Right : Auto("uk-margin-auto-right")
        object Vertical : Auto("uk-margin-auto-vertical")
        object Horizontal : Auto() { override val classes: Array<String> = Left.classes + Right.classes }
        companion object : Auto("uk-margin-auto")

    }

    sealed class Remove(vararg classnames: String) : UIKitMargin(*classnames) {

        object Top : Remove("uk-margin-remove-top")
        object Bottom : Remove("uk-margin-remove-bottom")
        object Left : Remove("uk-margin-remove-left")
        object Right : Remove("uk-margin-remove-right")
        object Vertical : Remove("uk-margin-remove-vertical")
        object Horizontal : Remove() { override val classes: Array<String> = Left.classes + Right.classes }
        object Adjacent : Remove("uk-margin-remove-adjacent")
        object FirstChild : Remove("uk-margin-remove-first-child")
        object LastChild : Remove("uk-margin-remove-last-child")
        companion object : Remove("uk-margin-remove")

    }
}
