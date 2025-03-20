package com.example.shopxpress.presentation.ui.screens.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.example.shopxpress.R

sealed class OnboardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val text: String
) {

    data object FirstPage: OnboardingModel (
        image = R.drawable.page_first,
        title = "Welcome to shopXpress!",
        text = "A shopping app that feels like home, every\nexperience curated to delight you."
    )

    data object SecondPage: OnboardingModel (
        image = R.drawable.page_second,
        title = "Create your own wishlists",
        text = "Customize up to 3 wishlists where you can add\nyour favourite items to."
    )

    data object ThirdPage: OnboardingModel (
        image = R.drawable.page_third,
        title = "Shop for your loved ones",
        text = "Show love and gratitude by having your orders\ndelivered directly to your friends as a present."
    )

    data object FourthPage: OnboardingModel (
        image = R.drawable.page_fourth,
        title = "Eqweqeqeqewqewqe",
        text = "eqweqqeqeqeqewqeqeqewq"
    )

}