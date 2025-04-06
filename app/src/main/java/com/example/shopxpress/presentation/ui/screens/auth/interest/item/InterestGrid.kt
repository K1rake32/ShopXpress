package com.example.shopxpress.presentation.ui.screens.auth.interest.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.InterestData


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InterestGrid(
    onItemClick: (InterestData) -> Unit,
) {

    val categories = listOf(
        InterestData(
            text = "Books",
            image = R.drawable.book,
            size = 80.dp
        ),

        InterestData(
            text = "Fashion",
            image = R.drawable.fashion,
            size = 130.dp
        ),

        InterestData(
            text = "Phone",
            image = R.drawable.phone,
            size = 85.dp
        ),

        InterestData(
            text = "Books",
            image = R.drawable.furniture,
            size = 120.dp
        ),

        InterestData(
            text = "Jewelry",
            image = R.drawable.jewelry,
            size = 265.dp
        ),

        InterestData(
            text = "Home\nDecor",
            image = R.drawable.home_decoration,
            size = 99.dp
        ),

        InterestData(
            text = "Music",
            image = R.drawable.music,
            size = 85.dp
        ),

        InterestData(
            text = "Fitness",
            image = R.drawable.fitness,
            size = 120.dp
        ),

        InterestData(
            text = "Electr",
            image = R.drawable.electronics,
            size = 150.dp
        ),

        InterestData(
            text = "Cosmetics",
            image = R.drawable.cosmetic,
            size = 105.dp
        ),


    )

    val selectedItems = remember { mutableStateListOf<InterestData>() }

   LazyRow(
       modifier = Modifier.fillMaxWidth(),
       contentPadding = PaddingValues(16.dp),
       horizontalArrangement = Arrangement.spacedBy(20.dp)
   ) {

       item {
           
           Column(
               verticalArrangement = Arrangement.spacedBy(16.dp)
           ) {

               Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.Bottom) {
                   categories.subList(0, 4).forEach { item ->
                       InterestItem(
                           item = item,
                           onItemClick = { clickedItem ->
                               if (selectedItems.contains(clickedItem)) {
                                   selectedItems.remove(clickedItem)
                               } else {
                                   selectedItems.add(clickedItem)
                               }
                               onItemClick(clickedItem)
                           },
                           isSelected = selectedItems.contains(item)
                       )
                   }
               }

               Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,) {
                   InterestItem(
                       item = categories[4],
                       onItemClick = { clickedItem ->
                           if (selectedItems.contains(clickedItem)) {
                               selectedItems.remove(clickedItem)
                           } else {
                               selectedItems.add(clickedItem)
                           }
                           onItemClick(clickedItem)
                       },
                       isSelected = selectedItems.contains(categories[4])
                   )

                   Spacer(modifier = Modifier.width(10.dp))

                   Column {

                       Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                           categories.subList(5, 8).forEach { item ->
                               InterestItem(
                                   item = item,
                                   onItemClick = { clickedItem ->
                                       if (selectedItems.contains(clickedItem)) {
                                           selectedItems.remove(clickedItem)
                                       } else {
                                           selectedItems.add(clickedItem)
                                       }
                                       onItemClick(clickedItem)
                                   },
                                   isSelected = selectedItems.contains(item)
                               )
                           }
                       }

                       Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                           categories.subList(8, categories.size).forEach { item ->
                               InterestItem(
                                   item = item,
                                   onItemClick = { clickedItem ->
                                       if (selectedItems.contains(clickedItem)) {
                                           selectedItems.remove(clickedItem)
                                       } else {
                                           selectedItems.add(clickedItem)
                                       }
                                       onItemClick(clickedItem)
                                   },
                                   isSelected = selectedItems.contains(item)
                               )
                           }
                       }

                   }

               }
               
           }
           
       }

   }

}

@Composable
@Preview(showBackground = true)
private fun InterestGridPreview() {

    InterestGrid() {

    }

}