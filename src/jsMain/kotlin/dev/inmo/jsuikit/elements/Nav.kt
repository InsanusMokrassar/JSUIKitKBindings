package dev.inmo.jsuikit.elements

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.buildAndAddAttribute
import dev.inmo.jsuikit.modifiers.*
import dev.inmo.jsuikit.utils.Milliseconds
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

@Composable
fun Nav(
    vararg modifiers: UIKitModifier,
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    attributesCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    dataAllocator: ContentBuilder<HTMLUListElement>
) {
    Ul(
        {
            buildAndAddAttribute("uk-nav") {
                "multiple" to multiple ?.toString()
                "collapsible" to collapsible ?.toString()
                "animation" to animation
                "duration" to duration ?.toString()
            }
            include(*modifiers, UIKitNav)
            attributesCustomizer()
        }
    ) {
        dataAllocator()
    }
}

@Composable
fun DefaultNav(
    vararg modifiers: UIKitModifier,
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    attributesCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    dataAllocator: ContentBuilder<HTMLUListElement>
) = Nav(
    modifiers = modifiers + UIKitNav.Default,
    multiple,
    collapsible,
    animation,
    duration,
    attributesCustomizer,
    dataAllocator
)

@Composable
fun PrimaryNav(
    vararg modifiers: UIKitModifier,
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    attributesCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    dataAllocator: ContentBuilder<HTMLUListElement>
) = Nav(
    modifiers = modifiers + UIKitNav.Primary,
    multiple,
    collapsible,
    animation,
    duration,
    attributesCustomizer,
    dataAllocator
)

@Composable
fun SubNav(
    vararg modifiers: UIKitModifier,
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    attributesCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    dataAllocator: ContentBuilder<HTMLUListElement>
) = Nav(
    modifiers = modifiers + UIKitNav.SubNav,
    multiple,
    collapsible,
    animation,
    duration,
    attributesCustomizer,
    dataAllocator
)

@Composable
fun <T> Nav(
    title: String?,
    data: Iterable<T>,
    vararg ulModifiers: UIKitModifier,
    titleModifiers: Array<UIKitModifier> = emptyArray(),
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    besidesTitleAndList: ContentBuilder<HTMLUListElement>? = null,
    titleCustomizer: AttrBuilderContext<HTMLLIElement> = {},
    afterTitleContentBuilder: ContentBuilder<HTMLLIElement> = {},
    ulCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    elementAllocator: @Composable ElementScope<HTMLUListElement>.(T) -> Unit
) {
    Ul(
        {
            buildAndAddAttribute("uk-nav") {
                "multiple" to multiple ?.toString()
                "collapsible" to collapsible ?.toString()
                "animation" to animation
                "duration" to duration ?.toString()
            }
            include(*ulModifiers, UIKitNav)
            ulCustomizer()
        }
    ) {
        title ?.let {
            NavHeader(
                title,
                *titleModifiers,
                attributesCustomizer = titleCustomizer,
                afterTitleContentBuilder = afterTitleContentBuilder
            )
        }
        besidesTitleAndList ?.let { it() }
        data.forEach {
            elementAllocator(it)
        }
    }
}

@Composable
fun <T> DefaultNav(
    title: String?,
    data: Iterable<T>,
    vararg ulModifiers: UIKitModifier,
    titleModifiers: Array<UIKitModifier> = emptyArray(),
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    besidesTitleAndList: ContentBuilder<HTMLUListElement>? = null,
    titleCustomizer: AttrBuilderContext<HTMLLIElement> = {},
    afterTitleContentBuilder: ContentBuilder<HTMLLIElement> = {},
    ulCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    elementAllocator: @Composable ElementScope<HTMLUListElement>.(T) -> Unit
) = Nav(
    title,
    data,
    ulModifiers = ulModifiers + UIKitNav.Default,
    titleModifiers,
    multiple,
    collapsible,
    animation,
    duration,
    besidesTitleAndList,
    titleCustomizer,
    afterTitleContentBuilder,
    ulCustomizer,
    elementAllocator
)

@Composable
fun <T> PrimaryNav(
    title: String?,
    data: Iterable<T>,
    vararg ulModifiers: UIKitModifier,
    titleModifiers: Array<UIKitModifier> = emptyArray(),
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    besidesTitleAndList: ContentBuilder<HTMLUListElement>? = null,
    titleCustomizer: AttrBuilderContext<HTMLLIElement> = {},
    afterTitleContentBuilder: ContentBuilder<HTMLLIElement> = {},
    ulCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    elementAllocator: @Composable ElementScope<HTMLUListElement>.(T) -> Unit
) = Nav(
    title,
    data,
    ulModifiers = ulModifiers + UIKitNav.Primary,
    titleModifiers,
    multiple,
    collapsible,
    animation,
    duration,
    besidesTitleAndList,
    titleCustomizer,
    afterTitleContentBuilder,
    ulCustomizer,
    elementAllocator
)

@Composable
fun <T> SubNav(
    title: String?,
    data: Iterable<T>,
    vararg ulModifiers: UIKitModifier,
    titleModifiers: Array<UIKitModifier> = emptyArray(),
    multiple: Boolean? = null,
    collapsible: Boolean? = null,
    animation: UIKitAnimation? = null,
    duration: Milliseconds? = null,
    besidesTitleAndList: ContentBuilder<HTMLUListElement>? = null,
    titleCustomizer: AttrBuilderContext<HTMLLIElement> = {},
    afterTitleContentBuilder: ContentBuilder<HTMLLIElement> = {},
    ulCustomizer: AttrBuilderContext<HTMLUListElement> = {},
    elementAllocator: @Composable ElementScope<HTMLUListElement>.(T) -> Unit
) = Nav(
    title,
    data,
    ulModifiers = ulModifiers + UIKitNav.SubNav,
    titleModifiers,
    multiple,
    collapsible,
    animation,
    duration,
    besidesTitleAndList,
    titleCustomizer,
    afterTitleContentBuilder,
    ulCustomizer,
    elementAllocator
)

@Composable
fun NavHeader(
    text: String,
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLLIElement> = {},
    afterTitleContentBuilder: ContentBuilder<HTMLLIElement> = {}
) {
    Li(
        {
            include(*modifiers, UIKitNav.Header)
            attributesCustomizer()
        }
    ) {
        Text(text)
        afterTitleContentBuilder()
    }
}

@Composable
fun NavItemElement(
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLLIElement> = {},
    contentAllocator: ContentBuilder<HTMLAnchorElement>
) {
    Li(
        {
            include(*modifiers)
            attributesCustomizer()
        }
    ) {
        A("#") {
            contentAllocator()
        }
    }
}

@Composable
fun NavElement(
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLLIElement> = {},
    contentAllocator: ContentBuilder<HTMLLIElement>
) {
    Li(
        {
            include(*modifiers)
            attributesCustomizer()
        }
    ) {
        contentAllocator()
    }
}

@Composable
fun NavDivider(
    vararg modifiers: UIKitModifier,
    attributesCustomizer: AttrBuilderContext<HTMLLIElement> = {},
) {
    Li({ include(UIKitNav.Divider, *modifiers);attributesCustomizer() })
}
