package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.buildAttribute

sealed class UIKitLeader(
    override val classes: Array<String>,
    override val otherAttrs: Map<String, String>
) : UIKitModifier {

    class Custom(
        otherAttrs: Map<String, String>
    ) : UIKitLeader(arrayOf("uk-leader"), otherAttrs)

    companion object : UIKitLeader(arrayOf("uk-leader"), emptyMap()) {
        operator fun invoke(
            media: String? = null,
            fill: String? = null
        ) = Custom(
            mapOf(
                buildAttribute("uk-leader") {
                    "fill" to fill
                    "media" to media
                }
            )
        )
    }

}
