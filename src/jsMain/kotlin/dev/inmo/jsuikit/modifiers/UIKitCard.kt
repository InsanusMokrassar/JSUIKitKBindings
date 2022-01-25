package dev.inmo.jsuikit.modifiers

sealed class UIKitCard(suffix: String?) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-card${suffix ?.let { "-$it" } ?: ""}")

    object Title : UIKitCard("title")
    object Hover : UIKitCard("hover")
    object Badge : Parts("badge")

    sealed class Parts(suffix: String) : UIKitCard(suffix) {
        object Header : Parts("header")
        object Body : Parts("body")
        object Footer : Parts("footer")
    }

    sealed class Style(suffix: String) : UIKitCard(suffix) {
        object Default : Style("default")
        object Primary : Style("primary")
        object Secondary : Style("secondary")
    }

    sealed class Size(suffix: String) : UIKitCard(suffix) {
        object Small : Size("small")
        object Large : Size("large")
    }

    sealed class Media(suffix: String) : UIKitCard("media-$suffix") {
        object Top : Media("top")
        object Right : Media("right")
        object Bottom : Media("bottom")
        object Left : Media("left")
    }

    companion object : UIKitCard(null)
}
