package dev.inmo.jsuikit.modifiers

sealed class UIKitComment(suffix: String?) : UIKitModifier {
    override val classes: Array<String> = arrayOf("uk-comment${suffix ?.let { "-$it" } ?: ""}")

    object Body : UIKitComment("body")
    object Header : UIKitComment("header")
    object Title : UIKitComment("title")
    object Meta : UIKitComment("meta")
    object Avatar : UIKitComment("avatar")

    object Primary : UIKitComment("primary")

    object List : UIKitComment("list")

    companion object : UIKitComment(null)
}
