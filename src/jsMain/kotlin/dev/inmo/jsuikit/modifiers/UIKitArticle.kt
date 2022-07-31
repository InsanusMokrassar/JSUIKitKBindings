package dev.inmo.jsuikit.modifiers

sealed class UIKitArticle(
    override val classes: Array<String>
) : UIKitModifier {

    object Title : UIKitArticle(arrayOf("uk-article-title"))
    object Meta : UIKitArticle(arrayOf("uk-article-meta"))

    companion object : UIKitArticle(arrayOf("uk-article"))

}
