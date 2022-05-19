package dev.inmo.jsuikit.modifiers

sealed class UIKitSection(vararg classes: String) : UIKitModifier {
    override val classes: Array<String> = classes as Array<String>

    sealed class Style(suffix: String) : UIKitSection("uk-section-$suffix") {
        object Default : Style("default")
        object Muted : Style("muted")
        object Primary : Style("primary")
        object Secondary : Style("secondary")
    }

    sealed class Size(suffix: String) : UIKitSection("uk-section-$suffix") {
        object XSmall : Size("xsmall")
        object Small : Size("small")
        object Large : Size("large")
        object XLarge : Size("xlarge")
    }

    object Overlap : UIKitSection("uk-section-overlap")

    companion object : UIKitSection("uk-section")
}
