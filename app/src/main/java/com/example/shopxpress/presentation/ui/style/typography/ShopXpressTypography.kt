package com.example.shopxpress.presentation.ui.style.typography

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.shopxpress.R

@Immutable
data class ShopXpressTypography(

    val title: ShopXpressFont,
    val main_text: ShopXpressFont,
    val navigation_text: ShopXpressFont,
    val button_text: ShopXpressFont,
    val little_text: ShopXpressFont,
    val medium_text: ShopXpressFont,
    val textField_Text: ShopXpressFont,
    val minor_text: ShopXpressFont

)

private val ShopFontFamily = FontFamily(
    Font(R.font.lato_bold, FontWeight.W700),
    Font(R.font.lato_extrabold, FontWeight.W900),
    Font(R.font.lato_regular, FontWeight.W400)
)

@Immutable
class ShopXpressFont (
    fontSize:TextUnit,
    lineHeight:TextUnit
) {

    val regular = TextStyle (
        fontFamily = ShopFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

    val bold = TextStyle (
        fontFamily = ShopFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = fontSize,
        lineHeight = lineHeight,
    )

    val extraBold = TextStyle (
        fontFamily = ShopFontFamily,
        fontWeight = FontWeight.W900,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

}

val LocalShopXpres = ShopXpressTypography (

    title = ShopXpressFont(
        fontSize = 28.sp,
        lineHeight = 32.sp
    ),

    main_text = ShopXpressFont(
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),

    navigation_text = ShopXpressFont(
        fontSize = 16.sp,
        lineHeight = 16.sp
    ),

    button_text = ShopXpressFont(
        fontSize = 20.sp,
        lineHeight = 20.sp
    ),

    little_text = ShopXpressFont(
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),

    medium_text = ShopXpressFont(
        fontSize = 24.sp,
        lineHeight = 24.sp
    ),

    textField_Text = ShopXpressFont(
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),

    minor_text = ShopXpressFont(
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
)

val LocalShopPressTypography = staticCompositionLocalOf<ShopXpressTypography> {
    error("No typography provided")
}