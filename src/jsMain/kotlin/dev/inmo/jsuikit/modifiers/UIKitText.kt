package dev.inmo.jsuikit.modifiers

sealed class UIKitText(suffix: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-text-$suffix")

    sealed class Style(suffix: String) : UIKitText(suffix) {
        object Lead : Style("lead")
        object Meta : Style("meta")
        object Italic : Style("italic")
    }

    sealed class Size(suffix: String) : UIKitText(suffix) {
        object Small : Size("small")
        object Default : Size("default")
        object Large : Size("large")
    }

    sealed class Weight(suffix: String) : UIKitText(suffix) {
        object Light : Weight("light")
        object Normal : Weight("normal")
        object Bold : Weight("bold")
        object Lighter : Weight("lighter")
        object Bolder : Weight("bolder")
    }

    sealed class Transform(suffix: String) : UIKitText(suffix) {
        object Capitalize : Transform("capitalize")
        object Uppercase : Transform("uppercase")
        object Lowercase : Transform("lowercase")
    }

    object DecorationNone : UIKitText("decoration-none")

    sealed class Color(suffix: String) : UIKitText(suffix) {
        object Muted : Color("muted")
        object Emphasis : Color("emphasis")
        object Primary : Color("primary")
        object Secondary : Color("secondary")
        object Success : Color("success")
        object Warning : Color("warning")
        object Danger : Color("danger")
    }

    object Background : UIKitText("background")

    sealed class Alignment(suffix: String) : UIKitText(suffix) {

        sealed class Horizontal(suffix: String) : Alignment(suffix) {
            object Left : Horizontal("left")
            object Right : Horizontal("right")
            object Center : Horizontal("center")
            object Justify : Horizontal("justify")
        }

        sealed class Vertical(suffix: String) : Alignment(suffix) {
            object Top : Vertical("top")
            object Middle : Vertical("middle")
            object Bottom : Vertical("bottom")
            object Baseline : Vertical("baseline")
        }

    }

    sealed class Wrapping(suffix: String) : UIKitText(suffix) {

        object Truncate : Wrapping("truncate")
        object Break : Wrapping("break")
        object NoWrap : Wrapping("nowrap")

    }
}
