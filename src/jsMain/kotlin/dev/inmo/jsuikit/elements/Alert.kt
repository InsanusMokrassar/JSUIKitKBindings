package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.buildAndAddAttribute
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.Attrs
import dev.inmo.jsuikit.utils.Milliseconds
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLDivElement

@Composable
fun Alert(
    attrs: Attrs<HTMLDivElement> = Attrs.empty(),
    animation: UIKitAnimation? = UIKitAnimation.Fade,
    duration: Milliseconds? = null,
    selClose: String? = null,
    content: ContentBuilder<HTMLDivElement>
) = Div(
    {
        attrs.builder(this)

        buildAndAddAttribute("uk-alert") {
            "animation" to animation ?.classes ?.firstOrNull()
            "duration" to duration
            "sel-close" to selClose
        }
    },
    content
)

@Composable
fun AlertCloseButton(
    attrs: Attrs<HTMLAnchorElement> = Attrs.empty(),
    content: ContentBuilder<HTMLAnchorElement> = @Composable {}
) {
    A(
        null,
        {
            include(UIKitAlert.Close)
            attr("uk-close", "")
            attrs.builder(this)
        },
        content
    )

}
