package dev.inmo.jsuikit.modifiers

sealed class UIKitScreenSizeModifier(val name: String) {
    class UIKitScreenSizeModifierModified (
        val modifier: UIKitScreenSizeModifier,
        val base: UIKitModifier
    ) : UIKitModifier {
        override val classes: Array<String> = base.classes.map { "$it@${modifier.name}" }.toTypedArray()
    }

    object Small : UIKitScreenSizeModifier("s")
    object Medium : UIKitScreenSizeModifier("m")
    object Large : UIKitScreenSizeModifier("l")
    object XLarge : UIKitScreenSizeModifier("xl")

    fun modify(modifier: UIKitModifier): UIKitModifier = UIKitScreenSizeModifierModified(
        this,
        modifier
    )
}

fun UIKitModifier.applyWhenScreenSizeIs(size: UIKitScreenSizeModifier) = size.modify(this)
