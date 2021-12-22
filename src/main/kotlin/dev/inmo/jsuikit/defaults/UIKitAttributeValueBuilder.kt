package dev.inmo.jsuikit.defaults

import dev.inmo.jsuikit.defaults.modifers.AttributeValue
import org.jetbrains.compose.web.attributes.AttrsBuilder

class UIKitAttributeValueBuilder {
    private val attrs = mutableListOf<Pair<String, String>>()

    infix fun String.to(other: String?) {
        other ?.let {
            attrs.add(Pair(this, other))
        }
    }

    infix fun String.to(other: AttributeValue?) {
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
