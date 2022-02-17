package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.utils.buildAttribute

sealed class UIKitModal(
    classname: String,
    override val otherAttrs: Map<String, String> = emptyMap()
) : UIKitModifier {
    override val classes: Array<String> = arrayOf(classname)

    object Dialog : UIKitModal("uk-modal-dialog")
    object Title : UIKitModal("uk-modal-title")

    object Header : UIKitModal("uk-modal-header")
    object Body : UIKitModal("uk-modal-body")
    object Footer : UIKitModal("uk-modal-footer")

    object Container : UIKitModal("uk-modal-container")
    object Full : UIKitModal("uk-modal-full")

    object Page : UIKitModal("uk-modal-page")

    sealed class Close(classname: String) : UIKitModal(classname) {
        object Default : Close("uk-modal-close-default")
        object Outside : Close("uk-modal-close-outside")
        object Full : Close("uk-modal-close-full")

        companion object : Close("uk-modal-close")
    }

    internal class WithCustomAttributes(
        otherAttrs: Map<String, String> = emptyMap()
    ) : UIKitModal("uk-modal", otherAttrs)

    companion object : UIKitModal("uk-modal", mapOf("uk-modal" to "")) {
        operator fun invoke(
            escClose: Boolean? = null,
            backgroundClose: Boolean? = null,
            stack: Boolean? = null,
            container: Boolean? = null,
            classPage: String? = null,
            classPanel: String? = null,
            closingSelection: String? = null,
        ): UIKitModal = WithCustomAttributes(
            mapOf(
                buildAttribute("uk-modal") {
                    "esc-close" to escClose
                    "bg-close" to backgroundClose
                    "stack" to stack
                    "container" to container
                    "cls-page" to classPage
                    "cls-panel" to classPanel
                    "sel-close" to closingSelection
                }
            )
        )
    }
}
