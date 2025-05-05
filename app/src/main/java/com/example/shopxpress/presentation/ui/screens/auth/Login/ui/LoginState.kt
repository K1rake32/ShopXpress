package com.example.shopxpress.presentation.ui.screens.auth.Login.ui

import com.example.shopxpress.presentation.base.BaseEvent
import com.example.shopxpress.presentation.base.BaseState
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpEvent

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isButtonEnabled: Boolean = false,
) : BaseState

sealed interface LoginEvent: BaseEvent {

    data class OnEmailChange(val value: String) : LoginEvent

    data class OnPasswordChange(val value: String) : LoginEvent
}