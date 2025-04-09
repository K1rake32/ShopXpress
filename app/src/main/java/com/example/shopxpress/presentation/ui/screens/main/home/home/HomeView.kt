package com.example.shopxpress.presentation.ui.screens.main.home.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.presentation.data.TrendData
import com.example.shopxpress.presentation.shimmer.HomeShimmer
import com.example.shopxpress.presentation.ui.components.SearchTextField
import com.example.shopxpress.presentation.ui.components.TextBackButton
import com.example.shopxpress.presentation.ui.screens.main.home.home.components.InAppCard
import com.example.shopxpress.presentation.ui.screens.main.home.home.components.ItemRecommended
import com.example.shopxpress.presentation.ui.screens.main.home.home.components.ProductItem
import com.example.shopxpress.presentation.ui.screens.main.home.home.components.TrendItem
import com.example.shopxpress.presentation.ui.screens.main.home.home.ui.HomeViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    toDetail: () -> Unit
) {

    val products = viewModel.products
    val trends = viewModel.trend

    val isLoading by viewModel.isLoading.collectAsState()

    if(isLoading) {
        HomeShimmer()
    } else {
        HomeView(products, trends, {toDetail()})
    }

}

@Composable
fun HomeView(
    products: List<ProductData>,
    trends: List<TrendData>,
    clickable: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .padding(top = 12.dp)
            .verticalScroll(rememberScrollState())
            .background(ShopXpressTheme.colors.bcg_0),

        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(ShopXpressTheme.colors.accent_20),

                        contentAlignment = Alignment.Center

                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.time_avatar),
                            contentDescription = ""
                        )

                    }

                    Text(
                        text = "Welcome Oye!",
                        style = ShopXpressTheme.typography.navigation_text.bold,
                        color = ShopXpressTheme.colors.text_80
                    )

                }

                Icon(
                    modifier = Modifier
                        .size(33.dp),
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "favorite",
                    tint = ShopXpressTheme.colors.primary
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                SearchTextField(
                    modifier = Modifier
                        .weight(0.3f),
                    value = "",
                    onValueChange = {},
                    startIcon = R.drawable.search,
                    placeholder = stringResource(id = R.string.search_main)
                )

                Box(
                    modifier = Modifier
                        .background(ShopXpressTheme.colors.bcg_100)
                        .border(1.dp, ShopXpressTheme.colors.text_20, RoundedCornerShape(18.dp))
                ) {

                    Icon(
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .padding(horizontal = 12.dp),
                        painter = painterResource(id = R.drawable.artwork),
                        contentDescription = "",
                        tint = ShopXpressTheme.colors.primary
                    )

                }

            }

            InAppCard(
                image = R.drawable.group_dress,
                upText = "Save Up to",
                middleText = "25% off",
                bottomText = "Men Fashion Items Now!!"
            )


            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Recommended for you",
                        style = ShopXpressTheme.typography.main_text.bold,
                        color = ShopXpressTheme.colors.text_80
                    )

                    TextBackButton(
                        onclick = { /*TODO*/ },
                        text = "See all",
                        style = ShopXpressTheme.typography.textField_Text.bold,
                        color = ShopXpressTheme.colors.primary
                    )

                }

                ItemRecommended(
                    items = products.take(6),
                ) { product ->

                    ProductItem(
                        product = product,
                        clickable = {clickable()}
                    )
                }

            }

            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {

                items(trends) { trend ->
                    TrendItem(
                        trendProduct = trend,
                    )
                }

            }

            ItemRecommended(
                items = products.drop(6).take(6)
            ) { product ->

                ProductItem(
                    product = product,
                    clickable = {clickable()}
                )

            }
    }

}



@Composable
@Preview(showBackground = true)
private fun HomeViewPreview() {

    val viewModel = HomeViewModel()

    val products = viewModel.products
    val trends = viewModel.trend

    ShopXpressTheme {

        HomeView(products = products, trends = trends, {})
        
    }

}