package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLProgressElement
import org.w3c.dom.HTMLTableElement

@Composable
fun <T> DefaultTable(
    heading: List<String>,
    dataList: SnapshotStateList<T>,
    vararg tableModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLTableElement> = {},
    cellFiller: @Composable (i: Int, t: T) -> Unit
) {
    val headingIndexes = heading.indices
    Table(
        {
            classes("uk-table")
            include(*tableModifiers)
            attributesCustomizer()
        }
    ) {
        Thead {
            Tr {
                heading.forEach {
                    Th(
                        {
                            include(UIKitExtension.TextTransformUnset)
                        }
                    ) {
                        Text(it)
                    }
                }
            }
        }
        Tbody {
            dataList.forEach {
                Tr {
                    headingIndexes.forEach { i ->
                        Td {
                            cellFiller(i, it)
                        }
                    }
                }
            }
        }
    }
}
