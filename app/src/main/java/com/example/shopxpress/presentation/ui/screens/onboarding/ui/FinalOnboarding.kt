package com.example.shopxpress.presentation.ui.screens.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.OutlinedDefaultButton
import com.example.shopxpress.presentation.ui.components.TextBackButton
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun FinalOnboarding(
    onSignUp: () -> Unit,
    toLogin: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(650.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Image(
            painter = painterResource(id = R.drawable.page_fourth),
            contentDescription = "image"
        )

        Spacer(modifier = Modifier.height(120.dp))

        Text(
            modifier = Modifier
                .padding(bottom = 20.dp),
            text = stringResource(id = R.string.page_fourth_title),
            style = ShopXpressTheme.typography.title.bold,
            color = ShopXpressTheme.colors.text_100,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(id = R.string.page_fourth_text),
            style = ShopXpressTheme.typography.main_text.regular,
            color = ShopXpressTheme.colors.text_100,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            OutlinedDefaultButton(
                onclick = {toLogin()},
                text = "Log In",
                modifier = Modifier
                    .weight(0.25f)
            )

            Spacer(modifier = Modifier.width(14.dp))

            DefaultButton(
                onclick = onSignUp,
                text = "Sign up",
                modifier = Modifier
                    .weight(0.25f)
            )

        }

        Spacer(modifier = Modifier.padding(5.dp))

        TextBackButton(
            onclick = { /*TODO*/ },
            text = "Don’t mind me, just watchin’",
            style = ShopXpressTheme.typography.main_text.regular,
            color = ShopXpressTheme.colors.text_60
        )

    }
    
}

@Composable
@Preview(showBackground = true)
private fun FinalOnboardingPreview() {

    ShopXpressTheme {
        FinalOnboarding({}, {})
    }

}