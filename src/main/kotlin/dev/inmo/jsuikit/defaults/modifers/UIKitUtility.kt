package dev.inmo.jsuikit.defaults.modifers

sealed class UIKitUtility(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    sealed class Overflow(suffix: String) : UIKitUtility("uk-overflow-$suffix") {
        object Hidden : Overflow("hidden")
        object Auto : Overflow("auto")
    }

    object Logo : UIKitUtility("uk-logo")
}
