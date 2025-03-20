package com.example.shopxpress.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import org.w3c.dom.Text

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
    color: Color
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
) {

    OutlinedButton(
        border = BorderStroke(1.dp, outlinedColor),
        onClick = onclick,
        modifier = modifier
    ) {

        Text(
            modifier = Modifier
                .padding(vertical = 10.dp),
            text = text,
            style = style,
            color = outlinedColor
        )

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

        }

    }
}
