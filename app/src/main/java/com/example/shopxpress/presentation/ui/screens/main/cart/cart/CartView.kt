package com.example.shopxpress.presentation.ui.screens.main.cart.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.AuthTextField
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.MainNavBar
import com.example.shopxpress.presentation.ui.components.OutlinedDefaultButton
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.components.CartItem
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.ui.CartViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import com.example.shopxpress.presentation.ui.style.string.Strings

@Composable
fun CartView(
    cartViewModel: CartViewModel,
) {

    val carts = cartViewModel.cart

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .background(ShopXpressTheme.colors.bcg_0)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MainNavBar(
            text = "Cart"
        )
        
        Spacer(modifier = Modifier.height(36.dp))

        Column(
        ) {
            carts.forEach() { cart ->
                CartItem(
                    image = cart.mainImage,
                    label = cart.label,
                    size = cart.size,
                    price = cart.price,
                    onDelete = {cartViewModel.deleteCart(cart)}
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp, top = 24.dp)
                .padding(horizontal = 24.dp),

            horizontalAlignment = Alignment.Start
        ) {
            
            Text(
                text = "Got discount code?",
                style = ShopXpressTheme.typography.main_text.regular,
                color = ShopXpressTheme.colors.text_80
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AuthTextField(
                    text = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(230.dp)
                )

                OutlinedDefaultButton(
                    onclick = { /*TODO*/ },
                    text = "Apply",
                    modifier = Modifier
                        .height(60.dp)
                )
            }

        }

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp),

            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Subtotal",
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_40
                )

                Text(
                    text = "N48,500",
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_100
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Discount",
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_40
                )

                Text(
                    text = "0",
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_100
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Total",
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_100
                )

                Text(
                    text = "N48,500",
                    style = ShopXpressTheme.typography.main_text.bold,
                    color = ShopXpressTheme.colors.text_100
                )

            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Column (
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(ShopXpressTheme.colors.accent_20)
            ) {

                Row(
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 11.dp),

                    horizontalArrangement = Arrangement.spacedBy(7.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.attention),
                        contentDescription = ""
                    )

                    Text(
                        text = Strings.attention,
                        style = ShopXpressTheme.typography.minor_text.regular,
                        color = ShopXpressTheme.colors.text_80
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        DefaultButton(
            onclick = { /*TODO*/ },
            text = "Proceed to Checkout",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )


    }

}

@Composable
@Preview(showBackground = true)
private fun CartViewPreview() {

    val cartViewModel: CartViewModel = viewModel()

    ShopXpressTheme {
        CartView(cartViewModel)
    }
}