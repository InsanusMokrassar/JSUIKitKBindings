package dev.inmo.jsuikit.types

import org.w3c.dom.Element
import kotlin.js.Json

external interface UIKit {
    val notification: UIKitNotifications
    val modal: UIKitDialogs
    val util: UIKitUtil


    fun notification(message: String, parameters: Json)
    fun notification(element: Element): UIKitNotification?

    fun modal(element: Element): UIKitDialog
    fun modal(selector: String): UIKitDialog?

    fun dropdown(element: Element, options: DropdownOptions = definedExternally): Dropdown
    fun dropdown(selector: String, options: DropdownOptions = definedExternally): Dropdown?

    fun tooltip(element: Element): UIKitTooltip
    fun tooltip(selector: String): UIKitTooltip?
}
