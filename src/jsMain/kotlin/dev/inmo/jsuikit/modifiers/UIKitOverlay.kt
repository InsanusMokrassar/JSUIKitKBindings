package dev.inmo.jsuikit.modifiers

sealed class UIKitOverlay(
    override val classes: Array<String> = emptyArray(),
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {

    object Default : UIKitOverlay(arrayOf("uk-overlay-default"))
    object Primary : UIKitOverlay(arrayOf("uk-overlay-primary"))
    object Icon : UIKitOverlay(arrayOf("uk-overlay-icon"))

    companion object : UIKitOverlay(
        arrayOf("uk-overlay")
    )

}
