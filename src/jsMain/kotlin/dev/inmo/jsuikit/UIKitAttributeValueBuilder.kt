package dev.inmo.jsuikit

import dev.inmo.jsuikit.modifiers.AttributeValue
import dev.inmo.jsuikit.utils.AttributeBuilder
import dev.inmo.jsuikit.utils.buildAttribute
import org.jetbrains.compose.web.attributes.AttrsBuilder

@Deprecated("Will be removed soon")
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
    skipNullValues: Boolean = true,
    block: AttributeBuilder.() -> Unit
) {
    buildAttribute(attributeName, skipNullValues, block).let {
        attr(it.first, it.second)
    }
}
