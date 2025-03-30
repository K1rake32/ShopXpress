package com.example.shopxpress.presentation.ui.screens.auth.Signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.shimmer.HomeShimmer
import com.example.shopxpress.presentation.ui.components.AuthTextField
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.DefaultNavBar
import com.example.shopxpress.presentation.ui.screens.auth.Login.LoginView
import com.example.shopxpress.presentation.ui.screens.auth.Signup.components.AroundLink
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpEvent
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import kotlinx.coroutines.delay

@Composable
fun SignUpView(
    signViewModel: SignUpViewModel = viewModel(),

) {

    val isLoading by produceState(initialValue = true) {
        delay(2000)
        value = false
    }

    if (isLoading) {
        HomeShimmer()
    } else {
        LoginView()
    }

    val state by signViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DefaultNavBar(
            image = R.drawable.icon_close,
            text = "Create Account"
        )
        
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            modifier = Modifier
                .padding(bottom = 30.dp),
            text = "Sign Up with:",
            style = ShopXpressTheme.typography.main_text.regular,
            color = ShopXpressTheme.colors.text_80
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 55.dp),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            AroundLink(
                image = R.drawable.google,
                text = "Google"
            )

            AroundLink(
                image = R.drawable.facebook,
                text = "Facebook",
                facebook = true
            )

            AroundLink(
                image = R.drawable.apple,
                text = "Apple"
            )

        }

        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = "Or Continue with Email:",
            style = ShopXpressTheme.typography.main_text.regular,
            color = ShopXpressTheme.colors.text_80
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 25.dp),

            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            AuthTextField(
                text = state.email,
                onValueChange = { signViewModel.onEvent(SignUpEvent.OnEmailChange(it)) },
                label = "Email Address"
            )

            AuthTextField(
                text = state.password,
                onValueChange = {signViewModel.onEvent(SignUpEvent.OnPasswordChange(it))},
                label = "Password",
                isPassword = true
            )

            AuthTextField(
                text = state.number,
                onValueChange = {signViewModel.onEvent(SignUpEvent.OnNumberChange(it))},
                label = "Phone Number",
                isNumber = true
            )

        }

        Spacer(modifier = Modifier.height(36.dp))

        DefaultButton(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .fillMaxWidth(),
            onclick = {},
            text = "Create Account"
        )

        Spacer(modifier = Modifier.height(17.dp))

        Text(
            text = "Already have an account? Log In",
            style = ShopXpressTheme.typography.main_text.regular,
            color = ShopXpressTheme.colors.text_60
        )

    }

}

@Composable
@Preview(showBackground = true)
private fun SignUpPreview() {
    
    ShopXpressTheme{
        SignUpView(signViewModel = SignUpViewModel(),)
    }
    
}