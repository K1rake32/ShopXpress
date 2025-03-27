package com.example.shopxpress.presentation.ui.screens.main.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

val LocalTwoColumnGridItems = staticCompositionLocalOf<MutableList<@Composable ColumnScope.() -> Unit>> {
    error("No TwoColumnGridItems provided")
}

@Composable
fun ItemRecommended(
    clip: RoundedCornerShape = RoundedCornerShape(20.dp),
    content: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier
) {

    val items = remember { mutableStateListOf<@Composable ColumnScope.() -> Unit>()}
    val rows = remember (items) {items.chunked(2)}

    LazyColumn(
        modifier = modifier,

        verticalArrangement =  Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {

        items(rows) { rowItems ->
            Row {
                rowItems.forEach { item ->
                    Card(
                        modifier = Modifier.weight(1f)
                    ) {
                        item()
                    }
                }

                if (rows.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }

            }
        }

    }

    CompositionLocalProvider(
        LocalTwoColumnGridItems provides items
    ) {
        Column(content = content)
    }

}

@Composable
fun TwoColumnGridItem(
    content: @Composable ColumnScope.() -> Unit
) {
    val items = LocalTwoColumnGridItems.current
    items.add(content)
}

