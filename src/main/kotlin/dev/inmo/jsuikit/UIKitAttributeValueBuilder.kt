package dev.inmo.jsuikit

import org.jetbrains.compose.web.attributes.AttrsBuilder

class UIKitAttributeValueBuilder {
    private val attrs = mutableListOf<Pair<String, String>>()

    infix fun String.to(other: String?) {
        other ?.let {
            attrs.add(Pair(this, other))
        }
    }

    infix fun String.to(other: dev.inmo.jsuikit.modifers.AttributeValue?) {
        this to other ?.name
    }

    fun build(): String = attrs.joinToString(";") { (k, v) -> "$k: $v" }
}

fun AttrsBuilder<*>.buildAndAddAttribute(
    attributeName: String,
    block: UIKitAttributeValueBuilder.() -> Unit
) {
    attr(attributeName, UIKitAttributeValueBuilder().apply(block).build())
}
