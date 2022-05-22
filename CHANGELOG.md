# Changelog

## 0.1.4

* Improvements in `UIKitGrid`

## 0.1.3

* Add support of sections
* Improve support of navbars

## 0.1.2

* New typealias `AttrsWithContentBuilder`
* Old `DList` and related composable functions removed (they are built-in in compose)

## 0.1.1

* `Compose`: `1.2.0-alpha01-dev686`

## 0.1.0

* `Kotlin` = `1.6.21`
* `Compose`: `1.2.0-alpha01-dev683`

## 0.0.53

* Improvements in `UIKitPadding`
* Add support of UIKit lists

## 0.0.52

* Improve work with UIKitModifiers

## 0.0.51

* New interface `Dropdown` which will be used to create (or retrieve) dropdown for an element
* New attribute in `NavItemElement` for configuration of `A` element

## 0.0.50

* Add opportunity to customize content in title of `Nav` after text

## 0.0.49

* Now it is possible to use optional title in navs builders

## 0.0.48

* Added support of `Breadcrumb`
* Add opportunity to summarize `UIKitModifier`
* Add opportunity to simply create attributes builder using `UIKitModifier` of array of them

## 0.0.47

* Add support of `Close` element

## 0.0.46

* Add support of `UIKitOverlay`
* Add support of `UIKitInverse`

## 0.0.45

* Add support of containers in `UIKitContainer` modifiers and `Container` function

## 0.0.44

* `Versions`:
    * `Compose`: `1.1.0` -> `1.1.1`

## 0.0.43

* Several new extensions for `UIKitModifier` like `UIKitModifier#onSmallScreen`
* Support of `Tile`

## 0.0.42

* Migration to compose 1.1.0
* Replaces according to it

## 0.0.41

* Add `DropArea`
* Add `UIKitPlaceholder`
* `UIKitForm#Custom` now have nullable param target
* Add `UIKitUtility#Link`
* Add `DescriptionList` and several support composable functions

## 0.0.40

* All `DefaultTable` functions now use `Iterable` as data type

## 0.0.39

* Add support of `Notifications`

## 0.0.38

* Add support of `Toggle`
* Attributes collection now can be concatenated

## 0.0.37

* `Dialog` now do not add auto margin by default
* Support of `Accordion` element

## 0.0.36

* Reorder arguments in `DefaultComment` fun
* Add `Vertical` and `Horizontal` members in margins
* Add `afterHeaderBuilder` and `beforeFooterBuilder` properties in `Dialog` fun
* Add `UIKitCustom` to be able for simple creating of custom modifiers
* Add support of `UIKitForm`

## 0.0.35

* Add `UIKitModal`
* Improve work with dialogs

## 0.0.34

* Add `Alert`
* Add `Animation#KenBurns`

## 0.0.33

* Fixes in attributes building and related things

## 0.0.32

* Support of `UIKitHeight`
* New builder `AttributesBuilder`
* New `Percents`/`Pixels` abstractions
* Fixes in `UIKitWidth#Fixed` classnames

## 0.0.31

* Support of `UIKitVisibility`

## 0.0.30

* Add `UIKitComment`
* Including of `Comment` element
* Upfill `UIKitSubNav`

## 0.0.29

* Unfilling of `UIKitText`

## 0.0.28

* Fixes in `UIKitWidth`

## 0.0.27

* `TextField` has been renamed to `StandardInput`
* `StandardInput` now will look for changes in state

## 0.0.26

* Add UIKitColumn

## 0.0.25

* Full including of divider

## 0.0.24

* Add opportunity to fill space between header and body of table

## 0.0.23

* New parameter of tables `headerCustomizer`

## 0.0.22

* Add opportunity to customize table header cells

## 0.0.21

* Upfill `UIKitWidth`
* New extension `UIKitModifier#applyWhenScreenSizeIs`

## 0.0.20

* Remove type of button from `DefaultButton` and add companion to `UIKitButton` to be able to use `uk-button` class

## 0.0.19

* Create `Card`s implementation
* Upgrade `Label` composable draw and create `UIKitLabel` modifiers

## 0.0.18

* Add base companion for `UIKitFlex` with result class `uk-flex`

## 0.0.17

* In `DefaultTable` `headingCustomizer` has been renamed to `headerCellCustomizer`
* Add index and title parameters for `headerCellCustomizer` in `DefaultTable`

## 0.0.16

* Add opportunity to customize `NavDivider`

## 0.0.15

* Add support of link icons

## 0.0.14

* Add DefaultTable parameter cellCustomizer

## 0.0.13

* Add `Icon#Custom`

## 0.0.12

* Add `rowAttributes` to table fun

## 0.0.11

* Upfill `Nav` and `UIKitNav`

## 0.0.10

* Filling of `UIKitUtility`

## 0.0.9

* Improving of `Nav` support

## 0.0.8

Removing of redundant non standard things

## 0.0.7

Rewrite project onto multiplatform paradigm and return back varargs instead of most `Array<UIKitModifier>`

## 0.0.6

Changes in signatures of text field and list

## 0.0.5

All elements has changed their signatures: they all will accept an additional lambda for attributes configuration

## 0.0.4

__Migrate modifers to modifiers__

## 0.0.3

__Global changes in packages__

## 0.0.2

* Name of project has been changed: `jsuikitkotlin` -> `kjsuikit`

## 0.0.1

It is first version. Here project has been created and added a lot of implementations of elements
