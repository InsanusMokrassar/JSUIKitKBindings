package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.Milliseconds
import dev.inmo.jsuikit.utils.buildAttribute

sealed class UIKitToggle(
    vararg classnames: String,
    override val otherAttrs: Map<String, String>
) : UIKitModifier {
    @Suppress("UNCHECKED_CAST")
    override val classes: Array<String> = classnames as Array<String>

    sealed class Mode {
        abstract val mode: String

        object Click : Mode() {
            override val mode: String
                get() = "click"
        }

        object Hover : Mode() {
            override val mode: String
                get() = "hover"
        }

        object ClickAndHover : Mode() {
            override val mode: String
                get() = "${Click.mode}, ${Hover.mode}"
        }

        object Media : Mode() {
            override val mode: String
                get() = "media"
        }

        override fun toString(): String = mode
    }

    class Custom internal constructor(otherAttrs: Map<String, String>) : UIKitToggle(otherAttrs = otherAttrs)

    companion object : UIKitToggle(otherAttrs = mapOf("uk-toggle" to "")) {
        operator fun invoke(
            target: String? = null,
            mode: Mode? = null,
            classesToApplyOnToggle: String? = null,
            media: String? = null,
            animation: UIKitAnimation? = null,
            duration: Milliseconds? = null,
            queued: Boolean? = null
        ) = Custom(
            mapOf(
                buildAttribute("uk-toggle") {
                    "target" to target
                    "mode" to mode
                    "cls" to classesToApplyOnToggle
                    "media" to media
                    "animation" to animation
                    "duration" to duration
                    "queued" to queued
                }
            )
        )
    }
}
