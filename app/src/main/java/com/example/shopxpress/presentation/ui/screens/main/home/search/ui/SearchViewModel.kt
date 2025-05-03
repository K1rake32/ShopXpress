package com.example.shopxpress.presentation.ui.screens.main.home.search.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.presentation.data.SearchData
import com.example.shopxpress.presentation.ui.screens.main.home.home.ui.HomeEvent
import com.example.shopxpress.presentation.ui.screens.main.home.home.ui.HomeState
import com.example.shopxpress.storage.DataStoreManager
import com.example.shopxpress.util.SearchObject
import com.example.shopxpress.util.SearchObject.search
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    val history = dataStoreManager.getSearchHistory()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    private val _item = mutableStateListOf<SearchData>()
    val item: List<SearchData> get() = _item

    private val originalItems = SearchObject.originalProduct

    var original by mutableStateOf(originalItems)
        private set

    init {
        loadHistory()
    }

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnSearchChange -> {
                _state.update { it.copy(search = event.value) }
                search(event.value)
            }
            is SearchEvent.OnActiveChange -> {
                _state.update { it.copy(active = event.value) }
            }
        }
    }

    fun removeItem(query: String) {
        viewModelScope.launch {
            dataStoreManager.removeSearchQuery(query)
            loadHistory()
        }
    }

    fun addQueryToHistory(query: String) {
        viewModelScope.launch {

            val cleanedQuery = query.trim()

            if (cleanedQuery.isNotBlank()) {
                val currentHistory = dataStoreManager.getSearchHistory().first()

                if(cleanedQuery !in currentHistory) {
                    dataStoreManager.addSearchQuery(cleanedQuery)
                }
            }
        }
    }

    private fun loadHistory() {
        viewModelScope.launch {
            dataStoreManager.getSearchHistory().collect { queries ->
                _item.clear()
                _item.addAll(queries.map { SearchData(it) })

            }
        }
    }

    private fun search(query: String) {
        _item.clear()

        if (query.isBlank()) {
            historyItem()
        } else {
            val results = SearchObject.search(query)
            _item.addAll(results.map { SearchData(it) })
        }
    }



    private fun historyItem() {
        _item.clear()
        _item.addAll(listOf(
            SearchData("Трусы спанч боб")
        ))
    }
}