package com.example.myapplication.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector


enum class ProfileFilter {
    Favorites,
    RecentlyPlayed,
    AllActivity
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
        filterType = ProfileFilter.AllActivity,
        route ="All_Games"
    ),
    FilterButtonData(
        text = "Son Oynananlar",
        icon = Icons.Filled.Edit,
        filterType = ProfileFilter.RecentlyPlayed,
        route = "Recently_Played"
    ),
    FilterButtonData(
        text = "Favoriler",
        icon = Icons.Filled.Favorite,
        filterType = ProfileFilter.Favorites,
        route = "Favorites"
    )
)
data class ProfileHeaders(
    val profileOwnerId: String?=null,
    val profileUsername: String,
    val profileImage: String?=null,
    val profileGamesPlayed: List<String> = emptyList(),
    val profileReviewedGames: String?=null
)

val userProfile= listOf<ProfileHeaders>(
    ProfileHeaders(
    "p1",
    "Username127",
    null,
    listOf("g1","g2","g4","g7","g8","g9"),
    "5"
),
    ProfileHeaders(
        "p2",
        "Username712",
        null,
        listOf("g3","g6","g4","g2","g8","g9","g1"),
        "3"
    )
)
val activeUser = userProfile[1]
val playedGames: Int = activeUser.profileGamesPlayed.size
