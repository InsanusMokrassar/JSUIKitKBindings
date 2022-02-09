package dev.inmo.jsuikit.modifiers

sealed class UIKitAlert(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    sealed class Style(classname: String) : UIKitAlert(classname) {

        object Primary : Style("uk-alert-primary")
        object Success : Style("uk-alert-success")
        object Warning : Style("uk-alert-warning")
        object Danger : Style("uk-alert-danger")

    }

    object Close : UIKitAlert("uk-alert-close")

    companion object : UIKitAlert("uk-alert")
}
