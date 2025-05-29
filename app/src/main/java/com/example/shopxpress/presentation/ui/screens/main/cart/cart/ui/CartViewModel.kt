package com.example.shopxpress.presentation.ui.screens.main.cart.cart.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.CartData
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.components.CartItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val _cart = mutableStateListOf<CartData>()
    val cart: List<CartData> = _cart

    fun addCart(product: ProductData) {
        val item = CartData(
            mainImage = product.mainImage,
            label = product.mainText,
            size = product.minorText,
            price = product.category
        )
        _cart.add(item)
    }

    fun deleteCart(item: CartData) {
        _cart.remove(item)
    }
}
