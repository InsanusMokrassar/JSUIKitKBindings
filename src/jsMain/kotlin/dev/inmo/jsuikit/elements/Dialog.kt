package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposableInBody
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit
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
    val drawDiv = remember { mutableStateOf(true) }
    val composition = renderComposableInBody {
        Div(
            {
                if (modifiers.none { it is UIKitModal.WithCustomAttributes }) {
                    include(UIKitModal)
                }
                id("dialog${Random.nextUInt()}")
                include(*modifiers)

                ref { htmlElement ->
                    inline fun isShown() = htmlElement.classList.contains(UIKitUtility.Open.classes.first())

                    var latestStateIsShown = isShown()

                    val observer = MutationObserver { _, _ ->
                        val currentStateIsShown = isShown()

                        when (currentStateIsShown) {
                            latestStateIsShown -> return@MutationObserver
                            true -> onShown ?.invoke(htmlElement)
                            false -> onHidden ?.invoke(htmlElement)
                        }

                        latestStateIsShown = currentStateIsShown

                        if (removeOnHide && !currentStateIsShown) {
                            htmlElement.remove()
                        }
                    }

                    observer.observe(htmlElement, MutationObserverInit(attributes = true, attributeFilter = arrayOf("class")))

                    if (autoShow) {
                        UIKit.modal("#${htmlElement.id}") ?.show()
                    }

                    onDispose {
                        observer.disconnect()
                        drawDiv.value = false
                    }
                }

                attributesCustomizer()
            }
        ) {
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

    if (drawDiv.value) {
        Div({
            hidden()
            ref {
                onDispose {
                    composition.dispose()
                }
            }
        })
    } else {
        runCatching { composition.dispose() }
    }
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
    attributesCustomizer,
    onHidden,
    onShown,
    dialogAttrsBuilder,
    headerAttrsBuilder,
    headerBuilder = {
        H2({ include(UIKitModal.Title) }) {
            Text(title)
        }
        headerBuilder ?.invoke(this)
    },
    afterHeaderBuilder,
    beforeFooterBuilder,
    footerAttrsBuilder,
    footerBuilder,
    bodyAttrsBuilder,
    autoShow,
    removeOnHide,
    bodyBuilder
)
