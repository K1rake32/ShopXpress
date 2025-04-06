package com.example.shopxpress.presentation.ui.screens.auth.Signup.ui

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state.asStateFlow()


    fun onEvent(event: SignUpEvent) {
        when(event) {
            is SignUpEvent.OnEmailChange -> {
                _state.update {
                    it.copy(email = event.value).updateButtonState()
                }
            }
            is SignUpEvent.OnNumberChange -> {
                _state.update {
                    it.copy(number = event.value).updateButtonState()
                }
            }
            is SignUpEvent.OnPasswordChange -> {
                _state.update {
                    it.copy(password = event.value).updateButtonState()
                }
            }
        }
    }

    private fun SignUpState.updateButtonState(): SignUpState {
        return this.copy(
            isButtonEnabled = email.isNotBlank() &&
                              password.isNotBlank() &&
                              number.isNotBlank()
        )
    }

}