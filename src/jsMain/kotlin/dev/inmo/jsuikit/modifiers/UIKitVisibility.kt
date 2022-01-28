package dev.inmo.jsuikit.modifiers

sealed class UIKitVisibility(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    sealed class Hidden(suffix: String?) : UIKitModifier {
        override val classes: Array<String> = arrayOf("uk-hidden${suffix ?.let { "-$it" } ?: ""}")

        object Hover : Hidden("hover")
        sealed class Touch(suffix: String?) : Hidden(suffix) {
            override val classes: Array<String> = arrayOf("${suffix ?: ""}touch")

            object No : Touch("no")

            companion object : Touch(null)
        }

        companion object : Hidden(null) {
            val NoTouch = Touch.No
        }
    }

    sealed class Invisible(suffix: String?) : UIKitModifier {
        override val classes: Array<String> = arrayOf("uk-invisible${suffix ?.let { "-$it" } ?: ""}")

        object Hover : Invisible("hover")

        companion object : Invisible(null)
    }
}
