package com.example.shopxpress.presentation.ui.screens.main.home.wishList.WishListEnabled

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.WishListNavBar
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun WishListView() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {

        WishListNavBar(
            label = "Wishlist",
            startImage = R.drawable.search,
            endImage = R.drawable.plus
        )

        Column {

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun WishListViewPreview() {

    ShopXpressTheme {
        WishListView()
    }

}