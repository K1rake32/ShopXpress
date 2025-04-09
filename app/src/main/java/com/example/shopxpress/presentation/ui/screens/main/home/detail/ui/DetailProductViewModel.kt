package com.example.shopxpress.presentation.ui.screens.main.home.detail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopxpress.R
import com.example.shopxpress.presentation.data.ReviewsData
import com.example.shopxpress.presentation.data.TrendData
import com.example.shopxpress.presentation.ui.style.string.Strings
import kotlinx.coroutines.launch

class DetailProductViewModel: ViewModel() {
    private val _reviews = mutableStateListOf<ReviewsData>()
    private val _trends = mutableStateListOf<TrendData>()

    val reviews: List<ReviewsData> get() = _reviews
    val trends: List<TrendData> get() = _trends

    init {
        viewModelScope.launch {
            loadReviews()
            loadTrends()
        }
    }
    private fun loadReviews() {
        _reviews.addAll(
            listOf(
                ReviewsData(
                    avatar = R.drawable.avatar_1,
                    title = "Great Purchase",
                    time = "2 days ago",
                    description = Strings.avatar_description_1,
                    stars = 4
                ),

                ReviewsData(
                    avatar = R.drawable.avatar_3,
                    title = "The sizes fit accurately",
                    time = "3 weeks ago",
                    description = Strings.avatar_description_2,
                    stars = 5
                ),

                ReviewsData(
                    avatar = R.drawable.avatar_1,
                    title = "Great Purchase",
                    time = "2 days ago",
                    description = Strings.avatar_description_1,
                    stars = 4
                ),

                ReviewsData(
                    avatar = R.drawable.avatar_3,
                    title = "The sizes fit accurately",
                    time = "3 weeks ago",
                    description = Strings.avatar_description_2,
                    stars = 5
                ),

                ReviewsData(
                    avatar = R.drawable.avatar_1,
                    title = "Great Purchase",
                    time = "2 days ago",
                    description = Strings.avatar_description_1,
                    stars = 4
                ),

                ReviewsData(
                    avatar = R.drawable.avatar_3,
                    title = "The sizes fit accurately",
                    time = "3 weeks ago",
                    description = Strings.avatar_description_2,
                    stars = 5
                ),

                ReviewsData(
                    avatar = R.drawable.avatar_1,
                    title = "Great Purchase",
                    time = "2 days ago",
                    description = Strings.avatar_description_1,
                    stars = 4
                ),

                ReviewsData(
                    avatar = R.drawable.avatar_3,
                    title = "The sizes fit accurately",
                    time = "3 weeks ago",
                    description = Strings.avatar_description_2,
                    stars = 5
                ),

            )
        )
    }

    private fun loadTrends() {
        _trends.addAll(
            listOf(
                TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
                TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
                TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
                TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
                TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
                TrendData(R.drawable.book_item,"H&M Shirt", "N13,500", "5.0", "Fashion"),
            )
        )
    }
}