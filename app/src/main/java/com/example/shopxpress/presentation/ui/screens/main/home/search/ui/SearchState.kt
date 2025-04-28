package com.example.shopxpress.presentation.ui.screens.main.home.search.ui

import androidx.compose.runtime.Immutable
import com.example.shopxpress.presentation.base.BaseEvent
import com.example.shopxpress.presentation.base.BaseState
import com.example.shopxpress.presentation.ui.screens.main.home.home.ui.HomeState
import kotlinx.coroutines.flow.MutableStateFlow

@Immutable
data class SearchState(
    val search: String = "",
    val active: Boolean = true,

    ) : BaseState

sealed interface SearchEvent: BaseEvent {

    data class OnSearchChange(val value: String) : SearchEvent

    data class OnActiveChange(val value: Boolean) : SearchEvent

}