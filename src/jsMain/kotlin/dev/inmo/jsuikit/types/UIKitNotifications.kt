package dev.inmo.jsuikit.types

import dev.inmo.jsuikit.utils.Milliseconds
import org.w3c.dom.Element
import kotlin.js.Json
import kotlin.js.json

typealias NotificationsGroup = String

external interface UIKitNotifications {

    fun closeAll(group: NotificationsGroup)

    operator fun invoke(message: String, parameters: Json)

    operator fun invoke(element: Element): UIKitNotification?
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
) = invoke(message, parameters.parametersJson())

operator fun UIKitNotifications.invoke(
    message: String,
    status: UIKitNotificationParameter.Style? = null,
    timeout: Milliseconds? = null,
    group: NotificationsGroup? = null,
    position: UIKitNotificationParameter.Position? = null
) = invoke(message, UIKitNotificationsParameters(status, timeout, group, position))
