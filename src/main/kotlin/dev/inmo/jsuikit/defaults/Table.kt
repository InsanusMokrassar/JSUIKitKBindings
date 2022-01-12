package dev.inmo.jsuikit.defaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import dev.inmo.jsuikit.defaults.modifers.*
import org.jetbrains.compose.web.dom.*

@Composable
fun <T> DefaultTable(
    heading: List<String>,
    dataList: SnapshotStateList<T>,
    vararg tableModifiers: UIKitModifier,
    cellFiller: @Composable (i: Int, t: T) -> Unit
) {
    val headingIndexes = heading.indices
    Table(
        {
            classes("uk-table")
            include(*tableModifiers)
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
