package com.example.shopxpress.presentation.navigation.bottomNavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shopxpress.R
import com.example.shopxpress.presentation.navigation.Screens
import com.example.shopxpress.presentation.navigation.bottomNavigation.ui.BottomData
import com.example.shopxpress.presentation.navigation.bottomNavigation.ui.BottomNavigationViewModel
import com.example.shopxpress.presentation.ui.screens.main.home.home.ui.HomeViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun BottomNavigation(
    viewModel: BottomNavigationViewModel = viewModel(),
    navController: NavController,
    activeColor: Color = ShopXpressTheme.colors.primary,
    inActiveColor: Color = ShopXpressTheme.colors.text_40
) {

    val items = viewModel.items

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar(
        containerColor = ShopXpressTheme.colors.bcg_0
    ) {
        items.forEachIndexed { index, item ->

            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index

                    when(index) {
                        0 -> navController.navigate(Screens.HomeView.route)
                        1 -> navController.navigate(Screens.CategoryView.route)
                        2 -> navController.navigate(Screens.ProfileView.route)
                        3 -> navController.navigate(Screens.CartView.route)
                    }
                },
                icon = {

                    Column(
                        modifier = Modifier.fillMaxHeight(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(
                            id = if(selectedItemIndex == index)item.selectedImage
                                else {
                                    item.unSelectedImage
                            }
                            ),
                            contentDescription = "bottom_navigation_item",
                        )

                        Spacer(modifier = Modifier.height(17.dp))

                        Text(
                            text = item.title,
                            style = ShopXpressTheme.typography.minor_text.extraBold,
                            color = if(selectedItemIndex == index) activeColor else inActiveColor
                        )

                    }

                },

                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White
                )
            )
        }
    }
}

@Composable
@Preview
private fun BottomNavigationPreview() {

    val navController = rememberNavController()

    val viewModel = BottomNavigationViewModel()


    ShopXpressTheme {
        BottomNavigation(viewModel, navController)
    }
}