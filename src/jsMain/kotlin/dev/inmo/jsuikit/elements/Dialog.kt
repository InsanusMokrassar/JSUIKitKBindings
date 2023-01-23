package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposableInBody
import org.w3c.dom.HTMLDivElement
import kotlin.random.Random
import kotlin.random.nextUInt

@Composable
fun Dialog(
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    onHidden: ((HTMLDivElement) -> Unit)? = null,
    onShown: ((HTMLDivElement) -> Unit)? = null,
    dialogAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    headerAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    headerBuilder: ContentBuilder<HTMLDivElement>? = null,
    afterHeaderBuilder: ContentBuilder<HTMLDivElement>? = null,
    beforeFooterBuilder: ContentBuilder<HTMLDivElement>? = null,
    footerAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    footerBuilder: ContentBuilder<HTMLDivElement>? = null,
    bodyAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    autoShow: Boolean = true,
    removeOnHide: Boolean = true,
    bodyBuilder: ContentBuilder<HTMLDivElement> = {}
) {
    val draw = remember { mutableStateOf(true) }

    remember {
        renderComposableInBody {
            if (draw.value) {
                Div(
                    {
                        if (modifiers.none { it is UIKitModal.WithCustomAttributes }) {
                            include(UIKitModal)
                        }
                        id("dialog${Random.nextUInt()}")
                        include(*modifiers)

                        attributesCustomizer()
                    }
                ) {
                    DisposableEffect(true) {
                        val htmlElement = scopeElement

                        if (autoShow) {
                            UIKit.modal(htmlElement).show()
                        }

                        if (onHidden != null || removeOnHide) {
                            htmlElement.addEventListener("hidden", {
                                if (it.target != htmlElement) return@addEventListener

                                onHidden ?.invoke(htmlElement)

                                if (removeOnHide) {
                                    htmlElement.remove()
                                }
                            })
                        }

                        onShown ?.let {
                            htmlElement.addEventListener("shown", {
                                if (it.target != htmlElement) return@addEventListener

                                onShown(htmlElement)
                            })
                        }


                        onDispose {
                            draw.value = false
                        }
                    }

                    Div(
                        {
                            include(UIKitModal.Dialog)
                            dialogAttrsBuilder ?.let { it() } ?: include(UIKitMargin.Auto.Vertical)
                        }
                    ) {
                        headerBuilder ?.let {
                            Div(
                                {
                                    include(UIKitModal.Header)
                                    headerAttrsBuilder ?.let { it() }
                                }
                            ) {
                                it()
                            }
                        }
                        afterHeaderBuilder ?.let { it() }
                        Div(
                            {
                                include(UIKitModal.Body)
                                bodyAttrsBuilder ?.let { it() }
                            }
                        ) {
                            bodyBuilder()
                        }
                        beforeFooterBuilder ?.let { it() }
                        footerBuilder ?.let {
                            Div(
                                {
                                    include(UIKitModal.Footer)
                                    footerAttrsBuilder ?.let { it() } ?: include(UIKitText.Alignment.Horizontal.Right)
                                }
                            ) {
                                it()
                            }
                        }
                    }
                }
            }
        }
    }

    Div({
        hidden()
        ref {
            onDispose {
                draw.value = false
            }
        }
    })
}

@Composable
fun Dialog(
    title: String,
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    onHidden: ((HTMLDivElement) -> Unit)? = null,
    onShown: ((HTMLDivElement) -> Unit)? = null,
    dialogAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    headerAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    headerBuilder: ContentBuilder<HTMLDivElement>? = null,
    afterHeaderBuilder: ContentBuilder<HTMLDivElement>? = null,
    beforeFooterBuilder: ContentBuilder<HTMLDivElement>? = null,
    footerAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    footerBuilder: ContentBuilder<HTMLDivElement>? = null,
    bodyAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    autoShow: Boolean = true,
    removeOnHide: Boolean = true,
    bodyBuilder: ContentBuilder<HTMLDivElement> = {}
) = Dialog(
    modifiers = modifiers,
    attributesCustomizer = attributesCustomizer,
    onHidden = onHidden,
    onShown = onShown,
    dialogAttrsBuilder = dialogAttrsBuilder,
    headerAttrsBuilder = headerAttrsBuilder,
    headerBuilder = {
        H2({ include(UIKitModal.Title) }) {
            Text(title)
        }
        headerBuilder ?.invoke(this)
    },
    afterHeaderBuilder = afterHeaderBuilder,
    beforeFooterBuilder = beforeFooterBuilder,
    footerAttrsBuilder = footerAttrsBuilder,
    footerBuilder = footerBuilder,
    bodyAttrsBuilder = bodyAttrsBuilder,
    autoShow = autoShow,
    removeOnHide = removeOnHide,
    bodyBuilder = bodyBuilder
)
