package com.example.shopxpress.presentation.navigation.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.example.shopxpress.presentation.navigation.bottomNavigation.BottomNavigation
import com.example.shopxpress.presentation.navigation.component.RootComponent
import com.example.shopxpress.presentation.navigation.component.ScreenConfig
import com.example.shopxpress.presentation.ui.screens.auth.Login.LoginView
import com.example.shopxpress.presentation.ui.screens.auth.Signup.SignUpView
import com.example.shopxpress.presentation.ui.screens.auth.interest.InterestView
import com.example.shopxpress.presentation.ui.screens.auth.verification.VerificationView
import com.example.shopxpress.presentation.ui.screens.main.cart.CartScreen
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.CartView
import com.example.shopxpress.presentation.ui.screens.main.cart.cart.ui.CartViewModel
import com.example.shopxpress.presentation.ui.screens.main.categories.category.CategoryView
import com.example.shopxpress.presentation.ui.screens.main.home.detail.DetailProductView
import com.example.shopxpress.presentation.ui.screens.main.home.home.HomeScreen
import com.example.shopxpress.presentation.ui.screens.main.profile.profile.ProfileView
import com.example.shopxpress.presentation.ui.screens.onboarding.ui.FinalOnboarding
import com.example.shopxpress.presentation.ui.screens.onboarding.ui.OnboardingScreen

@Composable
fun RootContent(component: RootComponent) {
    val stack by component.childStack.subscribeAsState()
    val activeConfig = stack.active.configuration
    val showBottomBar= shouldShowBottomBar(activeConfig)

    val cartViewModel: CartViewModel = viewModel()

    Scaffold(
        bottomBar ={
            if(showBottomBar) {
                BottomNavigation(
                    current = activeConfig,
                    onTabSelected = component::onTabSelected
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Children(stack = component.childStack) {
                when (val child = it.instance) {
                    is RootComponent.Child.OnBoarding -> OnboardingScreen({}, child.component)
                    is RootComponent.Child.FinalOnBoarding -> FinalOnboarding({}, {}, child.component)
                    is RootComponent.Child.SignUp -> SignUpView(navigationVerification = {}, toLogin = {}, component = child.component)
                    is RootComponent.Child.Login -> LoginView(component = child.component)
                    is RootComponent.Child.Verification -> VerificationView(component = child.component)
                    is RootComponent.Child.Interest -> InterestView( component = child.component)
                    is RootComponent.Child.Home -> HomeScreen(toDetail = {}, toSearch = { /*TODO*/ }, component = child.component)
                    is RootComponent.Child.Category -> CategoryView(component = child.component)
                    is RootComponent.Child.Profile -> ProfileView(component = child.component)
                    is RootComponent.Child.Cart -> CartScreen(toShopping = {}, viewModel = cartViewModel, component = child.component)
                    is RootComponent.Child.Detail -> DetailProductView(product = child.component.product, cartViewModel = cartViewModel, component = child.component)
                }
            }
        }
    }
}

fun shouldShowBottomBar(config: ScreenConfig): Boolean {
    return config is ScreenConfig.HomeScreen ||
            config is ScreenConfig.CategoryScreen ||
            config is ScreenConfig.ProfileScreen ||
            config is ScreenConfig.CartScreen
}