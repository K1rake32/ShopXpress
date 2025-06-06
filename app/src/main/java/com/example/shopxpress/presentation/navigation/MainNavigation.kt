package com.example.shopxpress.presentation.navigation

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.presentation.navigation.bottomNavigation.BottomNavigation
import com.example.shopxpress.presentation.ui.screens.auth.Login.LoginView
import com.example.shopxpress.presentation.ui.screens.auth.interest.InterestView
import com.example.shopxpress.presentation.ui.screens.auth.Signup.SignUpView
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpViewModel
import com.example.shopxpress.presentation.ui.screens.auth.verification.VerificationView
import com.example.shopxpress.presentation.ui.screens.main.cart.CartScreen
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.CartView
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.ui.CartViewModel
import com.example.shopxpress.presentation.ui.screens.main.categories.category.CategoryView
import com.example.shopxpress.presentation.ui.screens.main.home.detail.DetailProductView
import com.example.shopxpress.presentation.ui.screens.main.home.home.HomeScreen
import com.example.shopxpress.presentation.ui.screens.main.home.resultSearch.ResultSearchView
import com.example.shopxpress.presentation.ui.screens.main.home.search.SearchView
import com.example.shopxpress.presentation.ui.screens.main.profile.profile.ProfileView
import com.example.shopxpress.presentation.ui.screens.main.profile.profileunaUthorized.ProfileUnauthorized
import com.example.shopxpress.presentation.ui.screens.onboarding.ui.FinalOnboarding
import com.example.shopxpress.presentation.ui.screens.onboarding.ui.OnboardingScreen


sealed class Screens(val route: String) {

    object Onboarding: Screens("onboarding_screen")
    object FinalOnboarding: Screens("final_onboarding_screen")

    object SignUp: Screens("sign_up")

    object Login: Screens ("login")
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
    object  ProfileUnAuth: Screens("profile_un_auth_screen")

    object CategoryView: Screens("category_screen")

    object  CartView: Screens("cart_screen")


}

/*
@Composable
fun AppNavHost(navController: NavHostController) {

    val cartViewModel: CartViewModel = viewModel()

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = navController.currentBackStackEntryAsState().value?.destination?.route in listOf(
                    Screens.HomeView.route,
                    Screens.CategoryView.route,
                    Screens.ProfileView.route,
                    Screens.CartView.route,
                    Screens.ProfileUnAuth.route
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
                    },
                    toLogin = {
                        navController.navigate(Screens.Login.route)
                    }
                )
            }

            composable(Screens.SignUp.route) {
                SignUpView(
                    navigationVerification = {
                        navController.navigate(Screens.VerificationScreen.route)
                    },
                    toLogin = {
                        navController.navigate(Screens.Login.route)
                    }
                )
            }

            composable(Screens.Login.route) {
                LoginView(
                    toHome = {
                        navController.navigate(Screens.HomeView.route)
                    },
                    toSignUp = {
                        navController.navigate(Screens.SignUp.route)
                    }
                )
            }

            composable(Screens.VerificationScreen.route) {
                VerificationView(
                    toInterest = {
                        navController.navigate(Screens.InterestScreen.route)
                    }
                )
            }

            composable(Screens.InterestScreen.route) {
                InterestView(
                    toHome = {
                        navController.navigate(Screens.HomeView.route)
                    }
                )
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
                        cartViewModel = cartViewModel,
                        toCart = {
                            navController.navigate(Screens.CartView.route)
                        }
                    )
                }
            }

            composable(Screens.ProfileView.route) {
                ProfileView()
            }

            composable(Screens.ProfileUnAuth.route) {
                ProfileUnauthorized()
            }

            composable(Screens.CartView.route) {
                CartScreen(
                    cartViewModel,
                    toShopping = {
                        navController.navigate(Screens.HomeView.route)
                    }
                    )
            }
        }

    }

}*/
