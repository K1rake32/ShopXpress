package com.example.shopxpress.presentation.ui.screens.main.profile.profileunaUthorized

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.DefaultNavBar
import com.example.shopxpress.presentation.ui.components.MainNavBar
import com.example.shopxpress.presentation.ui.components.OutlinedDefaultButton
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun ProfileUnauthorized() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MainNavBar(
            text = "Profile"
        )

        Spacer(modifier = Modifier.height(70.dp))

        Icon(
            painter = painterResource(id = R.drawable.profile_none_active),
            contentDescription = "profile_none_active",
            tint = ShopXpressTheme.colors.primary
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Sign in for a personalized shopping experience",
            style = ShopXpressTheme.typography.navigation_text.bold,
            color = ShopXpressTheme.colors.text_80,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp),

            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            DefaultButton(
                onclick = { /*TODO*/ },
                text = "Log In",
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedDefaultButton(
                onclick = { /*TODO*/ },
                text = "Create Account",
                modifier = Modifier.fillMaxWidth()
            )

        }

    }

}

@Composable
@Preview()
private fun ProfileUnauthorizedPreview() {

    ProfileUnauthorized()

}