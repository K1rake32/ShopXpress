package com.example.shopxpress.presentation.ui.screens.main.home.resultSearch

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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

@Composable
fun ResultSearchView(
    query: String,
    count: Int,
    viewModel: ResultSearchViewModel = viewModel(),
    navController: NavHostController,
) {

    val products = viewModel.products
    val filteredProducts = products.filter { it.mainText.contains(query, ignoreCase = true) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    text = "Best match Found",
                    style = ShopXpressTheme.typography.main_text.extraBold,
                    color = ShopXpressTheme.colors.text_100
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "($filteredProducts results)",
                    style = ShopXpressTheme.typography.main_text.bold,
                    color = ShopXpressTheme.colors.text_40
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            ItemRecommended(
                items = filteredProducts
            ) { product ->
                ProductItem(
                    product = product,
                    clickable = {

                    }
                )
            }
        }
}
@Composable
@Preview(showBackground = true)
private fun ResultSearchView() {

    val navController = rememberNavController()

    ShopXpressTheme {
        ResultSearchView()
    }

}