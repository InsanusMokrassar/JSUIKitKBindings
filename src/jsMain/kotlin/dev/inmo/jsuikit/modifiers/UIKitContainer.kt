package dev.inmo.jsuikit.modifiers

sealed class UIKitContainer(
    override val classes: Array<String> = emptyArray(),
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {

    sealed class Size(size: String) : UIKitContainer(arrayOf("uk-container-$size")) {
        object XSmall : Size("xsmall")
        object Small : Size("small")
        object Large : Size("large")
        object XLarge : Size("xlarge")
        object Expand : Size("expand")
    }

    companion object : UIKitContainer(
        arrayOf("uk-container")
    )
}
