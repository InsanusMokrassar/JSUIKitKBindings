package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffectResult
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLElement
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
        js("UIkit").modal("#${element.id}") ?.hide()
        onDisposed?.invoke()
    }
}

@Composable
fun Dialog(
    title: String? = null,
    vararg modifiers: UIKitModifier,
    hide: (() -> Unit)? = null,
    hidden: (() -> Unit)? = null,
    footerBuilder: (@Composable () -> Unit)? = null,
    bodyBuilder: @Composable () -> Unit
) {
    Div(
        {
            attr("uk-modal", "")
            classes("uk-flex-top", "uk-modal")
            id("dialog${Random.nextUInt()}")
            include(*modifiers)
        }
    ) {
        Div(
            {
                classes("uk-modal-dialog", "uk-margin-auto-vertical")
            }
        ) {
            title ?.let {
                Div(
                    {
                        classes("uk-modal-header")
                    }
                ) {
                    H2({ classes("uk-modal-title") }) {
                        Text(title)
                    }
                }
            }
            Div(
                {
                    classes("uk-modal-body")
                }
            ) {
                bodyBuilder()
            }
            footerBuilder ?.let {
                Div(
                    {
                        classes("uk-modal-footer", "uk-text-right")
                    }
                ) {
                    footerBuilder()
                }
            }
        }

        DisposableRefEffect {
            DialogDisposableEffectResult(it, hide, hidden)
        }

        DomSideEffect { htmlElement ->
            var wrapper: (Event) -> Unit = {}
            wrapper = { it: Event ->
                htmlElement.removeEventListener("hidden", wrapper)
                htmlElement.remove()
                hidden ?.invoke()
            }
            htmlElement.addEventListener("hidden", wrapper)

            val dialog = js("UIkit").modal("#${htmlElement.id}")
            dialog.show()
            Unit
        }
    }
}
