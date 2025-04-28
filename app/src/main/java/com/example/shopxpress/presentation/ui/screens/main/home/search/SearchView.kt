package com.example.shopxpress.presentation.ui.screens.main.home.search

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.presentation.ui.components.SearchTextField
import com.example.shopxpress.presentation.ui.screens.main.home.search.ui.SearchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.ui.screens.main.home.search.components.SearchItem
import com.example.shopxpress.presentation.ui.screens.main.home.search.ui.SearchEvent
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme
import com.example.shopxpress.storage.DataStoreManager

@Composable
fun SearchView(
    toDetailSearch: (String) -> Unit,
) {

    val context = LocalContext.current
    val dataStoreManager = remember {DataStoreManager(context)}
    val viewModel = remember {SearchViewModel(dataStoreManager = dataStoreManager)}
    val state by viewModel.state.collectAsState()
    val isSearching = state.search.isNotBlank()
    val history by viewModel.history.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.icon_back),
                contentDescription = "",
                modifier = Modifier
            )

            SearchTextField(
                modifier = Modifier
                    .weight(1f),
                startIcon = R.drawable.search,
                placeholder = "Search",
                onValueChange = { viewModel.onEvent(SearchEvent.OnSearchChange(it)) },
                value = state.search,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions (
                    onSearch = {
                        toDetailSearch(state.search)
                        viewModel.addQueryToHistory(state.search)
                    }
                )
            )

            Box(
                modifier = Modifier
                    .border(1.dp, ShopXpressTheme.colors.text_20, RoundedCornerShape(18.dp))
                    .background(
                        color = ShopXpressTheme.colors.bcg_100,
                        shape = RoundedCornerShape(18.dp)
                    )
            ) {

                Icon(
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.artwork),
                    contentDescription = "",
                    tint = ShopXpressTheme.colors.primary
                )

            }

        }

        Spacer(modifier = Modifier.height(36.dp))

        if(!isSearching) {

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(history) {pastQuery ->
                    SearchItem(
                        item = pastQuery,
                        isSearching = isSearching,
                        clear = {
                            viewModel.removeItem(pastQuery)
                        },
                        query = state.search
                    )
                }
            }

        }


    }


}

@Composable
@Preview(showBackground = true)
private fun SearchViewPreview() {

    ShopXpressTheme {

    }

}