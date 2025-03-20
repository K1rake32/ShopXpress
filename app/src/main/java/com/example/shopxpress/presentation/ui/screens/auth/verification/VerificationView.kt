package com.example.shopxpress.presentation.ui.screens.auth.verification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.DefaultNavBar
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun VerificationView() {

    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DefaultNavBar(
            image = R.drawable.icon_back,
            text = "Enter Verification Code"
        )

        Spacer(modifier = Modifier.height(90.dp))

        Image(
            painter = painterResource(id = R.drawable.verification),
            contentDescription = "verification_img"
        )
        
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = stringResource(id = R.string.verification_main),
            style = ShopXpressTheme.typography.main_text.regular,
            color = ShopXpressTheme.colors.text_80
        )

        Spacer(modifier = Modifier.height(40.dp))

        //PinView

        Spacer(modifier = Modifier.height(108.dp))

        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            onclick = { /*TODO*/ },
            text = "Verify Number"
        )

    }

}

@Composable
@Preview(showBackground = true)
private fun VerificationViewPreview() {

    ShopXpressTheme {
        VerificationView()
    }

}