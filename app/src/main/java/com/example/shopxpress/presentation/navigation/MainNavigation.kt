package com.example.shopxpress.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shopxpress.presentation.shimmer.HomeShimmer
import com.example.shopxpress.presentation.ui.screens.auth.Signup.SignUpView
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpViewModel
import com.example.shopxpress.presentation.ui.screens.auth.interest.InterestView
import com.example.shopxpress.presentation.ui.screens.auth.verification.VerificationView
import com.example.shopxpress.presentation.ui.screens.main.home.HomeScreen
import com.example.shopxpress.presentation.ui.screens.main.home.HomeView
import com.example.shopxpress.presentation.ui.screens.onboarding.ui.FinalOnboarding
import com.example.shopxpress.presentation.ui.screens.onboarding.ui.OnboardingScreen
import kotlinx.coroutines.delay

sealed class Screens(val route: String) {

    object Onboarding: Screens("onboarding_screen")
    object FinalOnboarding: Screens("final_onboarding_screen")

    object SignUp: Screens("sign_up")
    object VerificationScreen: Screens("verification_screen")

    object InterestScreen: Screens("interest_screen")

    object HomeView: Screens("home_screen")


}

@Composable
fun AppNavHost(navController: NavHostController) {

    Scaffold() { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screens.HomeView.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Screens.Onboarding.route) {
                OnboardingScreen (
                    onFinished = {
                        navController.navigate(Screens.FinalOnboarding.route)
                    }
                )
            }

            composable(Screens.FinalOnboarding.route) {
                FinalOnboarding(
                    onSignUp = {
                        navController.navigate(Screens.SignUp.route)
                    }
                )
            }

            composable(Screens.SignUp.route) {
                SignUpView(
                    signViewModel = SignUpViewModel(),
                )
            }

            composable(Screens.VerificationScreen.route) {

            }

            composable(Screens.InterestScreen.route) {
                InterestView()
            }


            composable(Screens.HomeView.route) {
                HomeScreen()
            }
        }

    }

}