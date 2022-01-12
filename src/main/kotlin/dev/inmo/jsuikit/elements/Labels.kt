package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

sealed interface Label {
    val suffix: String

    @Composable
    operator fun invoke(
        text: String,
        vararg modifiers: UIKitModifier
    ) = Span(
        {
            classes("uk-label", "uk-label-$suffix")
            include(*modifiers)
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
