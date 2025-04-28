package com.example.shopxpress.presentation.navigation.bottomNavigation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopxpress.R
import kotlinx.coroutines.launch

class BottomNavigationViewModel: ViewModel() {

    private val _items = mutableStateListOf<BottomData>()
    val items: List<BottomData> get() = _items

    init {
        viewModelScope.launch {
            listData()
        }
    }

    private fun listData() {
        _items.addAll(
            listOf(
                BottomData(
                    unSelectedImage = R.drawable.home,
                    selectedImage = R.drawable.home_active,
                    title = "Home"
                ),
                BottomData(
                    unSelectedImage = R.drawable.categories,
                    selectedImage = R.drawable.categories_active,
                    title = "Categories"
                ),
                BottomData(
                    unSelectedImage = R.drawable.profile,
                    selectedImage = R.drawable.profile_active,
                    title = "Profile"
                ),
                BottomData(
                    unSelectedImage = R.drawable.cart,
                    selectedImage = R.drawable.cart_active,
                    title = "Cart"
                ),
            )
        )
    }

}