package dev.inmo.jsuikit.defaults.modifers

sealed class UIKitPadding(suffix: String?) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-padding${suffix ?.let { "-$it" } ?: ""}")

    sealed class Size(suffix: String?) : UIKitPadding(suffix) {

        object Small : Size("small")
        object Large : Size("large")

        companion object : Size(null)

    }

    sealed class Remove(suffix: String?) : UIKitPadding("remove${suffix ?.let { "-$it" } ?: ""}") {

        object Top : Remove("top")
        object Bottom : Remove("bottom")
        object Left : Remove("left")
        object Right : Remove("right")
        object Vertical : Remove("vertical")
        object Horizontal : Remove("horizontal")

        companion object : Remove(null)

    }


}
