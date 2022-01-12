package dev.inmo.jsuikit.modifers

sealed class UIKitPosition(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    sealed class Top(classname: String) : UIKitPosition(classname) {
        companion object : Top("uk-position-top")

        object Left : Top("uk-position-top-left")
        object Center : Top("uk-position-top-center")
        object Right : Top("uk-position-top-right")
    }
    sealed class Left(classname: String) : UIKitPosition(classname) {
        companion object : Left("uk-position-left")
    }
    sealed class Right(classname: String) : UIKitPosition(classname) {
        companion object : Right("uk-position-right")
    }
    sealed class Center(classname: String) : UIKitPosition(classname) {
        companion object : Center("uk-position-center")

        sealed class Left(classname: String) : Center(classname) {
            object Out : Left("uk-position-center-left-out")

            companion object : Left("uk-position-center-left")
        }
        sealed class Right(classname: String) : Center(classname) {
            object Out : Right("uk-position-center-right-out")

            companion object : Right("uk-position-center-right")
        }
    }
    sealed class Bottom(classname: String) : UIKitPosition(classname) {
        companion object : Bottom("uk-position-bottom")

        object Left : Bottom("uk-position-bottom-left")
        object Center : Bottom("uk-position-bottom-center")
        object Right : Bottom("uk-position-bottom-right")
    }

    sealed class Size(classname: String) : UIKitPosition(classname) {
        object Small : Size("uk-position-small")
        object Medium : Size("uk-position-medium")
        object Large : Size("uk-position-large")
    }

    object Relative : UIKitPosition("uk-position-relative")
    object Absolute : UIKitPosition("uk-position-absolute")
    object Fixed : UIKitPosition("uk-position-fixed")
    object ZIndex : UIKitPosition("uk-position-z-index")
    object Cover : UIKitPosition("uk-position-cover")

}
