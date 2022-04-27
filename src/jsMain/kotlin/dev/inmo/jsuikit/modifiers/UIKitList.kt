package dev.inmo.jsuikit.modifiers

sealed class UIKitList(
    vararg classes: String,
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {
    @Suppress("UNCHECKED_CAST")
    override val classes: Array<String> = classes as Array<String>

    sealed class Style(vararg classes: String) : UIKitList(*classes) {

        object Disc : Style("uk-list-disc")
        object Circle : Style("uk-list-circle")
        object Square : Style("uk-list-square")
        object Decimal : Style("uk-list-decimal")
        object Hyphen : Style("uk-list-hyphen")

    }

    sealed class Size(vararg classes: String) : UIKitList(*classes) {

        object Large : Size("uk-list-large")
        object Collapse : Size("uk-list-collapse")

    }

    sealed class Color(vararg classes: String) : UIKitList(*classes) {

        object Muted : Color("uk-list-muted")
        object Emphasis : Color("uk-list-emphasis")
        object Primary : Color("uk-list-primary")
        object Secondary : Color("uk-list-secondary")
        companion object {
            val Bullet = UIKitList.Bullet
        }

    }

    object Bullet: UIKitList("uk-list-bullet")

    object Divider: UIKitList("uk-list-divider")

    object Striped: UIKitList("uk-list-striped")

    companion object : UIKitList("uk-list")
}
