package com.example.shopxpress.presentation.ui.screens.main.home.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.SearchData
import com.example.shopxpress.presentation.ui.screens.main.home.search.ui.SearchViewModel
import com.example.shopxpress.presentation.ui.style.ShopXpressTheme

@Composable
fun SearchItem(
    item: String,
    isSearching: Boolean,
    clear: () -> Unit,
    query: String
) {
    val cleanedQuery = query.trim().lowercase()

    val annotatedString = buildAnnotatedString {
        val lowerItem = item.lowercase()
        val startIndex = lowerItem.indexOf(cleanedQuery)

        if (startIndex != -1 && cleanedQuery.isNotEmpty()) {
            append(item.substring(0, startIndex))
            withStyle(style = SpanStyle(color = Color.Black)) {
                append(item.substring(startIndex, startIndex + cleanedQuery.length))
            }
            append(item.substring(startIndex + cleanedQuery.length))
        } else {
            append(item)
        }
    }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = if (isSearching) Icons.Default.Search else Icons.Default.Refresh,
                    contentDescription = "recently",
                    tint = ShopXpressTheme.colors.text_80
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = annotatedString,
                    style = ShopXpressTheme.typography.main_text.regular,
                    color = ShopXpressTheme.colors.text_60
                )
            }

            Icon(
                imageVector = if (isSearching) Icons.Default.KeyboardArrowRight else Icons.Default.Clear,
                contentDescription = "clear",
                tint = ShopXpressTheme.colors.text_80,
                modifier = Modifier.clickable { clear() }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(ShopXpressTheme.colors.text_20)
        )
    }
}

@Composable
@Preview
private fun SearchItemPreview() {

    ShopXpressTheme {

    }

}