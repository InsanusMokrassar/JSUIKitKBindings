package dev.inmo.jsuikit.modifers

sealed class UIKitAnimation (name: String) : UIKitModifier, AttributeValue(name) {
    override val classes: Array<String> = arrayOf("uk-animation-$name")

    object Fade : UIKitAnimation("fade")

    sealed class Scale(suffix: String) : UIKitAnimation("scale-$suffix") {

        object Up : Scale("up")
        object Down : Scale("down")

    }

    sealed class Slide(suffix: String) : UIKitAnimation("slide-$suffix") {

        sealed class Top(suffixWithStroke: String) : Slide("top$suffixWithStroke") {

            object Small : Top("-small")
            object Medium : Top("-medium")

            companion object : Top("")

        }

        sealed class Bottom(suffixWithStroke: String) : Slide("bottom$suffixWithStroke") {

            object Small : Bottom("-small")
            object Medium : Bottom("-medium")

            companion object : Bottom("")

        }

        sealed class Left(suffixWithStroke: String) : Slide("left$suffixWithStroke") {

            object Small : Left("-small")
            object Medium : Left("-medium")

            companion object : Left("")

        }

        sealed class Right(suffixWithStroke: String) : Slide("right$suffixWithStroke") {

            object Small : Right("-small")
            object Medium : Right("-medium")

            companion object : Right("")

        }

    }

    object Shake : UIKitAnimation("shake")

    object Stroke : UIKitAnimation("stroke")

    object Reverse : UIKitAnimation("reverse")

    object Fast : UIKitAnimation("fast")

}
