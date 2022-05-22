package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.buildAttribute
import org.jetbrains.compose.web.css.CSSUnitLengthOrPercentage
import org.jetbrains.compose.web.css.CSSUnitValueTyped

sealed class UIKitSticky(
    position: Position? = null,
    start: String? = null,
    end: String? = null,
    offset: CSSUnitValueTyped<CSSUnitLengthOrPercentage>? = null,
    overflowFlip: Boolean? = null,
    animation: UIKitAnimation? = null,
    classForActiveItems: String? = null,
    classForInactiveItems: String? = null,
    showOnUp: Boolean? = null,
    media: String? = null,
    targetOffset: CSSUnitValueTyped<CSSUnitLengthOrPercentage>? = null
) : UIKitModifier {
    override val otherAttrs: Map<String, String> = mapOf(
        buildAttribute("uk-sticky") {
            "position" to position ?.name
            "start" to start
            "end" to end
            "offset" to offset ?.toString()
            "overflow-flip" to overflowFlip
            "animation" to animation
            "cls-active" to classForActiveItems
            "cls-inactive" to classForInactiveItems
            "show-on-up" to showOnUp
            "media" to media
            "target-offset" to targetOffset ?.toString()
        }
    )

    sealed interface Position {
        val name: String
        object Top : Position {
            override val name: String
                get() = "top"
        }
        object Bottom : Position {
            override val name: String
                get() = "bottom"
        }
    }
}
