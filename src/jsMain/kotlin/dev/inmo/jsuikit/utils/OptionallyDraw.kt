package dev.inmo.jsuikit.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.Element

@Composable
inline fun <T : Element> optionallyDraw (
    attrs: Attrs<T>? = null,
    noinline contentBuilder: ContentBuilder<T>? = null,
    whatToDraw: @Composable () -> Unit
) {
    if (attrs != null || contentBuilder != null) {
        whatToDraw()
    }
}
