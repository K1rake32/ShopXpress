package com.example.shopxpress.presentation.ui.screens.main.home.resultSearch

import android.content.Context
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.dataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shopxpress.presentation.navigation.Screens
import com.example.shopxpress.presentation.ui.screens.main.home.home.components.ItemRecommended
import com.example.shopxpress.presentation.ui.screens.main.home.home.components.ProductItem
import com.example.shopxpress.presentation.ui.screens.main.home.resultSearch.ui.ResultSearchViewModel
import com.example.shopxpress.presentation.ui.screens.main.home.search.ui.SearchViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import com.example.shopxpress.storage.DataStoreManager
import com.example.shopxpress.storage.data.SettingsData
import kotlin.math.sign

@Composable
fun ResultSearchView(
    query: String,
    viewModel: ResultSearchViewModel = viewModel(),
    navController: NavHostController,
) {

    val products = viewModel.products
    val filteredProducts = products.filter { it.category.contains(query, ignoreCase = true) }
    val similarProducts = products.filterNot { it in filteredProducts }

    val count = products.size - filteredProducts.size

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp)
                .padding(bottom = 20.dp)
        ) {

            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "close",
                modifier = Modifier
                    .padding(bottom = 23.dp)
            )

            Row {
                Text(
                    text = "Best match Found",
                    style = ShopXpressTheme.typography.main_text.extraBold,
                    color = ShopXpressTheme.colors.text_100
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = if(filteredProducts.size != 0)"(${filteredProducts.size} results)" else {"0 results"},
                    style = ShopXpressTheme.typography.main_text.bold,
                    color = ShopXpressTheme.colors.text_40
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            ItemRecommended(
                items = filteredProducts.take(filteredProducts.size)
            ) { product ->
                ProductItem(
                    product = product,
                    clickable = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("product", product)
                        navController.navigate(Screens.DetailProduct.route)
                    }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Similar search products",
                    style = ShopXpressTheme.typography.main_text.extraBold,
                    color = ShopXpressTheme.colors.text_100
                )

                Text(
                    text = "$count results",
                    style = ShopXpressTheme.typography.main_text.bold,
                    color = ShopXpressTheme.colors.text_40
                )
            }
            
            Spacer(modifier = Modifier.height(20.dp))

            ItemRecommended(
                items = similarProducts
            ) { product ->
                ProductItem(
                    product = product,
                    clickable = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("product", product)
                        navController.navigate(Screens.DetailProduct.route)
                    },
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
            }
        }
}
@Composable
@Preview(showBackground = true)
private fun ResultSearchView() {

    val navController = rememberNavController()

    ShopXpressTheme {
        ResultSearchView(query = "", navController = navController)
    }

}