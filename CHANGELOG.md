# Changelog

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
