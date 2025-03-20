package com.example.shopxpress.presentation.ui.screens.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun IndicatorUI(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = ShopXpressTheme.colors.primary,
    unselectedColor: Color = ShopXpressTheme.colors.text_40
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        repeat(pageSize) {

            if(currentPage == it) {

                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .width(16.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(selectedColor)
                )

            } else {

                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(unselectedColor)
                )
            }
        }

    }

}

@Composable
@Preview
private fun IndicatorUIPreview() {

    ShopXpressTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            IndicatorUI(
                pageSize = 3,
                currentPage = 0
            )

            IndicatorUI(
                pageSize = 3,
                currentPage = 1
            )

            IndicatorUI(
                pageSize = 3,
                currentPage = 2
            )

        }
    }

}