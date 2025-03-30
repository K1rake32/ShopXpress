package com.example.shopxpress.presentation.ui.screens.auth.Login

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.shimmer.HomeShimmer
import com.example.shopxpress.presentation.ui.components.AuthTextField
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.DefaultNavBar
import com.example.shopxpress.presentation.ui.screens.auth.Signup.components.AroundLink
import com.example.shopxpress.presentation.ui.screens.auth.Signup.ui.SignUpEvent
import com.example.shopxpress.presentation.ui.screens.main.home.HomeView
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import kotlinx.coroutines.delay

@Composable
fun LoginView() {

    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DefaultNavBar(
            image = R.drawable.icon_close,
            text = "Welcome back"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            modifier = Modifier
                .padding(bottom = 30.dp),
            text = "Log In with:",
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
                text = "",
                onValueChange = { },
                label = "Email Address"
            )

            AuthTextField(
                text = "",
                onValueChange = {},
                label = "Password",
                isPassword = true
            )

        }

        Spacer(modifier = Modifier.height(36.dp))

        DefaultButton(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .fillMaxWidth(),
            onclick = {},
            text = "Log In"
        )

        Spacer(modifier = Modifier.height(17.dp))

        Text(
            text = "Don’t have an account? Sign Up",
            style = ShopXpressTheme.typography.main_text.regular,
            color = ShopXpressTheme.colors.text_60
        )

    }

}

@Composable
@Preview(showBackground = true)
private fun LoginViewPreview() {

    ShopXpressTheme {
        LoginView()
    }

}