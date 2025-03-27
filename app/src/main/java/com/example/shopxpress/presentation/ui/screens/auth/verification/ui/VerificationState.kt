package com.example.shopxpress.presentation.ui.screens.auth.verification.ui

data class VerificationState(
    val code: List<Int?> = (1 .. 4).map { null },
    val focusedIndex: Int? = null,
    val isValid: Boolean? = null
)