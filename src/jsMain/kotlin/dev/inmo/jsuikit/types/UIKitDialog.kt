package dev.inmo.jsuikit.types

import org.w3c.dom.Element
import kotlin.js.Promise

external interface UIKitDialogs {
    operator fun invoke(element: Element): UIKitDialog
    operator fun invoke(selector: String): UIKitDialog
    fun alert(text: String): UIKitDialogPromiseAlert
    fun confirm(text: String): UIKitDialogPromiseConfirm
    fun prompt(title: String): UIKitDialogPromisePrompt
    fun prompt(title: String, preset: String): UIKitDialogPromisePrompt
    fun dialog(element: Element): UIKitDialog
}

external class UIKitDialogPromiseConfirm : Promise<Unit> {
    val dialog: UIKitDialog

    fun then(
        onConfirm: () -> Unit = definedExternally,
        onRejected: () -> Unit = definedExternally,
    )
}

external class UIKitDialogPromisePrompt : Promise<Unit> {
    val dialog: UIKitDialog

    fun then(onResult: (data: String?) -> Unit)
}

external class UIKitDialogPromiseAlert : Promise<Unit> {
    val dialog: UIKitDialog

    fun then(onClose: () -> Unit)
}

external interface UIKitDialog {
    fun show()
    fun hide()
}
