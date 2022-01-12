package dev.inmo.jsuikit.modifers

sealed class UIKitDropdown(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Nav : UIKitDropdown("uk-dropdown-nav")

    object Grid : UIKitDropdown("uk-dropdown-grid")

    sealed class Position(name: String) : dev.inmo.jsuikit.modifers.AttributeValue(name) {

        sealed class Bottom(name: String) : Position("bottom-$name") {

            object Left : Bottom("left")
            object Center : Bottom("center")
            object Right : Bottom("right")
            object Justify : Bottom("justify")

        }

        sealed class Top(name: String) : Position("top-$name") {

            object Left : Top("left")
            object Center : Top("center")
            object Right : Top("right")
            object Justify : Top("justify")

        }

        sealed class Left(name: String) : Position("left-$name") {

            object Top : Left("top")
            object Center : Left("center")
            object Bottom : Left("bottom")

        }

        sealed class Right(name: String) : Position("right-$name") {

            object Top : Right("top")
            object Center : Right("center")
            object Bottom : Right("bottom")

        }

    }

    sealed class Mode(name: String) : dev.inmo.jsuikit.modifers.AttributeValue(name) {

        object Click : Mode("click")
        object Hover : Mode("hover")

    }

    sealed class Flip(name: String) : dev.inmo.jsuikit.modifers.AttributeValue(name) {

        object True : Flip("true")
        object False : Flip("false")
        object X : Flip("x")
        object Y : Flip("y")

    }

}
