package com.example.shopxpress.presentation.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrendData(
    val mainImage: Int,
    val title: String,
    val price: String,
    val reviews: String,
    val category: String
) : Parcelable