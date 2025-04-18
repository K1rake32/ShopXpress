package com.example.shopxpress.presentation.base

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface EventHandler<S: BaseState, E: BaseEvent, A: BaseAction> {

    val viewStates: StateFlow<S>

    val viewActions: SharedFlow<A>

    fun obtainedEvent(event: E)

}