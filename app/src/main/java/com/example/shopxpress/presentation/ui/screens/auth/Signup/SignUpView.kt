package com.example.shopxpress.presentation.ui.screens.auth.Signup

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.AuthTextField
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.DefaultNavBar
import com.example.shopxpress.presentation.ui.screens.auth.Signup.components.AroundLink
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpEvent
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun SignUpView(
    signViewModel: SignUpViewModel = viewModel(),
    navigationVerification: () -> Unit,
    toLogin: () -> Unit
) {

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
                label = "Email Address",
                modifier = Modifier
                    .fillMaxWidth()
            )

            AuthTextField(
                text = state.password,
                onValueChange = {signViewModel.onEvent(SignUpEvent.OnPasswordChange(it))},
                label = "Password",
                isPassword = true,
                modifier = Modifier
                    .fillMaxWidth()
            )

            AuthTextField(
                text = state.number,
                onValueChange = { input ->
                    val filtered = if (input.isNotEmpty() && input[0] == '8') {
                        input.removePrefix("8")
                    } else {
                        input
                    }
                    signViewModel.onEvent(SignUpEvent.OnNumberChange(filtered))
                },
                label = "Phone Number",
                isNumber = true,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }

        Spacer(modifier = Modifier.height(36.dp))

        DefaultButton(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .fillMaxWidth(),
            onclick = {
                if(state.isButtonEnabled) {
                    navigationVerification()
                }
            },
            text = "Create Account"
        )

        Spacer(modifier = Modifier.height(17.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Already have an account?",
                style = ShopXpressTheme.typography.main_text.regular,
                color = ShopXpressTheme.colors.text_60
            )

            Text(
                text = "Log in",
                style = ShopXpressTheme.typography.main_text.bold,
                color = ShopXpressTheme.colors.primary,
                modifier = Modifier
                    .clickable { toLogin() },
                textDecoration = TextDecoration.Underline
            )

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun SignUpPreview() {
    
    ShopXpressTheme{
        SignUpView(signViewModel = SignUpViewModel(),{}, {})
    }
    
}