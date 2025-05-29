package com.example.shopxpress.presentation.ui.screens.main.cart.cart.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDecay
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.CartData
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.ui.CartViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun CartItem(
    image: Int,
    label: String,
    size: String,
    price: String,
    onDelete: () -> Unit
) {

    val count = remember { mutableStateOf(1) }
    var showDelete by remember { mutableStateOf(false) }
    val offset by animateDpAsState(
        targetValue = if(showDelete) (-80).dp else 0.dp,
        label = "offset"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
    ) {

        AnimatedVisibility(
            visible = showDelete,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(93.dp)
                .fillMaxHeight()
                .padding(start = 24.dp)
                .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                .background(Color.Red),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete_item),
                    contentDescription = "delete",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .size(36.dp)
                        .clickable { onDelete() }
                )
            }
        }


            Box(
                modifier = Modifier
                    .offset(x = offset)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ShopXpressTheme.colors.bcg_100),

                ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp, horizontal = 16.dp),

                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(ShopXpressTheme.colors.bcg_0)
                            .width(113.dp)
                            .height(128.dp),

                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "item",
                            modifier = Modifier
                                .padding(vertical = 28.dp, horizontal = 23.dp)
                        )
                    }


                    Column(
                        modifier = Modifier
                            .padding(start = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Text(
                            text = label,
                            style = ShopXpressTheme.typography.main_text.regular,
                            color = ShopXpressTheme.colors.text_80
                        )

                        Text(
                            text = size,
                            style = ShopXpressTheme.typography.minor_text.regular,
                            color = ShopXpressTheme.colors.text_60
                        )

                        Text(
                            text = price,
                            style = ShopXpressTheme.typography.main_text.extraBold,
                            color = ShopXpressTheme.colors.text_80
                        )

                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.End
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.favorite),
                            contentDescription = ""
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable {
                                        if (count.value > 1) {
                                            count.value -= 1
                                        } else {
                                            showDelete = true
                                        }
                                    }
                                    .border(2.dp, ShopXpressTheme.colors.primary)
                                    .size(24.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.minus),
                                    contentDescription = "minus",
                                    modifier = Modifier
                                        .size(11.dp)
                                )
                            }

                            Text(
                                text = count.value.toString(),
                                style = ShopXpressTheme.typography.main_text.bold,
                                color = ShopXpressTheme.colors.text_100
                            )

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable {
                                        if (count.value < 9 && showDelete == false) {
                                            count.value += 1
                                        }
                                        if (showDelete == true) {
                                            showDelete = false
                                        }
                                    }
                                    .border(2.dp, ShopXpressTheme.colors.primary)
                                    .size(24.dp),

                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.plus),
                                    contentDescription = "add",
                                    modifier = Modifier
                                        .size(11.dp)
                                )
                            }

                        }

                    }

                }

            }

    }
}

@Composable
@Preview
private fun CartItemPreview() {

    val list = CartData(
        R.drawable.shirt,
        "H&M Quality Shirt",
        "Size: L",
        "N13,500"
    )


    ShopXpressTheme {
        CartItem(
                R.drawable.shirt,
            "H&M Quality Shirt",
            "Size: L",
            "N13,500",
            {}
        )
    }

}