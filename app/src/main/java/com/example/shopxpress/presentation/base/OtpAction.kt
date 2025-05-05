package com.example.shopxpress.presentation.base

sealed interface OtpAction{
    data class OnEnterNumber(val number: Int?, val index: Int): OtpAction
    data class OnChangedFieldFocused(val index: Int): OtpAction
    data object OnKeyboardBack: OtpAction

    object VerifyCode : OtpAction
}