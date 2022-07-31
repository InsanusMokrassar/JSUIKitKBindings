package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitArticle
import dev.inmo.jsuikit.modifiers.include
import dev.inmo.jsuikit.utils.Attrs
import dev.inmo.jsuikit.utils.optionallyDraw
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

@Composable
fun UIKitArticleElement (
    headerBuilder: ContentBuilder<HTMLHeadingElement>,
    headerAttrs: Attrs<HTMLHeadingElement> = Attrs.empty(),
    metaBuilder: ContentBuilder<HTMLParagraphElement>? = null,
    metaAttrs: Attrs<HTMLParagraphElement>? = null,
    otherContentBuilder: ContentBuilder<HTMLElement>
) = Article(
    {
        include(UIKitArticle)
    }
) {
    H1(
        {
            include(UIKitArticle.Title)
            headerAttrs.builder(this)
        },
        headerBuilder
    )
    optionallyDraw(metaAttrs, metaBuilder) {
        P(
            {
                include(UIKitArticle.Meta)
                metaAttrs ?.builder ?.invoke(this)
            },
            metaBuilder ?: {}
        )
    }

    otherContentBuilder()
}

@Composable
fun UIKitArticleElement (
    header: String,
    meta: String? = null,
    otherContentBuilder: ContentBuilder<HTMLElement>
) = UIKitArticleElement(
    { Text(header) },
    metaBuilder = meta ?.let {
        {
            Text(meta)
        }
    },
    otherContentBuilder = otherContentBuilder
)
