package com.example.shopxpress.presentation.ui.screens.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun InAppCard(
    image: Int,
    upText: String,
    middleText: String,
    bottomText: String,
    styleUpBotText: TextStyle = ShopXpressTheme.typography.main_text.bold,
    styleMiddleText: TextStyle = ShopXpressTheme.typography.medium_text.bold,
    colorMinor: Color = ShopXpressTheme.colors.primary,
    colorMain: Color = ShopXpressTheme.colors.text_80,
    bcg: Color = ShopXpressTheme.colors.other_0,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(bcg)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(vertical = 10.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = upText,
                    style = styleUpBotText,
                    color = colorMain
                )

                Text(
                    text = middleText,
                    style = styleMiddleText,
                    color = colorMinor
                )

                Text(
                    text = bottomText,
                    style = styleUpBotText,
                    color = colorMain
                )

            }

            Image(
                modifier = Modifier
                    .padding(top = 12.dp),
                painter = painterResource(id = image),
                contentDescription = ""
            )

        }

    }

}

@Composable
@Preview
private fun InAppCardPreview() {

    ShopXpressTheme {
        InAppCard(
            image = R.drawable.group_dress,
            upText = "Preview",
            middleText = "Preview",
            bottomText = "Preview"
        )
    }

}