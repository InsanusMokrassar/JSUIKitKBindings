package dev.inmo.jsuikit.utils

class AttributeBuilder (
    val attributeName: String,
    val skipNullValues: Boolean = true,
    private val parametersPreset: MutableMap<String, String?> = mutableMapOf()
) {

    fun add(k: String, v: Any? = null) {
        if (v != null || !skipNullValues) {
            parametersPreset[k] = v ?.toString()
        }
    }
    infix fun String.to(value: Any?) = add(this, value)
    operator fun String.unaryPlus() = add(this, null)

    fun build(): Pair<String, String> = Pair(
        attributeName, parametersPreset.toList().joinToString(";") {
            "${it.first}${it.second ?.let { ": $it" } ?: ""}"
        }
    )
}

inline fun buildAttribute(attributeName: String, skipNullValues: Boolean = true, block: AttributeBuilder.() -> Unit) = AttributeBuilder(
    attributeName,
    skipNullValues
).apply(block).build()
