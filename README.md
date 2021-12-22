# JSUIKit Kotlin

Hello :) This library is a wrapper for JavaScript/CSS [UIKit](https://getuikit.com) framework. It uses the same
structure as in [UIKit Docs](https://getuikit.com/docs/introduction) and in most cases you may use it.

The main target of this wrapper is a [JetBrains Compose JS](https://github.com/JetBrains/compose-jb) and will be useful
for you in case you are using it too.

## How to include

Last version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/dev.inmo/jsuikitkotlin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/dev.inmo/jsuikitkotlin)

```groovy
implementation "dev.inmo:jsuikitkotlin:$jsuikitkotlin_version"
```

**THIS LIBRARY DO NOT ADD ANY JS OR CSS**. So, you must download and include UIKit js/css by yourself. See
[UIKit installation instructions](https://getuikit.com/docs/installation)

## How to use

In this library there are two main entities:

* Builder functions - buttons, spinners, icons, grids, etc.
* Modifiers - `UIKitAlign`, `UIKitAnimation`, etc.

For example, if you want to add table in your html, you will use next code:

```kotlin
DefaultTable(
    listOf("Heading 1", "Heading 2", "Heading 3"),
    data, // SnapshotStateList<T>
    UIKitTable.Divider // modifier, add dividers
) { i, item -> // i - number of heading, item - item from data; composable callback
    when (i) {
        0 -> Text(item.toString())
        1 -> Text("data 2")
        2 -> Text("data 3")
    }
}
```
