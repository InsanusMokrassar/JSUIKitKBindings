package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffectResult
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*
import org.w3c.dom.events.Event
import kotlin.random.Random
import kotlin.random.nextUInt

private class DialogDisposableEffectResult(
    private val element: HTMLElement,
    private val onDispose: (() -> Unit)?,
    private val onDisposed: (() -> Unit)?
) : DisposableEffectResult {
    override fun dispose() {
        onDispose?.invoke()
        UIKit.modal("#${element.id}") ?.hide()
        onDisposed?.invoke()
    }
}

@Composable
fun Dialog(
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    onHide: (() -> Unit)? = null,
    onHidden: (() -> Unit)? = null,
    dialogAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    headerAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    headerBuilder: ContentBuilder<HTMLDivElement>? = null,
    afterHeaderBuilder: ContentBuilder<HTMLDivElement>? = null,
    beforeFooterBuilder: ContentBuilder<HTMLDivElement>? = null,
    footerAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    footerBuilder: ContentBuilder<HTMLDivElement>? = null,
    bodyAttrsBuilder: AttrBuilderContext<HTMLDivElement>? = null,
    bodyBuilder: ContentBuilder<HTMLDivElement>
) {
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

        DisposableRefEffect {
            DialogDisposableEffectResult(it, onHide, onHidden)
        }

        DomSideEffect { htmlElement ->
            var wrapper: (Event) -> Unit = {}
            wrapper = { it: Event ->
                htmlElement.removeEventListener("hidden", wrapper)
                htmlElement.remove()
                onHidden ?.invoke()
            }
            htmlElement.addEventListener("hidden", wrapper)

            UIKit.modal("#${htmlElement.id}") ?.show()
        }
    }
}

@Composable
fun Dialog(
    title: String,
    vararg modifiers: UIKitModifier,
    hide: (() -> Unit)? = null,
    hidden: (() -> Unit)? = null,
    footerBuilder: (@Composable () -> Unit)? = null,
    attributesCustomizer: AttrBuilderContext<HTMLDivElement> = {},
    bodyBuilder: @Composable () -> Unit
) = Dialog(
    modifiers = modifiers,
    headerBuilder = {
        H2({ include(UIKitModal.Title) }) {
            Text(title)
        }
    },
    onHide = hide,
    onHidden = hidden,
    footerBuilder = footerBuilder ?.let { _ ->
        {
            footerBuilder()
        }
    },
    attributesCustomizer = {
        attributesCustomizer()
    },
    bodyBuilder = {
        bodyBuilder()
    }
)
