package dev.inmo.jsuikit.utils

class AttributeBuilder (
    val attributeName: String,
    private val parametersPreset: MutableMap<String, String?> = mutableMapOf()
) {

    fun add(k: String, v: Any? = null) = parametersPreset.set(k, v ?.toString())
    infix fun String.to(value: Any?) = add(this, value)
    operator fun String.unaryPlus() = add(this, null)

    fun build(): Pair<String, String> = Pair(
        attributeName, parametersPreset.toList().joinToString(";") {
            "${it.first}${it.second ?.let { ": $it" } ?: ""}"
        }
    )
}

inline fun buildAttribute(attributeName: String, block: AttributeBuilder.() -> Unit) = AttributeBuilder(
    attributeName
).apply(block).build()
