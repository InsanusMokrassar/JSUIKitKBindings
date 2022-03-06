package dev.inmo.jsuikit.elements

import dev.inmo.jsuikit.modifiers.UIKit
import dev.inmo.jsuikit.types.*
import dev.inmo.jsuikit.utils.Milliseconds

fun Notification(
    message: String,
    status: UIKitNotificationParameter.Style? = null,
    timeout: Milliseconds? = null,
    group: NotificationsGroup? = null,
    position: UIKitNotificationParameter.Position? = null
) = UIKit.notification.invoke(message, status, timeout, group, position)
