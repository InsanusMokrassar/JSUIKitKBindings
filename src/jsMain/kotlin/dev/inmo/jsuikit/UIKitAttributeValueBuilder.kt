package dev.inmo.jsuikit

import dev.inmo.jsuikit.modifiers.AttributeValue
import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.attributes.AttrsScope

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

fun AttrsScope<*>.buildAndAddAttribute(
    attributeName: String,
    skipNullValues: Boolean = true,
    block: ParametersBuilder.() -> Unit
) {
    buildAttribute(attributeName, skipNullValues, block).let {
        attr(it.first, it.second)
    }
}
