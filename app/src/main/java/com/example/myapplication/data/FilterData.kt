package com.example.myapplication.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

enum class ProfileFilter {
    Favorites,
    RecentlyPlayed,
    AllGames
}
data class FilterButtonData(
    val text: String,
    val icon: ImageVector,
    val filterType:ProfileFilter,
    val route:String
)
val profileFilterButtonsDataList: List<FilterButtonData> = listOf(

    FilterButtonData(
        text = "Hepsi",
        icon = Icons.Filled.List,
        filterType = ProfileFilter.AllGames,
        route =ProfileFilter.AllGames.name
    ),
    FilterButtonData(
        text = "Son Oynananlar",
        icon = Icons.Filled.Edit,
        filterType = ProfileFilter.RecentlyPlayed,
        route = ProfileFilter.RecentlyPlayed.name
    ),
    FilterButtonData(
        text = "Favoriler",
        icon = Icons.Filled.Favorite,
        filterType = ProfileFilter.Favorites,
        route = ProfileFilter.Favorites.name
    )
)