package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Hr
import org.w3c.dom.HTMLHRElement

object Divider {
    @Composable
    fun Common(
        vararg modifiers: UIKitModifier,
        attributesCustomizer: AttrBuilderContext<HTMLHRElement> = {}
    ) = Hr {
        include(*modifiers)
        attributesCustomizer()
    }
    @Composable
    fun Icon(
        vararg modifiers: UIKitModifier,
        attributesCustomizer: AttrBuilderContext<HTMLHRElement> = {}
    ) = Common(
        *(modifiers + UIKitDivider.Icon), attributesCustomizer = attributesCustomizer
    )
    @Composable
    fun Small(
        vararg modifiers: UIKitModifier,
        attributesCustomizer: AttrBuilderContext<HTMLHRElement> = {}
    ) = Common(
        *(modifiers + UIKitDivider.Small), attributesCustomizer = attributesCustomizer
    )
    @Composable
    fun Vertical(
        vararg modifiers: UIKitModifier,
        attributesCustomizer: AttrBuilderContext<HTMLHRElement> = {}
    ) = Common(
        *(modifiers + UIKitDivider.Vertical), attributesCustomizer = attributesCustomizer
    )
}

