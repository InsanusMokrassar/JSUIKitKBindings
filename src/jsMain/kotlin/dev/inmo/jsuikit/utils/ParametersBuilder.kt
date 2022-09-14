package dev.inmo.jsuikit.utils

import dev.inmo.jsuikit.modifiers.AttributeValue


class ParametersBuilder(
    val skipNullValues: Boolean = true,
    private val parameters: MutableMap<String, String?> = mutableMapOf()
) {
    fun add(k: String, v: Any? = null) {
        when {
            v is AttributeValue -> parameters[k] = v.name
            v == null && skipNullValues -> return
            else -> parameters[k] = v ?.toString()
        }
    }
    infix fun String.to(value: Any?) = add(this, value)
    operator fun String.unaryPlus() = add(this, null)

    operator fun Map<String, String?>.unaryPlus() = forEach {

    }

    fun build() = parameters.toMap()
    fun buildNotNullable() = parameters.mapNotNull { (k, v) ->
        if (v != null) {
            Pair(k, v)
        } else {
            null
        }
    }.toMap()
}

fun buildParameters(
    skipNullValues: Boolean = true,
    block: ParametersBuilder.() -> Unit
) = ParametersBuilder(skipNullValues).apply(block).build()

fun buildParametersWithoutNulls(
    skipNullValues: Boolean = true,
    block: ParametersBuilder.() -> Unit
) = ParametersBuilder(skipNullValues).apply(block).buildNotNullable()
