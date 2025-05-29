package com.example.shopxpress.presentation.ui.screens.main.cart.unCart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.MainNavBar
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun UnCartView(
    onShopping:() -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.TopCenter
    ) {
        MainNavBar(
            text = "Cart",
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.un_cart),
                contentDescription = "image_cart"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "You have not added items to cart yet.",
                style = ShopXpressTheme.typography.main_text.bold,
                color = ShopXpressTheme.colors.text_100
            )

            Spacer(modifier = Modifier.height(24.dp))

            DefaultButton(
                onclick = { onShopping()},
                text = "Start shopping",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 90.dp)
            )

        }

    }
}