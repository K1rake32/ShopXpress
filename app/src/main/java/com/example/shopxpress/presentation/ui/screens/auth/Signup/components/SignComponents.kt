package com.example.shopxpress.presentation.ui.screens.auth.Signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun AroundLink(
    image: Int,
    text: String,
    facebook: Boolean = false
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(85.dp)
                .background(ShopXpressTheme.colors.bcg_0)
                .border(
                    1.dp,
                    ShopXpressTheme.colors.text_20,
                    shape = CircleShape
                ),

            contentAlignment = Alignment.Center
        ) {

            if (facebook) {

                Image(
                    modifier = Modifier
                        .size(55.dp),
                    painter = painterResource(id = image),
                    contentDescription = ""
                )

            } else {

                Image(
                    modifier = Modifier
                        .padding(21.dp),
                    painter = painterResource(id = image),
                    contentDescription = "link"
                )

            }

        }

        Text(
            text = text,
            style = ShopXpressTheme.typography.main_text.bold,
            color = ShopXpressTheme.colors.text_80
        )

    }

}

@Composable
@Preview(showBackground = true)
private fun AroundLinkPreview() {

    ShopXpressTheme {
        AroundLink(
            image = R.drawable.apple,
            text = "Apple",
        )
    }

}