package com.example.shopxpress.util

object SearchObject {
    val originalProduct = listOf(
        "Shoes",
        "Office Shoes for men",
        "Shoes for kids",
        "Gaming",
        "Clothings",
        "Accessories"
    )

    fun search(text: String): List<String> {

        val query = text.trim().lowercase()

        return originalProduct.filter { item ->
            item.lowercase().contains(query)
        }

    }
}