package dev.inmo.jsuikit

import dev.inmo.jsuikit.utils.*
import org.jetbrains.compose.web.attributes.AttrsScope

fun AttrsScope<*>.buildAndAddAttribute(
    attributeName: String,
    skipNullValues: Boolean = true,
    block: ParametersBuilder.() -> Unit
) {
    buildAttribute(attributeName, skipNullValues, block).let {
        attr(it.first, it.second)
    }
}
