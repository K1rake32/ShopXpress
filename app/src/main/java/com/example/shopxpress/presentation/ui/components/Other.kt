package com.example.shopxpress.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import com.example.shopxpress.presentation.ui.style.typography.ShopXpressFont

@Composable
fun DefaultNavBar(
    image: Int,
    text: String,
    background: Color = ShopXpressTheme.colors.bcg_0,
    style: TextStyle = ShopXpressTheme.typography.navigation_text.extraBold,
    color: Color = ShopXpressTheme.colors.text_100,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(vertical = 10.dp),

            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Icon(
                painter = painterResource(id = image),
                contentDescription = "close/back"
            )

            Text(
                text = text,
                style = style,
                color = color
            )

            Text(
                text = "test",
                modifier = Modifier
                    .alpha(0f)
            )

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun OtherPreview() {

    ShopXpressTheme {
        Column {

            DefaultNavBar(
                image = R.drawable.icon_close,
                text = "Create Account"
            )

        }
    }

}

