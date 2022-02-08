package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.css.CSSKeyframe

sealed class UIKitHeight(
    classname: String?,
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {
    override val classes: Array<String> = classname ?.let { arrayOf(it) } ?: emptyArray()

    object Full : UIKitHeight("uk-height-1-1")

    sealed class Size(classname: String) : UIKitHeight(classname) {

        sealed class Small(classname: String = "uk-height-small") : Size(classname) {
            object Max : Small("uk-height-max-small")

            companion object : Small()
        }

        sealed class Medium(classname: String = "uk-height-medium") : Size(classname) {
            object Max : Medium("uk-height-max-medium")

            companion object : Medium()
        }

        sealed class Large(classname: String = "uk-height-large") : Size(classname) {
            object Max : Large("uk-height-max-large")

            companion object : Large()
        }

    }

    class Viewport(offsetTop: Boolean? = null, offsetBottom: String? = null, expand: Boolean? = null, minHeight: Int? = null) : UIKitHeight(
        null,
        mapOf(
            buildAttribute("uk-height-viewport") {
                offsetTop ?.let { "offset-top" to it.toString() }
                offsetBottom ?.let { "offset-bottom" to it }
                expand ?.let { "expand" to it.toString() }
                minHeight ?.let { "min-height" to it.toString() }
            }
        )
    )

    fun Viewport(
        offsetTop: Boolean? = null,
        offsetBottom: Boolean,
        expand: Boolean? = null,
        minHeight: Int? = null
    ) = Viewport(offsetTop, offsetBottom.toString(), expand, minHeight)

    fun Viewport(
        offsetTop: Boolean? = null,
        offsetBottom: Pixels,
        expand: Boolean? = null,
        minHeight: Int? = null
    ) = Viewport(offsetTop, offsetBottom.toString(), expand, minHeight)

    fun Viewport(
        offsetTop: Boolean? = null,
        offsetBottom: Percents,
        expand: Boolean? = null,
        minHeight: Int? = null
    ) = Viewport(offsetTop, offsetBottom.toString(), expand, minHeight)


    class Match(target: String? = null, row: Boolean? = null) : UIKitHeight(
        null,
        mapOf(
            buildAttribute("uk-height-match") {
                target ?.let { "target" to it }
                row ?.let { "row" to it.toString() }
            }
        )
    )

}
