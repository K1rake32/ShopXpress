package com.example.shopxpress.presentation.ui.screens.main.home.detail.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.OutlinedDefaultButton
import com.example.shopxpress.presentation.ui.screens.main.home.detail.ui.DetailProductViewModel
import com.example.shopxpress.presentation.ui.screens.main.home.home.components.TrendItem
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun CardProduct(
    modifier: Modifier = Modifier,
    bcg: Color = ShopXpressTheme.colors.bcg_0,
    shape: RoundedCornerShape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
    category: String,
    styleCategory: TextStyle = ShopXpressTheme.typography.minor_text.extraBold,
    colorCategory: Color = ShopXpressTheme.colors.text_40,
    title: String,
    titleStyle: TextStyle = ShopXpressTheme.typography.button_text.bold,
    mainTextColor: Color = ShopXpressTheme.colors.text_80,
    colorFirst: Color,
    colorSecond: Color,
    colorThird: Color,
    viewModel: DetailProductViewModel = viewModel()
) {

    var selectedColor by remember { mutableStateOf(colorFirst) }

    val reviews = viewModel.reviews
    val trends = viewModel.trends

    var isLiked by remember { mutableStateOf(false)}

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(),

            shape = shape,

        colors = CardDefaults.cardColors(
            containerColor = bcg
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier
                .padding(vertical = 34.dp, horizontal = 24.dp)

        ) {
            Text(
                text = category,
                style = styleCategory,
                color = colorCategory,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = title,
                style = titleStyle,
                color = mainTextColor,
                modifier = Modifier.padding(bottom = 16.dp)
            )

           RatingStar(
               rating = 5,
               isDiscount = true,
               discountText = "N18,000",
               price = "N13,500"
           )

            Spacer(modifier = Modifier.height(23.dp))

            Text(
                text = "Color",
                style = styleCategory,
                color = colorCategory,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            ColorDots(
                listOf(colorFirst, colorSecond, colorThird),
                selectedColor = selectedColor,
                onColorSelected = {selectedColor = it}
            )

            Spacer(modifier = Modifier.padding(bottom = 28.dp))

            Text(
                text = "Size",
                style = styleCategory,
                color = colorCategory,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            SizeProduct(
            )

            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            Text(
                text = "Description",
                style = styleCategory,
                color = colorCategory,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            Text(
                text = stringResource(id = R.string.description_main),
                style = ShopXpressTheme.typography.main_text.regular,
                color = ShopXpressTheme.colors.text_100,
                modifier = Modifier
                    .padding(bottom = 28.dp)
            )

            Text(
                text = "Reviews",
                style = styleCategory,
                color = colorCategory,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    reviews.forEach{ review ->
                        ReviewsItem(reviews = review)
                    }

                }

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "People also bought",
                style = ShopXpressTheme.typography.main_text.bold,
                color = ShopXpressTheme.colors.text_80,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {

                items(trends) { trend ->
                    TrendItem(trendProduct = trend, clickable = {})
                }

            }

            Spacer(modifier = Modifier.height(21.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                OutlinedDefaultButton(
                    onclick = {isLiked = !isLiked},
                    text = "",
                    modifier = Modifier
                        .weight(0.35f),
                    isImage = true,
                    icon = if(isLiked) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder
                )

                Spacer(modifier = Modifier.width(17.dp))

                DefaultButton(
                    onclick = { /*TODO*/ },
                    text = "Add to cart",
                    modifier = Modifier
                        .weight(0.65f),

                )

            }

        }

    }

}

@Composable
fun ColorDots(
    colors: List<Color>,
    selectedColor: Color,
    onColorSelected: (Color) -> Unit,
    isSelectedColor: Color = ShopXpressTheme.colors.primary,
    unselectedColor: Color = Color.Transparent
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        colors.forEach { color ->
            val isSelected = color == selectedColor

            Box(
                modifier = Modifier
                    .size(35.dp)
                    .clickable { onColorSelected(color) },
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.matchParentSize()) {
                    drawCircle(
                        color = if (isSelected) isSelectedColor else unselectedColor,
                        style = Stroke(width = if (isSelected) 2.dp.toPx() else 0.dp.toPx())
                    )
                }

                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(color)
                )
            }
        }
    }
}

@Composable
private fun SizeProduct(
    sizes: List<String> = listOf("S", "M", "L", "XL", "XXL"),
) {

    var selectedSize by remember { mutableStateOf<String?>(null) }


    Row(
        modifier = Modifier
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        sizes.forEach { size ->

            val isSelected = size == selectedSize

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .border(1.dp, ShopXpressTheme.colors.text_40)
                    .background(
                        if (isSelected) ShopXpressTheme.colors.accent_100
                        else ShopXpressTheme.colors.bcg_0
                    )
                    .clickable {
                        selectedSize = size
                    },

                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = size,
                    style = ShopXpressTheme.typography.navigation_text.bold,
                    color = ShopXpressTheme.colors.text_100,
                )
            }
        }
    }

}

@Composable
private fun RatingStar(
    rating: Int,
    maxRating: Int = 5,
    isDiscount: Boolean = false,
    discountText: String = "",
    price: String,
    filledColor: Color = ShopXpressTheme.colors.text_100,
    unfilledColor: Color = ShopXpressTheme.colors.bcg_0
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(maxRating) { index ->
                Icon(
                    modifier = Modifier
                        .size(14.dp),
                    imageVector = if(index < rating) Icons.Default.Star else Icons.Outlined.Star,
                    contentDescription = "",
                    tint = if(index < rating) filledColor else Color.LightGray
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = rating.toFloat().toString(),
                style = ShopXpressTheme.typography.minor_text.extraBold,
                color = ShopXpressTheme.colors.text_80
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = if (isDiscount) discountText else "",
                style = ShopXpressTheme.typography.main_text.regular,
                color = ShopXpressTheme.colors.text_60,
                textDecoration = TextDecoration.LineThrough
            )
            
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = price,
                style = ShopXpressTheme.typography.button_text.extraBold,
                color = ShopXpressTheme.colors.text_80
            )

        }

    }

}

@Composable
@Preview
private fun CardProductPreview() {
    ShopXpressTheme {
        CardProduct(
            category = "Fashion",
            title = "H&M Quality Shirt",
            colorFirst = ShopXpressTheme.colors.bright_0,
            colorSecond = ShopXpressTheme.colors.bright_10,
            colorThird = ShopXpressTheme.colors.bright_20,
        )
    }
}