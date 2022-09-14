package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.css.selectors.CSSSelector

sealed class UIKitDrop(
    override val classes: Array<String> = emptyArray(),
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {
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

    sealed class Stretch(name: String) : AttributeValue(name) {
        object True : Stretch("true")
        object X : Stretch("x")
        object Y : Stretch("y")
    }

    sealed class Mode(name: String) : AttributeValue(name) {

        object Click : Mode("click")
        object Hover : Mode("hover")

        object None : Mode("")
        object HoverAndClick : Mode("$Hover, $Click")

    }

    class Custom internal constructor(
        classes: Array<String> = emptyArray(),
        otherAttrs: Map<String, String> = emptyMap()
    ) : UIKitDrop(classes, otherAttrs)

    companion object {
        operator fun invoke(
            toggle: CSSSelector? = null,
            position: Position? = null,
            stretch: Stretch? = null,
            mode: Mode? = null,
            delayShow: Milliseconds? = null,
            delayHide: Milliseconds? = null,
            autoUpdate: Boolean? = null,
            boundary: CSSSelector? = null,
            boundaryX: CSSSelector? = null,
            boundaryY: CSSSelector? = null,
            target: CSSSelector? = null,
            targetX: CSSSelector? = null,
            targetY: CSSSelector? = null,
            inset: Boolean? = null,
            flip: Boolean? = null,
            shift: Boolean? = null,
            offset: Pixels? = null,
            animation: UIKitAnimation? = null,
            animationOut: Boolean? = null,
            bgScroll: Boolean? = null,
            duration: Milliseconds? = null,
            container: Boolean? = null
        ) = Custom(
            arrayOf("uk-drop"),
            mapOf(
                buildAttribute("uk-drop") {
                    "toggle" to toggle
                    "position" to position
                    "stretch" to stretch
                    "mode" to mode
                    "delay-show" to delayShow
                    "delay-hide" to delayHide
                    "auto-update" to autoUpdate
                    "boundary" to boundary
                    "boundary-x" to boundaryX
                    "boundary-y" to boundaryY
                    "target" to target
                    "target-x" to targetX
                    "target-y" to targetY
                    "inset" to inset
                    "flip" to flip
                    "shift" to shift
                    "offset" to offset
                    "animation" to animation
                    "animation-out" to animationOut
                    "bg-scroll" to bgScroll
                    "duration" to duration
                    "container" to container
                }
            )
        )
    }
}
