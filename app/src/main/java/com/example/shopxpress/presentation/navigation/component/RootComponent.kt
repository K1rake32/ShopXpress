package com.example.shopxpress.presentation.navigation.component

import com.example.shopxpress.presentation.data.ProductData


interface OnBackComponent {
    fun toBack()
}
interface OnBoardingComponent : OnBackComponent{
    fun toFinalOnboarding()
}

interface OnFinalOnBoardingComponent : OnBackComponent {
    fun toSignUp()
    fun toLogin()
}

interface SignUpComponent : OnBackComponent{
    fun toVerify()
}

interface LoginComponent : OnBackComponent {
    fun toHome()
    fun toSignUp()
}

interface VerifyComponent : OnBackComponent {
    fun toInterest()
}

interface InterestComponent : OnBackComponent {
    fun toHome()
}

interface HomeComponent : OnBackComponent {
    fun toDetail(product: ProductData)
}

interface CategoryComponent : OnBackComponent {

}

interface ProfileComponent : OnBackComponent {

}

interface CartComponent: OnBackComponent {

}

interface DetailComponent: OnBackComponent {
    val product: ProductData
}
