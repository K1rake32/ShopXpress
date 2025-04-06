package com.example.shopxpress.presentation.ui.screens.main.home.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import org.w3c.dom.Text

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
) {

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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Row {

                }

                Row {

                }

            }

            Spacer(modifier = Modifier.height(44.dp))

            Text(
                text = "Color",
                style = styleCategory,
                color = colorCategory,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            ColorDots(listOf(colorFirst, colorSecond, colorThird))

            Spacer(modifier = Modifier.padding(bottom = 28.dp))

            Text(
                text = "Size",
                style = styleCategory,
                color = colorCategory,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            SizeProduct()

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
                color = ShopXpressTheme.colors.text_100
            )

        }

    }

}

@Composable
private fun ColorDots(
    colors: List<Color>
) {

    Row(
        modifier = Modifier,

        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        colors.forEach {  color ->
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }

    }

}

@Composable
private fun SizeProduct(
    sizes: List<String> = listOf("S", "M", "L", "XL", "XXL")
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        sizes.forEach { size ->
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .border(1.dp, ShopXpressTheme.colors.text_40),

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