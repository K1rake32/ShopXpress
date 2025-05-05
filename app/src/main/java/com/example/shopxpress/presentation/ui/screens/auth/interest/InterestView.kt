package com.example.shopxpress.presentation.ui.screens.auth.interest

import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.DefaultNavBar
import com.example.shopxpress.presentation.ui.components.TextBackButton
import com.example.shopxpress.presentation.ui.screens.auth.interest.item.InterestGrid
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme


@Composable
fun InterestView(
    toHome: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ShopXpressTheme.colors.bcg_0),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DefaultNavBar(
            image = R.drawable.icon_close,
            text = "Select Interests"
        )

        Spacer(modifier = Modifier.height(23.dp))

        Text(
            text = stringResource(id = R.string.interest_main),
            style = ShopXpressTheme.typography.main_text.extraBold,
            color = ShopXpressTheme.colors.text_100,
        )

        Text(
            text = stringResource(id = R.string.interest_minor),
            style = ShopXpressTheme.typography.navigation_text.regular,
            color = ShopXpressTheme.colors.text_100,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        InterestGrid {}

        Spacer(modifier = Modifier.height(100.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextBackButton(
                onclick = { /*TODO*/ },
                text = "Skip",
                style = ShopXpressTheme.typography.button_text.bold,
                color = ShopXpressTheme.colors.text_60
            )

            Text(
                text = "qewqeq",
                modifier = Modifier
                    .alpha(0f)
            )

            DefaultButton(
                onclick = {toHome()},
                text = "Submit",
                modifier = Modifier
                    .weight(0.5f)
            )

        }

    }

}


@Composable
@Preview(showBackground = true)
private fun InterestViewPreview() {

    ShopXpressTheme {
        InterestView({})
    }

}