package com.example.shopxpress.presentation.navigation.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.backhandler.BackCallback
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ProductData
import com.example.shopxpress.presentation.ui.screens.main.categories.qwe

abstract class BackComponent(
    context: ComponentContext,
    private val toBackCallback: (() -> Unit)? = null
) : ComponentContext by context, OnBackComponent {

    private val backCallback = toBackCallback?.let {
        object : BackCallback() {
            override fun onBack() = it()
        }
    }

    init {
        backCallback?.let { backHandler.register(it) }
    }

    override fun toBack() {
        toBackCallback?.invoke()
    }
}
class DefaultOnboardingComponent(
    context: ComponentContext,
    private val toFinalOnBoarding: () -> Unit,
    onBack: () -> Unit
) : BackComponent(context, onBack), OnBoardingComponent {
    override fun toFinalOnboarding(): Unit = toFinalOnBoarding()
}
class DefaultFinalOnboardingComponent(
    context: ComponentContext,
    private val toSignUpCallback: () -> Unit,
    private val toLoginCallback: () -> Unit,
    onBack: () -> Unit
) : BackComponent(context, onBack), OnFinalOnBoardingComponent {
    override fun toSignUp(): Unit = toSignUpCallback()
    override fun toLogin(): Unit = toLoginCallback()
}

class DefaultSignUpComponent(
    context: ComponentContext,
    private val toVerifyCallback: () -> Unit,
    onBack: () -> Unit
) : BackComponent(context, onBack), SignUpComponent {
    override fun toVerify(): Unit = toVerifyCallback()
}

class DefaultLoginComponent(
    context: ComponentContext,
    private val toHomeCallBack: () -> Unit,
    private val toSignUpCallback: () -> Unit,
    onBack: () -> Unit
) : BackComponent(context, onBack), LoginComponent {
    override fun toHome(): Unit = toHomeCallBack()
    override fun toSignUp(): Unit = toSignUpCallback()
}

class DefaultVerifyComponent(
    context: ComponentContext,
    private val toInterestCallBack: () -> Unit,
    onBack: () -> Unit
) : BackComponent(context, onBack), VerifyComponent {
    override fun toInterest(): Unit = toInterestCallBack()

}

class DefaultInterestComponent(
    context: ComponentContext,
    private val toHomeCallBack: () -> Unit,
    onBack: () -> Unit
) : BackComponent(context, onBack), InterestComponent {
    override fun toHome(): Unit = toHomeCallBack()
}

class DefaultHomeComponent(
    context: ComponentContext,
    private val toDetailCallBack: (ProductData) -> Unit,
    onBack: (() -> Unit)? = null
) : BackComponent(context, onBack), HomeComponent {
   override fun toDetail(product: ProductData) {
        toDetailCallBack(product)
    }

}

class DefaultCategoryComponent(
    context: ComponentContext,
    onBack: (() -> Unit)? = null
) : BackComponent(context, onBack), CategoryComponent {


}

class DefaultProfileComponent(
    context: ComponentContext,
    onBack: (() -> Unit)? = null
) : BackComponent(context, onBack), ProfileComponent {


}

class DefaultCartComponent(
    context: ComponentContext,
    onBack: (() -> Unit)? = null
) : BackComponent(context, onBack), CartComponent {


}

class DefaultDetailComponent(
    context: ComponentContext,
    onBack: (() -> Unit)? = null,
    val product: ProductData
) : BackComponent(context, onBack), CartComponent {


}
