package com.example.shopxpress.presentation.ui.screens.main.home.wishList.WishListNotEnabled

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.MainNavBar
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun UnWishList() {

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
                painter = painterResource(id = R.drawable.wishlist),
                contentDescription = "image_cart"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "You do not have any wishlist created",
                style = ShopXpressTheme.typography.main_text.bold,
                color = ShopXpressTheme.colors.text_100,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Create up to 3 wishlists of your favourite\nitems that you want to shop",
                style = ShopXpressTheme.typography.textField_Text.regular,
                color = ShopXpressTheme.colors.text_60,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            DefaultButton(
                onclick = {},
                text = "Create wishlist",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 90.dp)
            )

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun UnWishListPreview() {

    ShopXpressTheme {
        UnWishList()
    }

}