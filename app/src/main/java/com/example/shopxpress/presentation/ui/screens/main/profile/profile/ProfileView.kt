package com.example.shopxpress.presentation.ui.screens.main.profile.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.navigation.component.DefaultProfileComponent
import com.example.shopxpress.presentation.ui.components.MainNavBar
import com.example.shopxpress.presentation.ui.components.SegmentedControl
import com.example.shopxpress.presentation.ui.screens.main.profile.profile.components.CardAccountItem
import com.example.shopxpress.presentation.ui.screens.main.profile.profile.ui.ProfileViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun ProfileView(
    viewModel: ProfileViewModel = viewModel(),
    component: DefaultProfileComponent
) {

    val items = viewModel.item
    var selectedTab by remember { mutableStateOf(0) }
    val options = listOf("My Account", "My Interests")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .padding(horizontal = 25.dp)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MainNavBar(
            text = "Profile",
            image = R.drawable.edit
        )
        
        Spacer(modifier = Modifier.height(36.dp))

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(ShopXpressTheme.colors.accent_20)
        ) {

            Image(
                painter = painterResource(id = R.drawable.big_time_avatar),
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Andrey Sviridovsky",
                style = ShopXpressTheme.typography.main_text.bold,
                color = ShopXpressTheme.colors.text_80
            )

            Text(
                text = "kirakel43@gmail.com",
                style = ShopXpressTheme.typography.main_text.regular,
                color = ShopXpressTheme.colors.text_60
            )

            Text(
                text = "+7953_ _ _ _ _ _",
                style = ShopXpressTheme.typography.main_text.regular,
                color = ShopXpressTheme.colors.text_60
            )

        }

        Spacer(modifier = Modifier.height(28.dp))

        SegmentedControl(
            options = options,
            selectedIndex = selectedTab,
            onOptionSelected = {selectedTab = it},
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),



            colors = CardDefaults.cardColors(
                containerColor = ShopXpressTheme.colors.bcg_0
            )
        ) {

                Column(
                    modifier = Modifier
                        .padding(horizontal = 21.dp)
                        .padding(top = 26.dp)
                ) {
                    items.forEachIndexed { index, item ->
                        val isLast = index == items.lastIndex
                        CardAccountItem(
                            item = item,
                            showArrow = !isLast
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
        }

    }

}

@Composable
@Preview(showBackground = true)
private fun ProfileViewPreview() {

    ShopXpressTheme {
        /*ProfileView()*/
    }

}