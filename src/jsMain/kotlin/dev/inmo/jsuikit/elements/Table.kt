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
    headerBuilders: List<ContentBuilder<HTMLTableCellElement>>,
    dataList: SnapshotStateList<T>,
    vararg tableModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLTableElement> = {},
    headerCellCustomizer: AttrsBuilder<HTMLTableCellElement>.(i: Int) -> Unit = { },
    rowAttributes: AttrsBuilder<HTMLTableRowElement>.(t: T) -> Unit = {},
    cellCustomizer: AttrsBuilder<HTMLTableCellElement>.(i: Int, t: T) -> Unit = { _, _ -> },
    cellFiller: @Composable ElementScope<HTMLTableCellElement>.(i: Int, t: T) -> Unit
) {
    val headingIndexes = headerBuilders.indices
    Table(
        {
            classes("uk-table")
            include(*tableModifiers)
            attributesCustomizer()
        }
    ) {
        Thead {
            Tr {
                headerBuilders.forEachIndexed { i, t ->
                    Th(
                        {
                            headerCellCustomizer(i)
                        }
                    ) {
                        t()
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
                        Td(
                            {
                                cellCustomizer(i, it)
                            }
                        ) {
                            cellFiller(i, it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun <T> DefaultTable(
    heading: List<String>,
    dataList: SnapshotStateList<T>,
    vararg tableModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLTableElement> = {},
    headerCellCustomizer: AttrsBuilder<HTMLTableCellElement>.(i: Int, title: String) -> Unit = { _, _ -> },
    rowAttributes: AttrsBuilder<HTMLTableRowElement>.(t: T) -> Unit = {},
    cellCustomizer: AttrsBuilder<HTMLTableCellElement>.(i: Int, t: T) -> Unit = { _, _ -> },
    cellFiller: @Composable ElementScope<HTMLTableCellElement>.(i: Int, t: T) -> Unit
) {
    val headersByIndex = heading.mapIndexed { index, s -> index to s }.toMap()
    val headerCellCustomizer: AttrsBuilder<HTMLTableCellElement>.(i: Int) -> Unit = { i ->
        val header = headersByIndex[i]
        if (header != null) {
            headerCellCustomizer(i, header)
        }
    }
    inline fun headerFactory(header: String): ContentBuilder<HTMLTableCellElement> = {
        Text(header)
    }
    val headerBuilders = heading.map(::headerFactory)
    return DefaultTable(
        headerBuilders,
        dataList,
        tableModifiers = tableModifiers,
        attributesCustomizer,
        headerCellCustomizer,
        rowAttributes,
        cellCustomizer,
        cellFiller
    )
}
