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
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _products = mutableListOf <ProductData>()
    private val _trends = mutableListOf<TrendData> ()
    private val _isLoading = MutableStateFlow(true)


    val products: List<ProductData> get() = _products
    val trend: List<TrendData> get() = _trends
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        viewModelScope.launch {

            loadProducts()
            loadTrends()

            delay(2000)
            _isLoading.value = false

        }
    }

    private fun loadProducts() {
        _products.addAll(listOf(
            ProductData(R.drawable.book_item, "User Story Book", "N6500"),
            ProductData(R.drawable.macbook, "2019 MacBook Pro", "N950,000"),
            ProductData(R.drawable.sunglasses, "Luxury Sunglasses", "N12,000"),
            ProductData(R.drawable.quest, "Oculus Quest", "N175,000"),
            ProductData(R.drawable.book_item, "User Story Book", "N6500"),
            ProductData(R.drawable.macbook, "2019 MacBook Pro", "N950,000"),
            ProductData(R.drawable.sunglasses, "Luxury Sunglasses", "N12,000"),
            ProductData(R.drawable.quest, "Oculus Quest", "N175,000"),
            ProductData(R.drawable.book_item, "User Story Book", "N6500"),
            ProductData(R.drawable.macbook, "2019 MacBook Pro", "N950,000"),
            ProductData(R.drawable.sunglasses, "Luxury Sunglasses", "N12,000"),
            ProductData(R.drawable.quest, "Oculus Quest", "N175,000"),
            ProductData(R.drawable.book_item, "User Story Book", "N6500"),
            ProductData(R.drawable.macbook, "2019 MacBook Pro", "N950,000"),
            ProductData(R.drawable.sunglasses, "Luxury Sunglasses", "N12,000"),
            ProductData(R.drawable.quest, "Oculus Quest", "N175,000"),
            ProductData(R.drawable.book_item, "User Story Book", "N6500"),
            ProductData(R.drawable.macbook, "2019 MacBook Pro", "N950,000"),
            ProductData(R.drawable.sunglasses, "Luxury Sunglasses", "N12,000"),
            ProductData(R.drawable.quest, "Oculus Quest", "N175,000"),
        ))
    }

    private fun loadTrends() {
        _trends.addAll(listOf(
            TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
            TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
            TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
            TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
            TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
            TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
        ))
    }


}