package dev.inmo.jsuikit.modifiers

sealed class AttributeValue(val name: String) {
    override fun toString(): String = name
}
