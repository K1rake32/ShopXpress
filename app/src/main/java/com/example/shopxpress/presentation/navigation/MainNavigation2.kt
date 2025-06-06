package com.example.shopxpress.presentation.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.example.shopxpress.presentation.navigation.component.DefaultCartComponent
import com.example.shopxpress.presentation.navigation.component.DefaultCategoryComponent
import com.example.shopxpress.presentation.navigation.component.DefaultDetailComponent
import com.example.shopxpress.presentation.navigation.component.DefaultFinalOnboardingComponent
import com.example.shopxpress.presentation.navigation.component.DefaultHomeComponent
import com.example.shopxpress.presentation.navigation.component.DefaultInterestComponent
import com.example.shopxpress.presentation.navigation.component.DefaultLoginComponent
import com.example.shopxpress.presentation.navigation.component.DefaultOnboardingComponent
import com.example.shopxpress.presentation.navigation.component.DefaultProfileComponent
import com.example.shopxpress.presentation.navigation.component.DefaultSignUpComponent
import com.example.shopxpress.presentation.navigation.component.DefaultVerifyComponent
import com.example.shopxpress.presentation.navigation.component.RootComponent
import com.example.shopxpress.presentation.navigation.component.ScreenConfig

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<ScreenConfig>()

    override val childStack: Value<ChildStack<ScreenConfig, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = ScreenConfig.Onboarding,
            childFactory = ::createChild
        )

    override fun onTabSelected(config: ScreenConfig) {
        navigation.bringToFront(config)
    }

    private fun createChild(
        config: ScreenConfig,
        context: ComponentContext
    ): RootComponent.Child =
        when (config) {
            ScreenConfig.Onboarding -> RootComponent.Child.OnBoarding(
                DefaultOnboardingComponent(
                    context,
                    toFinalOnBoarding = {
                        navigation.push(ScreenConfig.FinalOnboarding)
                    },
                    onBack = {
                        navigation.pop()
                    }
                )


            )

            ScreenConfig.FinalOnboarding -> RootComponent.Child.FinalOnBoarding(
                DefaultFinalOnboardingComponent(
                    context,
                    toSignUpCallback = {
                        navigation.push(ScreenConfig.SignUp)
                    },
                    onBack = {
                        navigation.pop()
                    },
                    toLoginCallback = {
                        navigation.push(ScreenConfig.Login)
                    }
                )
            )

            ScreenConfig.SignUp -> RootComponent.Child.SignUp(
                DefaultSignUpComponent(
                    context,
                    toVerifyCallback = {
                        navigation.push(ScreenConfig.VerificationScreen)
                    },
                    onBack = {
                        navigation.pop()
                    }
                )
            )


            ScreenConfig.Login -> RootComponent.Child.Login(
                DefaultLoginComponent(
                    context,
                    toHomeCallBack = {
                        navigation.replaceCurrent(ScreenConfig.HomeScreen)
                    },
                    toSignUpCallback = {
                        navigation.push(ScreenConfig.SignUp)
                    },
                    onBack = {
                        navigation.pop()
                    }
                )
            )

            ScreenConfig.VerificationScreen -> RootComponent.Child.Verification(
                DefaultVerifyComponent(
                    context,
                    toInterestCallBack = {
                        navigation.push(ScreenConfig.InterestScreen)
                    },
                    onBack = {
                        navigation.pop()
                    }
                )
            )

            ScreenConfig.InterestScreen -> RootComponent.Child.Interest(
                DefaultInterestComponent(
                    context,
                    toHomeCallBack = {
                        navigation.replaceCurrent(ScreenConfig.HomeScreen)
                    },
                    onBack = {
                        navigation.pop()
                    }
                )
            )

            ScreenConfig.HomeScreen -> RootComponent.Child.Home(
                DefaultHomeComponent(
                    context,
                    toDetailCallBack = { product ->
                        navigation.push(ScreenConfig.Detail(product))
                    },
                )
            )

            ScreenConfig.CategoryScreen -> RootComponent.Child.Category(
                DefaultCategoryComponent(
                    context,

                )
            )

            ScreenConfig.ProfileScreen -> RootComponent.Child.Profile(
                DefaultProfileComponent(
                    context,

                )
            )

            ScreenConfig.CartScreen -> RootComponent.Child.Cart(
                DefaultCartComponent(
                    context,

                )
            )

           is ScreenConfig.Detail -> RootComponent.Child.Detail(
                DefaultDetailComponent(
                    context,
                    onBack = { navigation.pop() },
                    config.product
                )
            )
        }
}