package dev.inmo.jsuikit.utils

fun <T> Array<T>.anyNotNull(): Boolean {
    for (item in this) {
        if (item != null) {
            return true
        }
    }

    return false
}
