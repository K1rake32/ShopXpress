package com.example.shopxpress.presentation.navigation

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.presentation.navigation.bottomNavigation.BottomNavigation
import com.example.shopxpress.presentation.ui.screens.auth.interest.InterestView
import com.example.shopxpress.presentation.ui.screens.auth.Signup.SignUpView
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpViewModel
import com.example.shopxpress.presentation.ui.screens.auth.verification.VerificationView
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.CartView
import com.example.shopxpress.presentation.ui.screens.main.categories.category.CategoryView
import com.example.shopxpress.presentation.ui.screens.main.home.detail.DetailProductView
import com.example.shopxpress.presentation.ui.screens.main.home.home.HomeScreen
import com.example.shopxpress.presentation.ui.screens.main.home.resultSearch.ResultSearchView
import com.example.shopxpress.presentation.ui.screens.main.home.search.SearchView
import com.example.shopxpress.presentation.ui.screens.main.profile.profile.ProfileView
import com.example.shopxpress.presentation.ui.screens.onboarding.ui.FinalOnboarding
import com.example.shopxpress.presentation.ui.screens.onboarding.ui.OnboardingScreen


sealed class Screens(val route: String) {

    object Onboarding: Screens("onboarding_screen")
    object FinalOnboarding: Screens("final_onboarding_screen")

    object SignUp: Screens("sign_up")
    object VerificationScreen: Screens("verification_screen")

    object InterestScreen: Screens("interest_screen")

    object HomeView: Screens("home_screen/{product_id}") {
        fun createRoute(product: Int) = "home_screen/$product"
    }

    object SearchView: Screens("search_screen")

    object SearchResultView: Screens("search_result_screen/{query}") {
        fun passQuery(query: String): String {
            return "search_result_screen/$query"
        }
    }
    object DetailProduct: Screens("detail_product")

    object ProfileView: Screens("profile_screen")

    object CategoryView: Screens("category_screen")

    object  CartView: Screens("cart_screen")


}

@Composable
fun AppNavHost(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = navController.currentBackStackEntryAsState().value?.destination?.route in listOf(
                    Screens.HomeView.route,
                    Screens.CategoryView.route,
                    Screens.ProfileView.route,
                    Screens.CartView.route
                ),
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                BottomNavigation(navController = navController)
            }
        }
    ) { innerPadding ->

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
                    navigationVerification = {
                        navController.navigate(Screens.VerificationScreen.route)
                    }
                )
            }

            composable(Screens.VerificationScreen.route) {
                VerificationView()
            }

            composable(Screens.InterestScreen.route) {
                InterestView()
            }


            composable(Screens.HomeView.route) { navBackStackEntry ->
                HomeScreen(
                    navController = navController,
                    toDetail = {
                        navController.navigate(Screens.DetailProduct.route)
                    },
                    toSearch = {
                        navController.navigate(Screens.SearchView.route)
                    }
                )
            }

            composable(Screens.SearchView.route) {
                SearchView(
                    toDetailSearch = { query ->
                        navController.navigate(Screens.SearchResultView.passQuery(query))
                    }
                )
            }

            composable(
                route = Screens.SearchResultView.route,
                arguments = listOf(
                    navArgument("query") {type = NavType.StringType}
                )
            ) { backStackEntry ->

                val query = backStackEntry.arguments?.getString("query") ?: ""

                ResultSearchView(
                    query = query,
                    navController = navController
                )
            }

            composable(Screens.CategoryView.route) {
                CategoryView()
            }

            composable(Screens.DetailProduct.route) { backStackEntry ->
                val product = navController.previousBackStackEntry?.savedStateHandle?.get<ProductData>("product")
                if(product != null) {
                    DetailProductView(
                        product = product,
                    )
                }
            }

            composable(Screens.ProfileView.route) {
                ProfileView()
            }

            composable(Screens.CartView.route) {
                CartView()
            }
        }

    }

}