package com.example.shopxpress.presentation.data

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductData (
    val mainImage: Int,
    val mainText: String,
    val minorText: String,
    val category: String
) : Parcelable