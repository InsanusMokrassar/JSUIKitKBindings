package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.types.Dropdown
import dev.inmo.jsuikit.utils.*

sealed class UIKitNavbar(vararg classes: String) : UIKitModifier {
    override val classes: Array<String> = classes as Array<String>

    object Transparent : UIKitNavbar("uk-navbar-transparent")
    object Container : UIKitNavbar("uk-navbar-container")
    sealed class Dropdown(suffix: String?) : UIKitNavbar("uk-navbar-dropdown${suffix ?.let { "-$it" } ?: ""}") {
        object Nav : Dropdown("nav")

        sealed class Width(suffix: String) : Dropdown(suffix) {
            object Two : Width("width-2")
            object Three : Width("width-3")
            object Four : Width("width-4")
            object Five : Width("width-5")
        }

        companion object : Dropdown(null)
    }
    sealed class Alignment(val suffix: String) : UIKitNavbar("uk-navbar-$suffix") {
        object Left : Alignment("left")
        sealed class Center(suffix: String) : Alignment(suffix) {
            object Left : Center("center-left")
            object Right : Center("center-right")

            companion object : Center("center")
        }
        object Right : Alignment("right")
    }
    object Item : UIKitNavbar("uk-navbar-item")
    object Nav : UIKitNavbar("uk-navbar-nav")
    object Subtitle : UIKitNavbar("uk-navbar-subtitle")
    object Toggle : UIKitNavbar("uk-navbar-toggle")
    object Sticky : UIKitNavbar("uk-navbar-sticky")

    class Component internal constructor(
        override val otherAttrs: Map<String, String>
    ) : UIKitNavbar(*UIKitNavbar.classes)

    companion object : UIKitNavbar("uk-navbar") {
        val Logo = UIKitUtility.Logo

        operator fun invoke(
            align: String?,
            mode: String? = null,
            delayShow: Milliseconds? = null,
            delayHide: Milliseconds? = null,
            boundary: String? = null,
            boundaryAlign: Boolean? = null,
            offset: Pixels? = null,
            dropbar: Boolean? = null,
            duration: Milliseconds? = null
        ): Component {
            return Component(
                mapOf(
                    buildAttribute(UIKitNavbar.classes.first()) {
                        "align" to align
                        "mode" to mode
                        "delay-show" to delayShow
                        "delay-hide" to delayHide
                        "boundary" to boundary
                        "boundary-align" to boundaryAlign
                        "offset" to offset
                        "dropbar" to dropbar
                        "duration" to duration
                    }
                )
            )
        }

        operator fun invoke(
            align: Alignment? = null,
            mode: UIKitDropdown.Mode? = null,
            delayShow: Milliseconds? = null,
            delayHide: Milliseconds? = null,
            boundary: String? = null,
            boundaryAlign: Boolean? = null,
            offset: Pixels? = null,
            dropbar: Boolean? = null,
            duration: Milliseconds? = null
        ): Component = invoke(align ?.suffix, mode ?.name, delayShow, delayHide, boundary, boundaryAlign, offset, dropbar, duration)
    }
}
