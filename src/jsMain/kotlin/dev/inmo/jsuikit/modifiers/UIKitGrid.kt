package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.buildAttribute

sealed class UIKitGrid(vararg classnames: String) : UIKitModifier {
    override val classes: Array<String> = classnames as Array<String>

    sealed class Gap(classname: String) : UIKitGrid(classname) {

        object Small : Gap("uk-grid-small")
        object Medium : Gap("uk-grid-medium")
        object Large : Gap("uk-grid-large")
        object Collapse : Gap("uk-grid-collapse")

    }

    sealed class Column(classname: String) : UIKitGrid(classname) {

        object Small : Column("uk-grid-column-small")
        object Medium : Column("uk-grid-column-medium")
        object Large : Column("uk-grid-column-large")
        object Collapse : Column("uk-grid-column-collapse")

    }

    sealed class Row(classname: String) : UIKitGrid(classname) {

        object Small : Row("uk-grid-row-small")
        object Medium : Row("uk-grid-row-medium")
        object Large : Row("uk-grid-row-large")
        object Collapse : Row("uk-grid-row-collapse")

    }

    object Divider : UIKitGrid("uk-grid-divider")

    object MatchHeight : UIKitGrid("uk-grid-match")
    object ItemMatchHeight : UIKitGrid("uk-grid-item-match")

    class Custom internal constructor(override val otherAttrs: Map<String, String>) : UIKitGrid("uk-grid")

    companion object : UIKitGrid("uk-grid") {
        operator fun invoke(
            margin: UIKitMargin? = null,
            firstColumnClass: String? = null,
            masonry: Boolean? = null,
            parallax: UInt? = null
        ) = Custom(
            mapOf(
                buildAttribute("uk-grid") {
                    margin to margin ?.classes ?.joinToString(" ")
                    "first-column" to firstColumnClass
                    "masonry" to masonry
                    "parallax" to parallax
                }
            )
        )
    }
}
