package dev.inmo.jsuikit.modifiers

sealed class UIKitDescriptionList(
    override val classes: Array<String>
) : UIKitModifier {

    object Divider : UIKitDescriptionList(arrayOf("uk-description-list-divider"))

    companion object : UIKitDescriptionList(arrayOf("uk-description-list"))

}
