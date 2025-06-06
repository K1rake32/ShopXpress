package com.example.shopxpress

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.arkivanov.decompose.defaultComponentContext
import com.example.shopxpress.presentation.navigation.DefaultRootComponent
import com.example.shopxpress.presentation.navigation.Screens
import com.example.shopxpress.presentation.navigation.root.RootContent
import com.example.shopxpress.presentation.ui.screens.main.home.home.HomeScreen
import com.example.shopxpress.presentation.ui.screens.main.home.home.HomeView
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
        )

        setContent {
            ShopXpressTheme {

                val navController = rememberNavController()
                val root = DefaultRootComponent(defaultComponentContext())

                /*AppNavHost(navController = navController)*/
                
                RootContent(component = root)

            }
        }
    }
}
