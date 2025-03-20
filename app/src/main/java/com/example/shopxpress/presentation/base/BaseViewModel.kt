package com.example.shopxpress.presentation.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<S: BaseState, E: BaseEvent, A:BaseAction>(
    initialState: S
) : ViewModel(), EventHandler<S, E, A> {



}