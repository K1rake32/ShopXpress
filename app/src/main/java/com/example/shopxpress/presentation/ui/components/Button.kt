package com.example.shopxpress.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun DefaultButton(
    onclick: () -> Unit,
    text: String,
    background: Color = ShopXpressTheme.colors.primary,
    clip: RoundedCornerShape = RoundedCornerShape(10.dp),
    modifier: Modifier = Modifier,
    textColor: Color = ShopXpressTheme.colors.text_0,
    style: TextStyle = ShopXpressTheme.typography.button_text.bold
) {

    Button(
        onClick = onclick,
        modifier = modifier,

        colors = ButtonDefaults.buttonColors(
            containerColor = background
        )
    ) {

        Text(
            modifier = Modifier
                .padding(vertical = 10.dp),
            text = text,
            style = style,
            color = textColor
        )

    }

}

@Composable
fun TextBackButton(
    onclick: () -> Unit,
    text: String,
    style: TextStyle,
    color: Color,
    modifier: Modifier = Modifier
) {

    TextButton(
        onClick = onclick
    ) {

        Text(
            text = text,
            style = style,
            color = color
        )
        
    }

}

@Composable
fun OutlinedDefaultButton(
    onclick: () -> Unit,
    text: String,
    outlinedColor: Color = ShopXpressTheme.colors.primary,
    modifier: Modifier = Modifier,
    style: TextStyle = ShopXpressTheme.typography.button_text.bold,
    isImage: Boolean = false,
    icon: ImageVector = Icons.Outlined.FavoriteBorder,
    tint: Color = ShopXpressTheme.colors.primary
) {

    OutlinedButton(
        border = BorderStroke(1.dp, outlinedColor),
        onClick = onclick,
        modifier = modifier
    ) {

        if(isImage) {

            Box(
                modifier = Modifier
                    .padding(vertical = 7.7.dp)

            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "favorite",
                    tint = tint,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        } else {

            Text(
                modifier = Modifier
                    .padding(vertical = 10.dp),
                text = text,
                style = style,
                color = outlinedColor
            )

        }

    }

}

@Composable
fun InCartButton(
    bcg: Color = ShopXpressTheme.colors.primary,
    mainTextColor: Color = ShopXpressTheme.colors.bcg_0,
    minorTextColor: Color = ShopXpressTheme.colors.text_40,
    shape: RoundedCornerShape = RoundedCornerShape(48.dp),
    modifier: Modifier = Modifier,
    removeItem: () -> Unit,
    addItem: () -> Unit,
    count: String
) {

    Box(
        modifier = Modifier
            .width(215.dp)
            .height(60.dp)
            .clip(shape)
            .background(bcg),

        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {removeItem()}
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = "remove",
                    tint = ShopXpressTheme.colors.bcg_0
                )

            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Text(
                    text = count,
                    style = ShopXpressTheme.typography.main_text.bold,
                    color = mainTextColor
                )

                Text(
                    text = "In cart",
                    style = ShopXpressTheme.typography.textField_Text.bold,
                    color = minorTextColor
                )

            }

            IconButton(
                onClick = {addItem()}
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "remove",
                    tint = ShopXpressTheme.colors.bcg_0
                )

            }

        }

    }

}

@Composable
fun SegmentedControl(
    options: List<String>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .background(
                color = ShopXpressTheme.colors.bcg_0,
                shape = RoundedCornerShape(50)
            )
            .padding(4.dp)
            .height(40.dp)
    ) {
        options.forEachIndexed { index, option ->
            val isSelected = index == selectedIndex
            val backgroundColor = if (isSelected) ShopXpressTheme.colors.primary else ShopXpressTheme.colors.bcg_100
            val textColor = if (isSelected) Color.White else ShopXpressTheme.colors.primary

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(50))
                    .background(backgroundColor)
                    .clickable { onOptionSelected(index) }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = option,
                    color = textColor,
                    style = ShopXpressTheme.typography.main_text.bold
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ButtonPreview() {
    ShopXpressTheme {

        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            DefaultButton(
                onclick = {},
                text = "Preview",
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedDefaultButton(
                onclick = {},
                text = "Preview",
                modifier = Modifier
                    .fillMaxWidth()
            )

            TextBackButton(
                onclick = {},
                text = "Preview",
                style = ShopXpressTheme.typography.main_text.bold,
                color = ShopXpressTheme.colors.text_100
            )

            InCartButton(removeItem = {}, addItem = {}, count = "")

        }

    }
}
