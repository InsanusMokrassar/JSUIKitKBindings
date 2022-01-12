package dev.inmo.jsuikit.defaults.modifers

sealed class UIKitIconType(suffix: String?) : UIKitModifier {
    override val classes: Array<String> = suffix ?.let {
        arrayOf("uk-icon-$suffix")
    } ?: emptyArray()

    object Default : UIKitIconType(null)
    object Link : UIKitIconType("link")
    object Button : UIKitIconType("button")
}
