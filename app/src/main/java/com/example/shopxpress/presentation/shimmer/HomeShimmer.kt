package com.example.shopxpress.presentation.shimmer

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun HomeShimmer() {

    val shimmerColors = listOf(
        Color.LightGray.copy(0.6f),
        Color.LightGray.copy(0.2f),
        Color.LightGray.copy(0.6f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )

    ShimmerGridItem(brush = brush)

}

@Composable
fun ShimmerGridItem(brush: Brush) {

    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(brush)
                )

                Spacer(modifier = Modifier.width(14.dp))

                Box(
                    modifier = Modifier
                        .height(23.dp)
                        .width(106.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(brush)
                )

            }

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(brush)
            )

        }

        Row(
            modifier = Modifier
                .padding(vertical = 24.dp),

            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .width(283.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(brush)
            )
            
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(brush)
            )
        }
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .width(165.dp)
                        .height(192.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )

                Box(
                    modifier = Modifier
                        .width(165.dp)
                        .height(192.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .width(165.dp)
                        .height(192.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )

                Box(
                    modifier = Modifier
                        .width(165.dp)
                        .height(192.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )

            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .width(165.dp)
                        .height(192.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )

                Box(
                    modifier = Modifier
                        .width(165.dp)
                        .height(192.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )

            }

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun HomeShimmerPreview() {

    ShopXpressTheme {
        HomeShimmer()
    }

}