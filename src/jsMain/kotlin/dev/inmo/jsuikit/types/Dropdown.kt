package dev.inmo.jsuikit.types

import dev.inmo.jsuikit.modifiers.UIKitAnimation
import dev.inmo.jsuikit.modifiers.UIKitDropdown
import dev.inmo.jsuikit.utils.*

external interface Dropdown {
    fun show()
    fun hide(delay: Boolean = definedExternally)
    fun hide(delay: Milliseconds)
}

data class DropdownOptions(
    private val toggle: String? = null,
    private val pos: UIKitDropdown.Position? = null,
    private val mode: UIKitDropdown.Mode? = null,
    private val delayShow: Milliseconds? = null,
    private val delayHide: Milliseconds? = null,
    private val boundary: String? = null,
    private val boundaryAlign: Boolean? = null,
    private val flip: UIKitDropdown.Flip? = null,
    private val offset: Int? = null,
    private val animation: UIKitAnimation? = null,
    private val duration: Milliseconds? = null,
) {
    fun includeParameters(parametersBuilder: ParametersBuilder) {
        with(parametersBuilder) {
            "toggle" to toggle
            "pos" to pos
            "mode" to mode
            "delayShow" to delayShow
            "delayHide" to delayHide
            "boundary" to boundary
            "boundaryAlign" to boundaryAlign
            "flip" to flip
            "offset" to offset
            "animation" to animation
            "duration" to duration
        }
    }
    fun parameters() = buildParametersWithoutNulls {
        includeParameters(this)
    }
}
