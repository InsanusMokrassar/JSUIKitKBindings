package dev.inmo.jsuikit.modifiers

sealed class UIKitText(suffix: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-text-$suffix")

    object Lead : UIKitText("lead")
    object Meta : UIKitText("meta")

    sealed class Alignment(suffix: String) : UIKitText(suffix) {
        object Left : Alignment("left")
        object Right : Alignment("right")
        object Center : Alignment("center")
        object Justify : Alignment("justify")
    }

    sealed class Color(suffix: String) : UIKitText(suffix) {
        object Muted : Color("muted")
        object Emphasis : Color("emphasis")
        object Primary : Color("primary")
        object Secondary : Color("secondary")
        object Success : Color("success")
        object Warning : Color("warning")
        object Danger : Color("danger")
    }
}
