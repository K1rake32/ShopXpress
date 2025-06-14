package com.example.shopxpress.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    modifier: Modifier = Modifier,
    click: () -> Unit
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
                contentDescription = "close/back",
                modifier = Modifier
                    .clickable { click() }
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
fun MainNavBar(
    text: String,
    style: TextStyle = ShopXpressTheme.typography.navigation_text.extraBold,
    color: Color = ShopXpressTheme.colors.text_100,
    image: Int? = null,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = Modifier,

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        
        image?.let { 
            Text(text = "")
        }

        Text(
            text = text,
            style = style,
            color = color
        )
        
        

        image?.let {
            
            Icon(
                painter = painterResource(id = image),
                contentDescription =  "edit_profile"
            )
            
        }

    }

}

@Composable
fun WishListNavBar(
    label: String,
    style: TextStyle = ShopXpressTheme.typography.main_text.bold,
    color: Color = ShopXpressTheme.colors.text_80,
    startImage: Int,
    endImage: Int,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.icon_back),
            contentDescription = "back"
        )

        Text(
            text = label,
            style = style,
            color = color
        )

        Row(
            modifier = Modifier,

            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = startImage),
                contentDescription = "$startImage"
            )

            Icon(
                painter = painterResource(id = endImage),
                contentDescription = "$endImage"
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
                text = "Create Account",
                click = {}
            )

            MainNavBar(
                text = "qwe"
            )

        }
    }

}

