package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.buildAttribute

class UIKitTooltipModifier(
    text: String,
    align: Align? = null,
    delay: Int? = null,
    offset: Int? = null,
    duration: Int? = null,
    animation: UIKitAnimation? = null
) : UIKitModifier {
    override val otherAttrs: Map<String, String> = mapOf(
        buildAttribute("uk-tooltip") {
            "title" to text
            align ?.let { it.k to it.v }
            delay ?.let { "delay" to it.toString() }
            offset ?.let { "offset" to it.toString() }
            duration ?.let { "duration" to it.toString() }
            animation ?.let { "animation" to it.name }
        }
    )

    sealed class Align(name: String) {
        val k = "pos"
        val v = name

        sealed class Top(suffix: String) : Align("top$suffix") {

            object Center : Top("")
            object Left : Top("-left")
            object Right : Top("-right")

        }

        sealed class Bottom(suffix: String) : Align("bottom$suffix") {

            object Center : Bottom("")
            object Left : Bottom("-left")
            object Right : Bottom("-right")

        }

        object Left : Align("left")
        object Right : Align("right")
    }
}
