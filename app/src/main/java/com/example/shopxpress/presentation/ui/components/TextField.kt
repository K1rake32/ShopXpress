package com.example.shopxpress.presentation.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.modifier.ModifierLocalModifierNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.screens.auth.Signup.components.MaskVisualTransformation
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import com.example.shopxpress.presentation.ui.style.color.ShopXpressColors
import com.example.shopxpress.presentation.ui.style.typography.ShopXpressFont
import com.example.shopxpress.presentation.ui.style.typography.ShopXpressTypography
import com.example.shopxpress.util.SearchObject

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

                keyboardOptions = when {
                    isNumber -> KeyboardOptions(keyboardType = KeyboardType.Phone)
                    isPassword -> KeyboardOptions(keyboardType = KeyboardType.Password)
                    else -> KeyboardOptions(keyboardType = KeyboardType.Email)
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
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,

        modifier = modifier,

        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = bcg,
            unfocusedContainerColor = bcg,
            unfocusedBorderColor = borderColor,
            focusedBorderColor = borderColor,
        ),

        placeholder = {
            Text(
                text = placeholder,
                style = styleText,
                color = textColor
            )
        },

        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,

        leadingIcon = {
            Icon(
                painter = painterResource(id = startIcon),
                contentDescription = "start_icon",
            )
        },

        shape = shape,

        singleLine = true
    )

}

@Composable
fun PinTextField(
    number: Int?,
    focusRequester: FocusRequester,
    onFocusChanged: (Boolean) -> Unit,
    onNumberChanged: (Int?) -> Unit,
    onKeyboardBack: () -> Unit,
    modifier: Modifier = Modifier,
    borderColor: Color = ShopXpressTheme.colors.text_20,
    bcg: Color = ShopXpressTheme.colors.bcg_0,
    cursorColor: Color = ShopXpressTheme.colors.text_100,
    textStyle: TextStyle = ShopXpressTheme.typography.title.bold,
    keyboardType: KeyboardType = KeyboardType.Number
) {

    val text by remember(number) {

        mutableStateOf(
            TextFieldValue (
                text = number?.toString().orEmpty(),
                selection = TextRange(
                    index = if(number != null) 1 else 0
                )
            )
        )

    }

    var isFocused by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .border(1.dp, borderColor, CircleShape)
            .background(bcg)
            .size(70.dp),

        contentAlignment = Alignment.Center
    ) {

        BasicTextField(
            value = text,
            onValueChange = { newText ->
                val newNumber = newText.text
                if (newNumber.length <= 1 && newNumber.isDigitsOnly()) {
                    onNumberChanged(newNumber.toIntOrNull())
                }
            },
            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.lato_bold)),
                fontSize = 24.sp,
                color = cursorColor
            ),

            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),

            modifier = Modifier
                .padding(10.dp)
                .focusRequester(focusRequester)
                .onFocusChanged {
                    isFocused = it.isFocused
                    onFocusChanged(it.isFocused)
                }
                .onKeyEvent { event ->
                    val didPressDelete =
                        event.nativeKeyEvent.keyCode == android.view.KeyEvent.KEYCODE_DEL
                    if (didPressDelete && number == null) {
                        onKeyboardBack()
                    }
                    false
                },
            decorationBox =  { innerBox ->
                innerBox()
                if(!isFocused && number == null) {
                    Text(
                        text = "-",
                        style = textStyle,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                    )
                }
            }
        )

    }

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


            
            PinTextField(
                number = null,
                focusRequester = remember {FocusRequester()},
                onFocusChanged = {},
                onNumberChanged = {},
                onKeyboardBack = { /*TODO*/ }

            )

        }

    }

}