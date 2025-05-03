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
            //shoes
            ProductData(R.drawable.shoes_1, "Converse All Star", "N35,500", "Shoes"),
            ProductData(R.drawable.shoes_2, "Crocs Brooklyn", "N950,000", "Shoes"),
            ProductData(R.drawable.shoes_3, "Oculus Quest", "N175,000", "Shoes"),
            ProductData(R.drawable.shoes_4, "Classic Oxford Shoe", "N30,000", "Shoes"),
            ProductData(R.drawable.shoes_x, "Pointed Toe Heels", "N16,000", "Shoes"),
            ProductData(R.drawable.shoes_6, "Nike SUPERPREP GO", "N60,000", "Shoes"),
            ProductData(R.drawable.shoes_7, "NIKE running shoes", "N175,000", "Shoes"),
            //electronics
            ProductData(R.drawable.macbook, "2019 MacBook Pro", "N950,000", "Electronics"),
            ProductData(R.drawable.quest, "Oculus Quest", "N175,000", "Electronics"),
            ProductData(R.drawable.electronics_2, "44” Smart Dell Tv", "N340,000", "Electronics"),
            ProductData(R.drawable.electronics_3, "Airpods Pro", "N120,000", "Electronics"),
            ProductData(R.drawable.electronics_4, "XBox Controller", "N190,000", "Electronics"),
        ))
    }

}

