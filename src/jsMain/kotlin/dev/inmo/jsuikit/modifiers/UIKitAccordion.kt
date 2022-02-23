package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.*
import org.w3c.dom.PageTransitionEvent

sealed class UIKitAccordion(
    vararg classnames: String,
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {
    @Suppress("UNCHECKED_CAST")
    override val classes: Array<String> = classnames as Array<String>

    object Title : UIKitAccordion("uk-accordion-title")
    object Content : UIKitAccordion("uk-accordion-content")

    class Custom internal constructor(
        otherAttrs: Map<String, String> = emptyMap()
    ) : UIKitAccordion (otherAttrs = otherAttrs)

    companion object : UIKitAccordion("uk-accordion", otherAttrs = mapOf("uk-accordion" to "")) {
        val Open = UIKitUtility.Open

        operator fun invoke(
            activeItemIndex: Int? = null,
            animation: Boolean? = null,
            collapsible: Boolean? = null,
            contentSelector: String? = null,
            animationDuration: Milliseconds? = null,
            multiple: Boolean? = null,
            targetsSelector: String? = null,
            toggleSelector: String? = null,
            transition: PageTransitionEvent? = null,
            offsetTopPixels: Int? = null,
        ) = Custom(
            mapOf(
                buildAttribute("uk-accordion") {
                    "active" to activeItemIndex
                    "animation" to animation
                    "collapsible" to collapsible
                    "content" to contentSelector
                    "duration" to animationDuration
                    "multiple" to multiple
                    "targets" to targetsSelector
                    "toggle" to toggleSelector
                    "transition" to transition
                    "offset" to offsetTopPixels
                }
            )
        )
    }
}
