package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.types.DropdownOptions
import dev.inmo.jsuikit.utils.Milliseconds
import dev.inmo.jsuikit.utils.buildAttribute

sealed class UIKitDropdown(classname: String) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Nav : UIKitDropdown("uk-dropdown-nav")

    object Grid : UIKitDropdown("uk-dropdown-grid")

    sealed class Position(name: String) : AttributeValue(name) {

        sealed class Bottom(name: String) : Position("bottom-$name") {

            object Left : Bottom("left")
            object Center : Bottom("center")
            object Right : Bottom("right")
            object Justify : Bottom("justify")

        }

        sealed class Top(name: String) : Position("top-$name") {

            object Left : Top("left")
            object Center : Top("center")
            object Right : Top("right")
            object Justify : Top("justify")

        }

        sealed class Left(name: String) : Position("left-$name") {

            object Top : Left("top")
            object Center : Left("center")
            object Bottom : Left("bottom")

        }

        sealed class Right(name: String) : Position("right-$name") {

            object Top : Right("top")
            object Center : Right("center")
            object Bottom : Right("bottom")

        }

    }

    sealed class Mode(name: String) : AttributeValue(name) {

        object Click : Mode("click")
        object Hover : Mode("hover")

        object None : Mode("")
        object HoverAndClick : Mode("$Hover, $Click")

    }

    sealed class Flip(name: String) : AttributeValue(name) {

        object True : Flip("true")
        object False : Flip("false")
        object X : Flip("x")
        object Y : Flip("y")

    }

    class Custom(
        dropdownOptions: DropdownOptions
    ) : UIKitDropdown("uk-dropdown") {
        override val otherAttrs: Map<String, String> = mapOf(
            buildAttribute(
                "uk-dropdown"
            ) {
                dropdownOptions.includeParameters(this)
            }
        )
    }

    companion object {
        operator fun invoke(
            dropdownOptions: DropdownOptions
        ) = Custom(dropdownOptions)
        operator fun invoke(
            toggle: String? = null,
            pos: Position? = null,
            mode: Mode? = null,
            delayShow: Milliseconds? = null,
            delayHide: Milliseconds? = null,
            boundary: String? = null,
            boundaryAlign: Boolean? = null,
            flip: Flip? = null,
            offset: Int? = null,
            animation: UIKitAnimation? = null,
            duration: Milliseconds? = null,
        ) = Custom(
            DropdownOptions(
                toggle = toggle,
                pos = pos,
                mode = mode,
                delayShow = delayShow,
                delayHide = delayHide,
                boundary = boundary,
                boundaryAlign = boundaryAlign,
                flip = flip,
                offset = offset,
                animation = animation,
                duration = duration
            )
        )
    }
}
