package com.example.shopxpress.presentation.ui.style

import android.os.Build
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import com.example.shopxpress.presentation.ui.style.color.LocalColorMainError
import com.example.shopxpress.presentation.ui.style.color.ShopXpressColors
import com.example.shopxpress.presentation.ui.style.color.darkPalette
import com.example.shopxpress.presentation.ui.style.color.lightPalette
import com.example.shopxpress.presentation.ui.style.typography.LocalShopPressTypography
import com.example.shopxpress.presentation.ui.style.typography.LocalShopXpres
import com.example.shopxpress.presentation.ui.style.typography.ShopXpressFont
import com.example.shopxpress.presentation.ui.style.typography.ShopXpressTypography


@Composable
fun ShopXpressTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val palette = if(darkTheme) darkPalette else lightPalette
    val rippleIndication = rememberRipple()

    CompositionLocalProvider (
        LocalColorMainError provides palette,
        LocalShopPressTypography provides LocalShopXpres,
        LocalIndication provides rippleIndication,
        content = content
    )

}

object ShopXpressTheme {

    val colors: ShopXpressColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorMainError.current

    val typography: ShopXpressTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalShopPressTypography.current

}
