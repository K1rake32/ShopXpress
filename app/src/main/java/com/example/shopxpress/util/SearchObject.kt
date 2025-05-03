package com.example.shopxpress.util

object SearchObject {
    val originalProduct = listOf(
        "Shoes",
        "Electronics"
    )

    fun search(text: String): List<String> {

        val query = text.trim().lowercase()

        return originalProduct.filter { item ->
            item.lowercase().contains(query)
        }

    }
}