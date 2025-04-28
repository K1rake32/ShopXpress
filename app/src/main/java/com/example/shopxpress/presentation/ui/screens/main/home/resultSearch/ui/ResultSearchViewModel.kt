package com.example.shopxpress.presentation.ui.screens.main.home.resultSearch.ui

import android.content.Context
import android.view.View
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.storage.DataStoreManager
import com.example.shopxpress.storage.data.SettingsData
import kotlinx.coroutines.launch
class ResultSearchViewModel: ViewModel() {

    private val _products = mutableListOf<ProductData>()
    val products: List<ProductData> get() = _products
    init {
        viewModelScope.launch {

            loadProducts()
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

}

