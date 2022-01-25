package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.Attrs
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@Composable
fun Card(
    cardAttrs: Attrs<HTMLDivElement> = Attrs.empty(),
    headerAttrs: Attrs<HTMLDivElement> = Attrs.empty(),
    header: ContentBuilder<HTMLDivElement>? = null,
    footerAttrs: Attrs<HTMLDivElement> = Attrs.empty(),
    footer: ContentBuilder<HTMLDivElement>? = null,
    bodyAttrs: Attrs<HTMLDivElement> = Attrs.empty(),
    body: ContentBuilder<HTMLDivElement>
) {
    Div(
        {
            include(UIKitCard)
            cardAttrs.builder(this)
        }
    ) {
        header ?.let {
            Div(
                {
                    include(UIKitCard.Parts.Header)
                    headerAttrs.builder(this)
                },
                header
            )
        }
        Div(
            {
                include(UIKitCard.Parts.Body)
                bodyAttrs.builder(this)
            },
            body
        )
        footer ?.let {
            Div(
                {
                    include(UIKitCard.Parts.Footer)
                    footerAttrs.builder(this)
                },
                footer
            )
        }
    }
}

@Composable
fun CardTitle(
    titleAttrs: Attrs<HTMLHeadingElement> = Attrs.empty(),
    title: ContentBuilder<HTMLHeadingElement>
) {
    H3(
        {
            include(UIKitCard.Title)
            titleAttrs.builder(this)
        },
        title
    )
}

@Composable
fun CardBadge(
    badgeAttrs: Attrs<HTMLDivElement> = Attrs.empty(),
    badge: ContentBuilder<HTMLDivElement>
) {
    Div(
        {
            include(UIKitCard.Badge, UIKitLabel)
            badgeAttrs.builder(this)
        },
        badge
    )
}
