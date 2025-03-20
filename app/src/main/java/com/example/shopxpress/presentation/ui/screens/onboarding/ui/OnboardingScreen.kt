package com.example.shopxpress.presentation.ui.screens.onboarding.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.screens.onboarding.OnboardingModel
import com.example.shopxpress.presentation.ui.screens.onboarding.components.IndicatorUI
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(onFinished: () -> Unit) {

    val pages = listOf(
        OnboardingModel.FirstPage,
        OnboardingModel.SecondPage,
        OnboardingModel.ThirdPage,
    )

    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }

    val scope = rememberCoroutineScope()

    val buttonState: () -> Unit = {
        scope.launch {
            if (pagerState.currentPage < pages.size - 1) {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            } else {
                onFinished()
            }
        }
    }
    

    Column(

        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        HorizontalPager(state = pagerState) { index ->
            OnBoardingGraphUI(onboardingModel = pages[index])
        }

        Spacer(modifier = Modifier.height(10.dp))

        IndicatorUI(
            pageSize = pages.size,
            currentPage = pagerState.currentPage
        )
        
        Spacer(modifier = Modifier.height(60.dp))

        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),

            onclick = buttonState,
            text = if(pagerState.currentPage == 0) "Get started" else "Next",
        )

    }
    

}

@Composable
@Preview(showBackground = true)
private fun OnboardingScreenPreview() {

    ShopXpressTheme{
        OnboardingScreen({})
    }

}