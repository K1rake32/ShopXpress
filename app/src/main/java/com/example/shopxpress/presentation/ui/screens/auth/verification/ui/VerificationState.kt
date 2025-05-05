package com.example.shopxpress.presentation.ui.screens.auth.verification.ui

data class VerificationState(
    val code: List<Int?> = List(4) { null },
    val focusedIndex: Int? = null,
    val verificationResult: Boolean? = null
)