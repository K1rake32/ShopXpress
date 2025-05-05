package com.example.shopxpress.presentation.ui.screens.auth.Login.ui

import androidx.lifecycle.ViewModel
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.OnEmailChange -> {
                _state.update {
                    it.copy(email = event.value).updateButtonState()
                }
            }
            is LoginEvent.OnPasswordChange -> {
                _state.update {
                    it.copy(password = event.value).updateButtonState()
                }
            }
        }
    }

    private fun LoginState.updateButtonState(): LoginState {

        return   this.copy(
            isButtonEnabled = email.isNotBlank() &&
                              password.isNotBlank()
        )

    }

}