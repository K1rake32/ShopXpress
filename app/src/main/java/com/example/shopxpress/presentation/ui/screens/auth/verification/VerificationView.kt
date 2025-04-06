package com.example.shopxpress.presentation.ui.screens.auth.verification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.base.OtpAction
import com.example.shopxpress.presentation.ui.components.DefaultButton
import com.example.shopxpress.presentation.ui.components.DefaultNavBar
import com.example.shopxpress.presentation.ui.components.PinTextField
import com.example.shopxpress.presentation.ui.screens.auth.verification.ui.VerificationState
import com.example.shopxpress.presentation.ui.screens.auth.verification.ui.VerificationViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun VerificationView(
    viewModel: VerificationViewModel = viewModel(),
    focusRequesters: List<FocusRequester> = remember { List(4) { FocusRequester() } }
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(state.focusedIndex) {
        state.focusedIndex?.let { index ->
            focusRequesters.getOrNull(index)?.requestFocus()
        }
    }

    LaunchedEffect(state.code) {
        if (state.code.none { it == null }) {
            focusManager.clearFocus()
            keyboardController?.hide()
        }
    }

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

        Row(
            modifier = Modifier
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
        ) {

            state.code.forEachIndexed { index, number ->
                PinTextField(
                    number = number,
                    focusRequester = focusRequesters[index],
                    onFocusChanged = { isFocused ->
                         if(isFocused) {
                             viewModel.onAction(OtpAction.OnChangedFieldFocused(index))
                         }
                    },
                    onNumberChanged = { newNumber ->
                        viewModel.onAction(OtpAction.OnEnterNumber(newNumber, index))
                    },
                    onKeyboardBack = {
                        viewModel.onAction(OtpAction.OnKeyboardBack)
                    },

                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                )
            }

        }

        state.isValid?.let {  isValid ->
            Text(
                text = if(isValid) "OTP is valid!" else "OTP is invalid",
                style = ShopXpressTheme.typography.main_text.bold
            )
        }

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

    val viewModel = viewModel<VerificationViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val focusRequester = remember {
        List(4) { FocusRequester() }
    }

    val focusManager = LocalFocusManager.current
    val keyboardManager = LocalSoftwareKeyboardController.current

    LaunchedEffect(state.focusedIndex) {
        state.focusedIndex?.let{ index ->
            focusRequester.getOrNull(index)?.requestFocus()
        }
    }

    LaunchedEffect(state.code, keyboardManager) {
        val allNumbersEntered = state.code.none() {it == null}
        if (allNumbersEntered) {
            focusRequester.forEach {
                it.freeFocus()
            }
            focusManager.clearFocus()
            keyboardManager?.hide()
        }
    }



}