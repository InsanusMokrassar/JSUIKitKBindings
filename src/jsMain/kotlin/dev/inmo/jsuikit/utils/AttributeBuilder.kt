package dev.inmo.jsuikit.utils

class AttributeBuilder (
    val attributeName: String,
    val parametersBuilder: ParametersBuilder
) {
    fun build(): Pair<String, String> = parametersBuilder.build().run {
        Pair(
            attributeName, toList().joinToString(";") {
                "${it.first}${it.second ?.let { ": $it" } ?: ""}"
            }
        )
    }
}

inline fun buildAttribute(
    attributeName: String,
    skipNullValues: Boolean = true,
    block: ParametersBuilder.() -> Unit
) = AttributeBuilder(
    attributeName,
    ParametersBuilder(skipNullValues)
).apply {
    parametersBuilder.block()
}.build()
