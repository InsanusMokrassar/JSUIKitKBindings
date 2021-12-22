package dev.inmo.jsuikit.defaults.modifers

sealed class UIKitExtension(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)
    object TextTransformUnset : UIKitExtension("text_transform_unset")
    object CursorPointer : UIKitExtension("cursor_pointer")
}
