package com.example.shopxpress.presentation.ui.style.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ShopXpressColors(

    val primary: Color,

    val accent_0: Color,
    val accent_20: Color,
    val accent_40: Color,
    val accent_60: Color,
    val accent_80: Color,
    val accent_100: Color,

    val text_0: Color,
    val text_20: Color,
    val text_40: Color,
    val text_60: Color,
    val text_80: Color,
    val text_100: Color,

    val bcg_0: Color,
    val bcg_100: Color,

    val other_0: Color,

    val bright_0: Color,
    val bright_10: Color,
    val bright_20: Color,

    val red_delete: Color

)

val LocalColorMainError = staticCompositionLocalOf<ShopXpressColors> {
    error("no colors provided")
}