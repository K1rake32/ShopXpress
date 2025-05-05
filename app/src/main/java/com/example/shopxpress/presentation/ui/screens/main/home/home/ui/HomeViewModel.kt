package com.example.shopxpress.presentation.ui.screens.main.home.home.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.presentation.data.TrendData
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _products = mutableListOf <ProductData>()
    private val _trends = mutableListOf<TrendData> ()
    private val _isLoading = MutableStateFlow(true)
    private val _state = MutableStateFlow(HomeState())


    val products: List<ProductData> get() = _products
    val trend: List<TrendData> get() = _trends
    val isLoading: StateFlow<Boolean> = _isLoading
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        viewModelScope.launch {

            loadProducts()
            loadTrends()

            delay(1000)
            _isLoading.value = false

        }
    }

    private fun loadProducts() {
        _products.addAll(listOf(
            ProductData(R.drawable.electronics_3, "Airpods Pro", "N120,000", "Electronics"),
            ProductData(R.drawable.electronics_4, "XBox Controller", "N190,000", "Electronics"),
            ProductData(R.drawable.shoes_7, "NIKE running shoes", "N175,000", "Shoes"),
            ProductData(R.drawable.macbook, "2019 MacBook Pro", "N950,000", "Electronics"),
            ProductData(R.drawable.shoes_2, "Crocs Brooklyn", "N950,000", "Shoes"),
            ProductData(R.drawable.shoes_6, "Nike SUPERPREP GO", "N60,000", "Shoes"),
            ProductData(R.drawable.shoes_x, "Pointed Toe Heels", "N16,000", "Shoes"),
            ProductData(R.drawable.macbook, "2019 MacBook Pro", "N950,000", "Electronics"),
            ProductData(R.drawable.quest, "Oculus Quest", "N175,000", "Electronics"),
            ProductData(R.drawable.electronics_2, "44” Smart Dell Tv", "N340,000", "Electronics"),
            ProductData(R.drawable.shoes_1, "Converse All Star", "N35,500", "Shoes"),
            ProductData(R.drawable.electronics_3, "Airpods Pro", "N120,000", "Electronics"),
            ProductData(R.drawable.electronics_4, "XBox Controller", "N190,000", "Electronics"),
            ProductData(R.drawable.electronics_4, "XBox Controller", "N190,000", "Electronics"),
            ProductData(R.drawable.sunglasses, "Luxury Sunglasses", "N12,000", "glasses"),
        ))
    }

    private fun loadTrends() {
        _trends.addAll(listOf(
            TrendData(R.drawable.shirt,"H&M Shirt", "N13,500", "5.0", "Fashion"),
            TrendData(R.drawable.electronics_1,"Bose Headphones", "N113,500", "4.0", "Electronics"),
            TrendData(R.drawable.electronics_4,"XBox Controller", "N190,000", "5.0", "Electronics"),
            TrendData(R.drawable.book_item,"User Story Book", "N6500", "3.0", "Book"),
            TrendData(R.drawable.shoes_7,"NIKE running shoes", "N175,000", "5.0", "Shoes"),
            TrendData(R.drawable.macbook,"2019 MacBook Pro", "N950,000", "4.0", "Electronics"),
        ))
    }


}