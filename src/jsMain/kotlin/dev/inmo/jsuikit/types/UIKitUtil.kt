package dev.inmo.jsuikit.types

import org.w3c.dom.HTMLElement

external interface UIKitUtil {
    fun on(selector: String, event: String, callback: () -> Unit)
    fun on(element: HTMLElement, event: String, callback: () -> Unit)
}
