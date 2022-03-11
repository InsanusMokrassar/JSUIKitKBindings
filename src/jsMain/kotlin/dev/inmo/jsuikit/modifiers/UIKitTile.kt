package dev.inmo.jsuikit.modifiers

sealed class UIKitTile(
    override val classes: Array<String> = emptyArray(),
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {

    object Default : UIKitTile(arrayOf("uk-tile-default"))
    object Muted : UIKitTile(arrayOf("uk-tile-muted"))
    object Primary : UIKitTile(arrayOf("uk-tile-primary"))
    object Secondary : UIKitTile(arrayOf("uk-tile-secondary"))

    companion object : UIKitTile(arrayOf("uk-tile"))

}
