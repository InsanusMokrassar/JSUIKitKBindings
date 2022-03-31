package dev.inmo.jsuikit.modifiers

sealed class UIKitBreadcrumb(
    override val classes: Array<String> = emptyArray(),
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {
    companion object : UIKitBreadcrumb(arrayOf("uk-breadcrumb"))
}
