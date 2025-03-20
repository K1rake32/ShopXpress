package com.example.shopxpress.presentation.ui.screens.auth.Signup.ui

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state.asStateFlow()


    fun onEvent(event: SignUpEvent) {
        when(event) {
            is SignUpEvent.OnEmailChange -> {
                _state.value = _state.value.copy(email = event.value)
            }
            is SignUpEvent.OnNumberChange -> {
                _state.value = _state.value.copy(number = event.value)
            }
            is SignUpEvent.OnPasswordChange -> {
                _state.value = _state.value.copy(password = event.value)
            }
        }
    }



}