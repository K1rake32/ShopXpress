package com.example.shopxpress.presentation.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.modifier.ModifierLocalModifierNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.screens.auth.Signup.components.MaskVisualTransformation
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import com.example.shopxpress.presentation.ui.style.typography.ShopXpressFont
import com.example.shopxpress.presentation.ui.style.typography.ShopXpressTypography

@Composable
fun AuthTextField(
    text: String,
    onValueChange: (String) -> Unit,
    shape: RoundedCornerShape = RoundedCornerShape(50.dp),
    cursorColor: Color = ShopXpressTheme.colors.text_100,
    bcg: Color = ShopXpressTheme.colors.bcg_0,
    label: String? = "",
    placeholder: String = "",
    modifier: Modifier = Modifier,
    styleLabel: TextStyle = ShopXpressTheme.typography.little_text.extraBold,
    borderColor: Color = ShopXpressTheme.colors.text_20,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isPassword: Boolean = false,
    @DrawableRes iconEnd: Int? = null,
    @DrawableRes iconEndAlt: Int? = null,
    isHideText: Boolean = true,
    isNumber: Boolean = false
) {

    val mask = MaskVisualTransformation("+7 (###) ###-##-##")

    var isTextVisible by remember { mutableStateOf(false)}

    Column(
    ) {

        label?.let {

            Text(
                text = label,
                style = styleLabel
            )

        }
        
        Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(

                modifier = modifier
                    .fillMaxWidth()
                    .height(60.dp),

                value = text,
                onValueChange = onValueChange,
                shape = shape,

                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = cursorColor,
                    focusedBorderColor = borderColor,
                    unfocusedBorderColor = borderColor
                ),

                placeholder = {
                    Text(
                        text = placeholder,
                        style = styleLabel,
                    )
                },

                singleLine = true,

                visualTransformation = when {
                    isPassword && !isTextVisible -> PasswordVisualTransformation()
                    isNumber -> mask
                    else -> visualTransformation
                },

                trailingIcon = {

                    if (isPassword) {

                        IconButton(
                            onClick = { isTextVisible = !isTextVisible },
                            modifier = Modifier.padding(end = 8.dp)
                        ) {

                            val icon = if(isTextVisible) R.drawable.hide_text else R.drawable.hide_text

                            Image(

                                painter = painterResource(id = icon),
                                contentDescription = ""

                            )

                        }
                    }

                },
            )
    }

}

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    shape: RoundedCornerShape = RoundedCornerShape(20.dp),
    modifier: Modifier = Modifier,
    @DrawableRes startIcon: Int,
    placeholder: String = "",
    bcg: Color = ShopXpressTheme.colors.bcg_100,
    styleText: TextStyle = ShopXpressTheme.typography.textField_Text.regular,
    textColor: Color = ShopXpressTheme.colors.text_40,
    cursorColor: Color = ShopXpressTheme.colors.text_100,
    borderColor: Color = ShopXpressTheme.colors.text_20,
    label: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier,

        placeholder = {

            Text(
                text = placeholder,
                style = styleText,
                color = textColor
            )

        },
        
        shape = shape,

        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = cursorColor,
            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,
            focusedContainerColor = bcg,
            unfocusedContainerColor = bcg
        ),

        leadingIcon = {

            Icon(
                painter = painterResource(id = startIcon),
                contentDescription = "search"
            )

        },

        visualTransformation = visualTransformation,

        keyboardOptions = keyboardOptions,

        keyboardActions = keyboardActions

    )

}

@Composable
@Preview(showBackground = true)
private fun AuthTextFieldPreview() {

    var text by remember { mutableStateOf("")}

    ShopXpressTheme {

        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {

            AuthTextField(
                text = text,
                onValueChange = {text = it},
                label = "Preview"
            )

            SearchTextField(
                value = text,
                onValueChange = {},
                placeholder = "Preview",
                startIcon = R.drawable.search
            )

        }

    }

}