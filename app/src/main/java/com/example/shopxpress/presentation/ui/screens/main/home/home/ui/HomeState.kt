package com.example.shopxpress.presentation.ui.screens.main.home.home.ui

import androidx.compose.runtime.Immutable
import com.example.shopxpress.presentation.base.BaseEvent
import com.example.shopxpress.presentation.base.BaseState

@Immutable
data class HomeState(
    val search: String = "",
    val active: Boolean = false,

) : BaseState

sealed interface HomeEvent: BaseEvent {

    data class OnSearchChange(val value: String) : HomeEvent

    data class OnActiveChange(val value: Boolean) : HomeEvent

}