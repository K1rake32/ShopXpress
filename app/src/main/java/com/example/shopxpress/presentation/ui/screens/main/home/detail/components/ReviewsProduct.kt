package com.example.shopxpress.presentation.ui.screens.main.home.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.presentation.ui.screens.main.home.detail.ui.DetailProductViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ReviewsData

@Composable
fun ReviewsItem(
    reviews: ReviewsData,
    maxRating: Int = 5,
    filledColor: Color = ShopXpressTheme.colors.text_100,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    ) {

        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(17.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                    ) {
                        Image(
                            painter = painterResource(reviews.avatar),
                            contentDescription = "avatar",
                            modifier = Modifier
                        )
                    }

                    Column {
                        Text(
                            text = reviews.title,
                            style = ShopXpressTheme.typography.main_text.bold,
                            color = ShopXpressTheme.colors.text_100
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            repeat(maxRating) { index ->
                                Icon(
                                    modifier = Modifier
                                        .size(14.dp),
                                    imageVector = if(index < reviews.stars) Icons.Default.Star else Icons.Outlined.Star,
                                    contentDescription = "",
                                    tint = if(index < reviews.stars) filledColor else Color.LightGray
                                )
                            }

                            Text(
                                text = reviews.stars.toFloat().toString(),
                                style = ShopXpressTheme.typography.minor_text.extraBold,
                                color = ShopXpressTheme.colors.text_80
                            )
                        }

                    }

                }

                Text(
                    text = reviews.time,
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_60
                )

            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = reviews.description,
                style = ShopXpressTheme.typography.main_text.regular,
                color = ShopXpressTheme.colors.text_100
            )

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun ReviewsProductPreview() {

    ShopXpressTheme {
        ReviewsItem(
            reviews = ReviewsData(
                avatar = R.drawable.avatar_1,
                title = "Awesome Product!",
                time = "1 day ago",
                description = "Really good quality, fast shipping, would buy again.",
                stars = 4
            )
        )
    }
}