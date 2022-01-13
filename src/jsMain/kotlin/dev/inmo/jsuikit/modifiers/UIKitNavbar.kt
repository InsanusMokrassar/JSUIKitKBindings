package dev.inmo.jsuikit.modifiers

sealed class UIKitNavbar(suffix: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-navbar-$suffix")

    object Transparent : UIKitNavbar("transparent")
    sealed class Dropdown(suffix: String?) : UIKitNavbar("dropdown${suffix ?.let { "-$it" } ?: ""}") {
        object Nav : Dropdown("nav")

        companion object : Dropdown(null)
    }
    object Item : UIKitNavbar("item")

    companion object {
        val Logo = UIKitUtility.Logo
    }
}
