package com.example.shopxpress.presentation.ui.screens.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.presentation.ui.components.TextBackButton
import com.example.shopxpress.presentation.ui.screens.onboarding.OnboardingModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun OnBoardingGraphUI(
    onboardingModel: OnboardingModel,
    clickable: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(650.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            TextBackButton(
                onclick = {clickable()},
                text = "Skip",
                style = ShopXpressTheme.typography.main_text.bold,
                color = ShopXpressTheme.colors.text_100,
            )
        }

        Spacer(modifier = Modifier.height(70.dp))

        Image(
            painter = painterResource(id = onboardingModel.image),
            contentDescription = "image"
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            modifier = Modifier
                .padding(bottom = 20.dp),
            text = onboardingModel.title,
            style = ShopXpressTheme.typography.title.bold,
            color = ShopXpressTheme.colors.text_100,
            textAlign = TextAlign.Center
        )

        Text(
            text = onboardingModel.text,
            style = ShopXpressTheme.typography.main_text.regular,
            color = ShopXpressTheme.colors.text_100,
            textAlign = TextAlign.Center
        )



    }

}

@Composable
@Preview(showBackground = true)
private fun OnBoardingGraphUI1() {
    OnBoardingGraphUI(onboardingModel = OnboardingModel.FirstPage, {})
}

@Composable
@Preview(showBackground = true)
private fun OnBoardingGraphUI2() {
    OnBoardingGraphUI(onboardingModel = OnboardingModel.SecondPage, {})
}

@Composable
@Preview(showBackground = true)
private fun OnBoardingGraphUI3() {
    OnBoardingGraphUI(onboardingModel = OnboardingModel.ThirdPage, {})
}

@Composable
@Preview(showBackground = true)
private fun OnBoardingGraphUI4() {
    OnBoardingGraphUI(onboardingModel = OnboardingModel.FourthPage, {})
}