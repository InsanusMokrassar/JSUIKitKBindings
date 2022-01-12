package dev.inmo.jsuikit.defaults.modifers

sealed class UIKitBackground(suffix: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-background-$suffix")

    sealed class Color(suffix: String) : UIKitBackground(suffix) {
        object Default : Color("default")
        object Muted : Color("muted")
        object Primary : Color("primary")
        object Secondary : Color("secondary")
    }

    sealed class Size(suffix: String) : UIKitBackground(suffix) {
        object Cover : Size("cover")
        object Contain : Size("contain")
        object FullWidth : Size("width-1-1")
        object FullHeight : Size("height-1-1")
    }

    sealed class Position(suffix: String) : UIKitBackground(suffix) {

        sealed class Top(suffix: String) : Position("top-$suffix") {
            object Left : Top("left")
            object Center : Top("center")
            object Right : Top("right")
        }

        sealed class Center(suffix: String) : Position("center-$suffix") {
            object Left : Position.Center("left")
            object Center : Position.Center("center")
            object Right : Position.Center("right")
        }

        sealed class Bottom(suffix: String) : Position("bottom-$suffix") {
            object Left : Bottom("left")
            object Center : Bottom("center")
            object Right : Bottom("right")
        }

    }

    object NoRepeat : Size("norepeat")

    object Fixed : Size("fixed")

}
