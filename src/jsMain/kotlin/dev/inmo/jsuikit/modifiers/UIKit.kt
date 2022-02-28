package dev.inmo.jsuikit.modifiers

import dev.inmo.jsuikit.types.UIKit

inline val UIKit: UIKit
    get() = js("UIkit").unsafeCast<UIKit>()
