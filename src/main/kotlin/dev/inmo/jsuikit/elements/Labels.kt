package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLSpanElement

sealed interface Label {
    val suffix: String

    @Composable
    operator fun invoke(
        text: String,
        modifiers: Array<UIKitModifier> = emptyArray(),
        attributesCustomizer: AttrBuilderContext<HTMLSpanElement> = {},
    ) = Span(
        {
            classes("uk-label", "uk-label-$suffix")
            include(*modifiers)
            attributesCustomizer()
        }
    ) {
        Text(text)
    }

    object Success : Label {
        override val suffix: String
            get() = "success"
    }

    object Warning : Label {
        override val suffix: String
            get() = "warning"
    }

    object Error : Label {
        override val suffix: String
            get() = "danger"
    }
}
