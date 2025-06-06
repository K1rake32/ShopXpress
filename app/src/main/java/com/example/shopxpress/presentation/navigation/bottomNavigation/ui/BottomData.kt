package com.example.shopxpress.presentation.navigation.bottomNavigation.ui

import android.provider.DocumentsContract.Root
import com.example.shopxpress.presentation.navigation.component.RootComponent
import com.example.shopxpress.presentation.navigation.component.ScreenConfig

data class BottomData(
    val screen: ScreenConfig,
    val unSelectedImage: Int,
    val title: String,
    val selectedImage: Int
)