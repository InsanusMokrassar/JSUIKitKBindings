package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import dev.inmo.jsuikit.modifiers.*
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

@Composable
fun <T> DefaultTable(
    heading: List<String>,
    dataList: SnapshotStateList<T>,
    vararg tableModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLTableElement> = {},
    headingCustomizer: AttrBuilderContext<HTMLTableCellElement> = {},
    rowAttributes: AttrsBuilder<HTMLTableRowElement>.(t: T) -> Unit = {},
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
                            headingCustomizer()
                        }
                    ) {
                        Text(it)
                    }
                }
            }
        }
        Tbody {
            dataList.forEach {
                Tr(
                    {
                        rowAttributes(it)
                    }
                ) {
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
