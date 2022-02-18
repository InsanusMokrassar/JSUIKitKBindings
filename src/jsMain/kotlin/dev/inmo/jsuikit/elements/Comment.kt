package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

@Composable
fun Comment(
    rootAttrs: Attrs<HTMLElement> = Attrs.empty(),
    headerAttrs: Attrs<HTMLElement>? = null,
    headerContent: ContentBuilder<HTMLElement>? = null,
    bodyAttrs: Attrs<HTMLDivElement>? = null,
    bodyContent: ContentBuilder<HTMLDivElement>? = null,
) {
    Article(
        {
            include(UIKitComment)
            rootAttrs.builder(this)
        }
    ) {
        if (headerAttrs != null || headerContent != null) {
            Header (
                {
                    include(UIKitComment.Header)
                    headerAttrs ?.builder ?.invoke(this)
                }
            ) {
                headerContent ?.let { it(this) }
            }
        }
        if (bodyAttrs != null || bodyContent != null) {
            Div(
                {
                    include(UIKitComment.Body)
                    bodyAttrs ?.builder ?.invoke(this)
                }
            ) {
                bodyContent ?.let { it(this) }
            }
        }
    }
}

@Composable
fun DefaultComment(
    rootAttrs: Attrs<HTMLElement> = Attrs.empty(),
    headerGridAttrs: Attrs<HTMLDivElement>? = null,
    headerAttrs: Attrs<HTMLElement>? = null,
    additionalHeaderContent: ContentBuilder<HTMLElement>? = null,
    avatarUrl: String? = null,
    avatarAttrs: Attrs<HTMLImageElement>? = null,
    titleAttrs: Attrs<HTMLHeadingElement>? = null,
    titleContent: ContentBuilder<HTMLHeadingElement>? = null,
    metaAttrs: Attrs<HTMLUListElement>? = null,
    metaContent: ContentBuilder<HTMLUListElement>? = null,
    bodyAttrs: Attrs<HTMLDivElement>? = null,
    bodyContent: ContentBuilder<HTMLDivElement>? = null,
) {
    Comment(
        rootAttrs = rootAttrs,
        headerAttrs = headerAttrs,
        headerContent = {
            if (arrayOf(headerGridAttrs, avatarUrl, avatarAttrs, titleAttrs, titleContent, metaAttrs, metaContent).anyNotNull()) {
                Grid(
                    UIKitGrid.Gap.Medium, UIKitFlex.Alignment.Vertical.Middle,
                    attributesCustomizer = headerGridAttrs ?.builder ?: {}
                ) {
                    if (avatarUrl != null) {
                        Div({ include(UIKitWidth.Auto) }) {
                            Img(avatarUrl, attrs = avatarAttrs ?.builder)
                        }
                    }
                    if (arrayOf(titleAttrs, titleContent, metaAttrs, metaContent).anyNotNull()) {
                        Div({ include(UIKitWidth.Expand) }) {
                            optionallyDraw(titleAttrs, titleContent) {
                                H4(
                                    {
                                        include(UIKitComment.Title, UIKitMargin.Remove)
                                        titleAttrs ?.builder ?.invoke(this)
                                    }
                                ) {
                                    titleContent ?.invoke(this)
                                }
                            }
                            optionallyDraw(metaAttrs, metaContent) {
                                Ul (
                                    {
                                        include(UIKitComment.Meta, UIKitSubNav, UIKitSubNav.Divider, UIKitMargin.Remove.Top)
                                        metaAttrs ?.builder ?.invoke(this)
                                    }
                                ) {
                                    metaContent ?.invoke(this)
                                }
                            }
                        }
                    }
                }
            }
            additionalHeaderContent ?.let { it(this) }
        },
        bodyAttrs = bodyAttrs,
        bodyContent = bodyContent
    )
}
