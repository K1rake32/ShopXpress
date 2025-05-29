package com.example.shopxpress.presentation.ui.screens.main.cart

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.presentation.navigation.Screens
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.CartView
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.ui.CartViewModel
import com.example.shopxpress.presentation.ui.screens.main.cart.unCart.UnCartView

@Composable
fun CartScreen(
    viewModel: CartViewModel,
    toShopping:() -> Unit
) {

    val cart = viewModel.cart

    if(cart.isEmpty()) {
        UnCartView(toShopping)
    } else {
        CartView(cartViewModel = viewModel)
    }

}

