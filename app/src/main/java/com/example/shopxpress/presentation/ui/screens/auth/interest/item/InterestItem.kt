package com.example.shopxpress.presentation.ui.screens.auth.interest.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopxpress.presentation.data.InterestData
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun InterestItem(
    item: InterestData,
    onItemClick: (InterestData) -> Unit,
    bcg: Color = ShopXpressTheme.colors.bcg_0,
    isSelected: Boolean
) {

    Box(
        modifier = Modifier
            .size(item.size)
            .clip(CircleShape)
            .border(1.dp, ShopXpressTheme.colors.text_40, CircleShape)
            .background(if(isSelected) ShopXpressTheme.colors.accent_100 else ShopXpressTheme.colors.bcg_0)
            .clickable { onItemClick(item) },

        contentAlignment = Alignment.Center

    ) {
        Row {
            
            Image(
                modifier = Modifier.size(if (item.size < 110.dp) 22.dp else 32.dp),
                painter = painterResource(id = item.image), 
                contentDescription = "image_class"
            )
            
            Spacer(modifier = Modifier.width(4.dp))
            
            Text(
                text = item.text,
                style = if (item.size < 110.dp) ShopXpressTheme.typography.navigation_text.bold
                else ShopXpressTheme.typography.medium_text.bold,
                color = ShopXpressTheme.colors.text_100
            )
            
        }
    }

}