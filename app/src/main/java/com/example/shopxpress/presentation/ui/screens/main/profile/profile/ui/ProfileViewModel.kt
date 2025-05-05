package com.example.shopxpress.presentation.ui.screens.main.profile.profile.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.presentation.data.ProfileData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel() {

    private val _item = mutableStateListOf <ProfileData>()
    val item: List<ProfileData> get() = _item

    init {
        viewModelScope.launch {
            loadItem()
        }
    }

     private fun loadItem() {

        _item.addAll(
            listOf(
                ProfileData(R.drawable.favorite, "Your wishlists"),
                ProfileData(R.drawable.history, "Order History"),
                ProfileData(R.drawable.addres, "Saved Addresses"),
                ProfileData(R.drawable.payment, "Payment details"),
                ProfileData(R.drawable.hekp, "Need help? Contact us"),
                ProfileData(R.drawable.log_out, "Log out"),
            )
        )

    }

}