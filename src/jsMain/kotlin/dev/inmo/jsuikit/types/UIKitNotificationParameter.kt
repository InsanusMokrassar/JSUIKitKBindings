package dev.inmo.jsuikit.types

sealed class UIKitNotificationParameter {
    abstract val parameterName: String
    abstract val parameterValue: String

    sealed class Style(override val parameterValue: String) : UIKitNotificationParameter() {
        override val parameterName: String
            get() = "status"

        object Primary : Style("primary")
        object Success : Style("success")
        object Warning : Style("warning")
        object Danger : Style("danger")

    }

    sealed class Position(override val parameterValue: String) : UIKitNotificationParameter() {
        override val parameterName: String
            get() = "pos"

        sealed class Top(parameterValue: String) : Position("top-$parameterValue") {

            object Left : Top("left")
            object Center : Top("center")
            object Right : Top("right")

        }

        sealed class Bottom(parameterValue: String) : Position("bottom-$parameterValue") {

            object Left : Bottom("left")
            object Center : Bottom("center")
            object Right : Bottom("right")

        }

    }
}
