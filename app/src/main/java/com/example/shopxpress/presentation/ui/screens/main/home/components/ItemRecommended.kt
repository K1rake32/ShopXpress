package com.example.shopxpress.presentation.ui.screens.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.presentation.data.TrendData
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun ItemRecommended(
    items: List<ProductData>,
    modifier: Modifier = Modifier,
    clip: RoundedCornerShape = RoundedCornerShape(20.dp),
    itemContent: @Composable ColumnScope.(ProductData) -> Unit
) {
    val rows = remember(items) { items.chunked(2) }


    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        rows.forEach() { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowItems.forEach { product ->
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clip(clip)
                    ) {
                        Column { itemContent(product) }
                    }
                }
                if (rowItems.size < 2) {
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun ProductItem(
    product: ProductData,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit
) {

    ElevatedCard(
        modifier = Modifier
            .height(195.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {

        Column(
            modifier = Modifier
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(horizontal = 16.dp, vertical = 9.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    modifier = Modifier.align(alignment = Alignment.End)
                )

                Image(
                    painter = painterResource(id = product.mainImage),
                    contentDescription = ""
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ShopXpressTheme.colors.bcg_0)
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp)
                    .weight(1f),

                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = product.mainText,
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_80
                )

                Text(
                    text = product.minorText,
                    style = ShopXpressTheme.typography.textField_Text.extraBold,
                    color = ShopXpressTheme.colors.text_100
                )
            }


        }

    }

}

@Composable
fun TrendItem(
    trendProduct: TrendData
) {

    ElevatedCard(
    modifier = Modifier
        .width(255.dp)
        .height(275.dp)
        .padding(end = 15.dp)
    ) {

        Column(
            modifier = Modifier
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 9.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    modifier = Modifier.align(alignment = Alignment.End)
                )

                Image(
                    painter = painterResource(id = trendProduct.mainImage),
                    contentDescription = ""
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ShopXpressTheme.colors.bcg_0)
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 12.dp),

                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = trendProduct.title,
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_80
                )

                Text(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    text = trendProduct.price,
                    style = ShopXpressTheme.typography.textField_Text.extraBold,
                    color = ShopXpressTheme.colors.text_100
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Text(
                        text = trendProduct.reviews,
                        style = ShopXpressTheme.typography.minor_text.bold,
                        color = ShopXpressTheme.colors.text_80
                    )

                    Text(
                        text = trendProduct.category,
                        style = ShopXpressTheme.typography.minor_text.extraBold,
                        color = ShopXpressTheme.colors.text_100
                    )

                }

            }


        }

    }

}

val previewTrendData = TrendData(
    mainImage = R.drawable.book_item,
    title = "Nike Air Max 270",
    price = "$120.00",
    reviews = "4.8 (2.5k reviews)",
    category = "Sneakers"
)

@Composable
@Preview
private fun ItemPreview() {

    TrendItem(trendProduct = previewTrendData)

}
