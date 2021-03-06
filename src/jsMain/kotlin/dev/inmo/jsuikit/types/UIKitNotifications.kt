package dev.inmo.jsuikit.types

import dev.inmo.jsuikit.modifiers.UIKit
import dev.inmo.jsuikit.utils.Milliseconds
import kotlin.js.json

typealias NotificationsGroup = String

external interface UIKitNotifications {

    fun closeAll(group: NotificationsGroup)
}

external interface UIKitNotification {
    fun close(immediate: Boolean)
}

data class UIKitNotificationsParameters(
    val status: UIKitNotificationParameter.Style? = null,
    val timeout: Milliseconds? = null,
    val group: NotificationsGroup? = null,
    val position: UIKitNotificationParameter.Position? = null
) {
    fun parametersJson() = json(
        *listOfNotNull(
            status ?.let { it.parameterName to it.parameterValue },
            timeout ?.let { "timeout" to timeout.toString() },
            group ?.let { "group" to it },
            position ?.let { it.parameterName to it.parameterValue },
        ).toTypedArray()
    )
}

operator fun UIKitNotifications.invoke(
    message: String,
    parameters: UIKitNotificationsParameters
) = UIKit.notification(message, parameters.parametersJson())

operator fun UIKitNotifications.invoke(
    message: String,
    status: UIKitNotificationParameter.Style? = null,
    timeout: Milliseconds? = null,
    group: NotificationsGroup? = null,
    position: UIKitNotificationParameter.Position? = null
) = invoke(message, UIKitNotificationsParameters(status, timeout, group, position))
