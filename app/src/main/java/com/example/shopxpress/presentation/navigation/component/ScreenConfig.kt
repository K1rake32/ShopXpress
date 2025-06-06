package com.example.shopxpress.presentation.navigation.component

import android.os.Parcelable
import com.arkivanov.decompose.router.stack.ChildStack
import com.example.shopxpress.presentation.data.ProductData
import kotlinx.parcelize.Parcelize

sealed class ScreenConfig : Parcelable {

    @Parcelize
    object Onboarding: ScreenConfig()
    @Parcelize
    object FinalOnboarding: ScreenConfig()
    @Parcelize
    object SignUp: ScreenConfig()
    @Parcelize
    object Login: ScreenConfig()
    @Parcelize
    object VerificationScreen: ScreenConfig()
    @Parcelize
    object InterestScreen: ScreenConfig()
    @Parcelize
    object HomeScreen: ScreenConfig()

    @Parcelize
    object CategoryScreen: ScreenConfig()

    @Parcelize
    object ProfileScreen: ScreenConfig()

    @Parcelize
    object CartScreen: ScreenConfig()

    @Parcelize
    data class Detail(val product: ProductData) : ScreenConfig()

}

interface RootComponent {
    val childStack: com.arkivanov.decompose.value.Value<ChildStack<ScreenConfig, Child>>

    fun onTabSelected(config: ScreenConfig)

    sealed class Child {

        class OnBoarding(val component: DefaultOnboardingComponent) : Child()
        class FinalOnBoarding(val component: DefaultFinalOnboardingComponent) : Child()
        class SignUp(val component: DefaultSignUpComponent) : Child()
        class Login(val component: DefaultLoginComponent) : Child()
        class Verification(val component: DefaultVerifyComponent) : Child()
        class Interest(val component: DefaultInterestComponent) : Child()
        class Home(val component: DefaultHomeComponent) : Child()
        class Category(val component: DefaultCategoryComponent) : Child()
        class Profile(val component: DefaultProfileComponent) : Child()
        class Cart(val component: DefaultCartComponent) : Child()
        class Detail(val component: DefaultDetailComponent) : Child()
    }
}

