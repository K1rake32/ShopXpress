package com.example.shopxpress.presentation.ui.screens.main.profile.profile.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ProfileData
import com.example.shopxpress.presentation.ui.screens.main.profile.profile.ui.ProfileViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun CardAccountItem(
    shape: RoundedCornerShape = RoundedCornerShape(20.dp),
    bcg: Color = ShopXpressTheme.colors.bcg_0,
    item: ProfileData,
    showArrow: Boolean = true
) {




            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row {
                    Icon(
                        painter = painterResource(id = item.image),
                        contentDescription = "image",
                        tint = if(showArrow) ShopXpressTheme.colors.primary else ShopXpressTheme.colors.text_60
                    )
                    
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = item.label,
                        style = ShopXpressTheme.typography.main_text.regular,
                        color = ShopXpressTheme.colors.text_80
                    )
                }

                if(showArrow) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "arrow"
                    )
                }
            }



}