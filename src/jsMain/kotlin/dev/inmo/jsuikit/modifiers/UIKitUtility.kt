package dev.inmo.jsuikit.modifiers

sealed class UIKitUtility(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Panel : UIKitUtility("uk-panel")

    sealed class Float(suffix: String) : UIKitUtility("uk-float-$suffix") {
        object Left : Float("left")
        object Right : Float("right")
    }
    object Clearfix : Float("clearfix")

    sealed class Overflow(suffix: String) : UIKitUtility("uk-overflow-$suffix") {
        object Hidden : Overflow("hidden")
        object Auto : Overflow("auto")
    }

    sealed class Resize(suffix: String?) : UIKitUtility("uk-resize${suffix ?.let { "-$it" } ?: ""}") {
        object Vertical : Resize("vertical")
        companion object : Resize(null)
    }

    sealed class Display(suffix: String) : UIKitUtility("uk-display-$suffix") {
        object Block : Display("block")
        sealed class Inline(suffix: String?) : Display("inline${suffix ?.let { "-$it" } ?: ""}") {
            object Block : Inline("block")
            companion object : Inline(null)
        }
    }

    sealed class Inline(suffix: String?) : UIKitUtility("uk-inline${suffix ?.let { "-$it" } ?: ""}") {
        object Clip : Inline("clip")
        companion object : Inline(null)
    }

    sealed class Responsive(suffix: String) : UIKitUtility("uk-responsive-$suffix") {
        object Width : Responsive("width")
        object Height : Responsive("height")
    }
    sealed class Preserve(suffix: String) : UIKitUtility("uk-preserve-$suffix") {
        object Width : Preserve("width")
        object Color : Preserve("color")
    }

    sealed class Border(suffix: String) : UIKitUtility("uk-border-$suffix") {
        object Rounded : Border("rounded")
        object Circle : Border("circle")
        object Pill : Border("pill")
    }

    sealed class BoxShadow(suffix: String) : UIKitUtility("uk-box-shadow-$suffix") {
        object Small : BoxShadow("small")
        object Medium : BoxShadow("medium")
        object Large : BoxShadow("large")
        object XLarge : BoxShadow("xlarge")

        object Bottom : BoxShadow("bottom")

        sealed class Hover(suffix: String) : BoxShadow("hover-$suffix") {
            object Small : Hover("small")
            object Medium : Hover("medium")
            object Large : Hover("large")
            object XLarge : Hover("xlarge")
        }
    }

    object DropCap : UIKitUtility("uk-dropcap")

    object Logo : UIKitUtility("uk-logo")

    sealed class Blend(suffix: String) : UIKitUtility("uk-blend-$suffix") {
        object Multiply : Blend("multiply")
        object Screen : Blend("screen")
        object Overlay : Blend("overlay")
        object Darken : Blend("darken")
        object Lighten : Blend("lighten")
        sealed class Color(suffix: String?) : Blend("color${suffix ?.let { "-$it" } ?: ""}") {
            object Dodge : Color("dodge")
            object Burn : Color("burn")
            companion object : Color(null)
        }
        object HardLight : Blend("hard-light")
        object SoftLight : Blend("soft-light")
        object Difference : Blend("difference")
        object Exclusion : Blend("exclusion")
        object Hue : Blend("hue")
        object Saturation : Blend("saturation")
        object Luminosity : Blend("luminosity")
    }

    sealed class Transform(suffix: String) : UIKitUtility("uk-transform-$suffix") {
        object Center : Transform("center")
        sealed class Origin(suffix: String) : Transform("origin-$suffix") {
            sealed class Top(suffix: String) : Origin("top-$suffix") {
                object Left : Top("left")
                object Center : Top("center")
                object Right : Top("right")
            }
            sealed class Center(suffix: String) : Origin("center-$suffix") {
                object Left : Center("left")
                object Right : Center("right")
            }
            sealed class Bottom(suffix: String) : Origin("bottom-$suffix") {
                object Left : Bottom("left")
                object Center : Bottom("center")
                object Right : Bottom("right")
            }
        }
    }

    object Disabled : UIKitUtility("uk-disabled")
    object Drag : UIKitUtility("uk-drag")
    object Active : UIKitUtility("uk-active")

    object Open : UIKitUtility("uk-open")
    object Link : UIKitUtility("uk-link")

    companion object {
        val PreserveWidth = Preserve.Width
    }
}
