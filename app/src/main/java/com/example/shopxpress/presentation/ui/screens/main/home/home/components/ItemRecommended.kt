package com.example.shopxpress.presentation.ui.screens.main.home.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
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
                            .weight(1f),
                        shape = clip,

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
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
    clickable: (ProductData) -> Unit,
    bcg: Color = ShopXpressTheme.colors.bcg_100
) {

    var isLiked by remember { mutableStateOf(false)}
    var isOverflow by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .height(195.dp)
            .clickable { clickable(product) },
        shape = RoundedCornerShape(5.dp),

        colors = CardDefaults.cardColors(
            containerColor = bcg
        )
    ) {

        Column(
            modifier = Modifier
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(vertical = 9.dp)
                    .padding(start = 16.dp,),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = if(isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    tint = if(isLiked) Color.Red else Color.Gray,
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .clickable {
                            isLiked = !isLiked
                        },
                )

                Image(
                    painter = painterResource(id = product.mainImage),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 16.dp)
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

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = product.mainText,
                        style = ShopXpressTheme.typography.main_text.regular,
                        color = ShopXpressTheme.colors.text_80,
                        maxLines = 1,
                        overflow = TextOverflow.Clip,
                        onTextLayout = { result ->
                            isOverflow = result.hasVisualOverflow
                        },
                        softWrap = false,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (isOverflow) {
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            ShopXpressTheme.colors.bcg_0
                                        ),
                                        startX = 150f,
                                        endX = Float.POSITIVE_INFINITY
                                    )
                                )
                        )
                    }
                }

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
    trendProduct: TrendData,
    bcg: Color = ShopXpressTheme.colors.bcg_100,
    clickable: (TrendData) -> Unit
) {

    var isLiked by remember { mutableStateOf(false)}

    Card(
    modifier = Modifier
        .width(255.dp)
        .height(265.dp)
        .padding(end = 15.dp)
        .clickable { clickable(trendProduct) },

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),

        colors = CardDefaults.cardColors(
            containerColor = bcg
        )
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
                    imageVector = if(isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    tint = if(isLiked) Color.Red else Color.Gray,
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .clickable {
                            isLiked = !isLiked
                        },
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
                    .padding(vertical = 12.dp)
                    .weight(1f),

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
                        .fillMaxWidth(),
                    
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "star",
                        modifier = Modifier
                            .padding(end = 4.dp)
                    )

                    Text(
                        text = trendProduct.reviews,
                        style = ShopXpressTheme.typography.minor_text.bold,
                        color = ShopXpressTheme.colors.text_80,
                        modifier = Modifier
                            .padding(end = 30.dp)
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



}
