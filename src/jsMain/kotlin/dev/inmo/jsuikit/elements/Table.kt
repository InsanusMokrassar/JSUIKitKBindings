package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.modifiers.UIKitModifier
import dev.inmo.jsuikit.modifiers.include
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

@Composable
fun <T> DefaultTable(
    headerBuilders: List<ContentBuilder<HTMLTableCellElement>>,
    dataList: Iterable<T>,
    vararg tableModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLTableElement> = {},
    headerCustomizer: AttrBuilderContext<HTMLTableSectionElement> = {},
    headerCellCustomizer: AttrsScope<HTMLTableCellElement>.(i: Int) -> Unit = {},
    rowAttributes: AttrsScope<HTMLTableRowElement>.(t: T) -> Unit = {},
    cellCustomizer: AttrsScope<HTMLTableCellElement>.(i: Int, t: T) -> Unit = { _, _ -> },
    betweenHeaderAndBodyFiller: ContentBuilder<HTMLTableElement> = {},
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
        Thead(headerCustomizer) {
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
        betweenHeaderAndBodyFiller()
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
    dataList: Iterable<T>,
    vararg tableModifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLTableElement> = {},
    headerCustomizer: AttrBuilderContext<HTMLTableSectionElement> = {},
    headerCellCustomizer: AttrsScope<HTMLTableCellElement>.(i: Int, title: String) -> Unit = { _, _ -> },
    rowAttributes: AttrsScope<HTMLTableRowElement>.(t: T) -> Unit = {},
    cellCustomizer: AttrsScope<HTMLTableCellElement>.(i: Int, t: T) -> Unit = { _, _ -> },
    betweenHeaderAndBodyFiller: ContentBuilder<HTMLTableElement> = {},
    cellFiller: @Composable ElementScope<HTMLTableCellElement>.(i: Int, t: T) -> Unit
) {
    val headersByIndex = heading.mapIndexed { index, s -> index to s }.toMap()
    val headerCellCustomizer: AttrsScope<HTMLTableCellElement>.(i: Int) -> Unit = { i ->
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
        headerCustomizer,
        headerCellCustomizer,
        rowAttributes,
        cellCustomizer,
        betweenHeaderAndBodyFiller,
        cellFiller
    )
}
