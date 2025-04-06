package com.example.shopxpress.presentation.ui.screens.auth.Signup.ui

import androidx.compose.runtime.Immutable
import com.example.shopxpress.presentation.base.BaseEvent
import com.example.shopxpress.presentation.base.BaseState

@Immutable
data class SignUpState(
    val email: String = "",
    val password: String = "",
    val number: String = "",
    val isButtonEnabled: Boolean = false
) : BaseState

sealed interface SignUpEvent: BaseEvent {

    data class OnNumberChange(val value: String) : SignUpEvent

    data class OnEmailChange(val value: String) : SignUpEvent

    data class OnPasswordChange(val value: String) : SignUpEvent

}