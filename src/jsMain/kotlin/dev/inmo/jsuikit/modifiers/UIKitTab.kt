package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.buildAttribute
import org.jetbrains.compose.web.css.selectors.CSSSelector
import kotlin.time.Duration

sealed class UIKitTab(
    override val classes: Array<String> = emptyArray(),
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {
    sealed class Position(
        classes: Array<String> = emptyArray(),
        otherAttrs: Map<String, String> = emptyMap()
    ) : UIKitTab(classes, otherAttrs) {
        object Bottom : Position(arrayOf("uk-tab-bottom"))
        object Left : Position(arrayOf("uk-tab-left"))
        object Right : Position(arrayOf("uk-tab-right"))
    }

    class Custom(
        connect: CSSSelector? = null,
        toggle: CSSSelector? = null,
        active: Int? = null,
        animationsIn: Array<UIKitAnimation>? = null,
        animationsOut: Array<UIKitAnimation>? = null,
        animationDuration: Duration? = null,
        swiping: Boolean? = null,
        media: String? = null
    ) : UIKitTab(
        arrayOf("uk-tab"),
        mapOf(
            buildAttribute("uk-tab") {
                "connect" to connect
                "toggle" to toggle
                "active" to active
                "animation" to (
                    (animationsIn ?.let {
                        it.joinToString(" ") { it.name }
                    } ?: "") + (animationsOut ?.let {
                        it.joinToString(" ", ",") { it.name }
                    } ?: "")
                ).takeIf { it.isNotBlank() }
                "duration" to animationDuration
                "swiping" to swiping
                "media" to media
            }
        )
    )

    companion object : UIKitTab(arrayOf("uk-tab"), mapOf("uk-tab" to ""))
}
