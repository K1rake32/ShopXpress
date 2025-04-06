package com.example.shopxpress.presentation.ui.screens.main.home.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.DefaultNavBar
import com.example.shopxpress.presentation.ui.screens.main.home.detail.components.CardProduct
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun DetailProductView() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(ShopXpressTheme.colors.bcg_100),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            DefaultNavBar(
                image = R.drawable.icon_back,
                text = ""
            )

            Image(
                painter = painterResource(id = R.drawable.book_item),
                contentDescription = "",
                modifier = Modifier
                    .size(320.dp)
            )

            Spacer(modifier = Modifier.height(27.dp))

            CardProduct(
                category = "Fashion",
                title = "H&M Quality Shirt",
                colorFirst = ShopXpressTheme.colors.bright_0,
                colorSecond = ShopXpressTheme.colors.bright_10,
                colorThird = ShopXpressTheme.colors.bright_20,
                modifier = Modifier.fillMaxSize()
            )
        }

    }

@Composable
@Preview(showBackground = true)
private fun DetailProductViewPreview() {
    ShopXpressTheme {
        DetailProductView()
    }
}