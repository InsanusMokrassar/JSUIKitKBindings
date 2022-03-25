package dev.inmo.jsuikit.modifiers

sealed class UIKitClose(
    override val classes: Array<String> = emptyArray(),
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {

    object Large : UIKitClose(
        arrayOf("uk-close-large")
    )

    companion object : UIKitClose(
        arrayOf("uk-close"),
        mapOf("uk-close" to "")
    )

}
