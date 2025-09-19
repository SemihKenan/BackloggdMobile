package com.example.myapplication.data

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myapplication.HomeScreen



enum class ProfileFilter {
    Favorites,
    Recently_Played,
    All_Activity
}
data class FilterButtonData(
    val text: String,
    val icon: ImageVector,
    val filterType:ProfileFilter
)
val profileFilterButtonsDataList: List<FilterButtonData> = listOf(

    FilterButtonData(
        text = "Hepsi",
        icon = Icons.Filled.List, // Gerçek ikonlarınızı kullanın
        filterType = ProfileFilter.All_Activity
    ),
    FilterButtonData(
        text = "Son Oynananlar",
        icon = Icons.Filled.Edit, // Gerçek ikonlarınızı kullanın
        filterType = ProfileFilter.Recently_Played
    ),
    FilterButtonData(
        text = "Favoriler",
        icon = Icons.Filled.Favorite,
        filterType = ProfileFilter.Favorites
    )
)
data class Game(
    val id: String,
    val name: String,
    val imageUrl: String? = null,
    val genre: String, // Veya placeholder için Int (Drawable Res ID)
    val playedDate: String? = null, // Son oynanma için
    val isFavorite: Boolean = false
)
data class CommentedGame(
    val id: String,
    val gameName: String,
    val commentText: String,
    val date: String
)
val AllGames=listOf(
    Game("g1","CyberPunk",null,"Action","2025-12-07"),
    Game("g2","Batman Arkham Knight",null,"Action","2025-12-07",true),
    Game("g3","Zelda BOTW",null,"Action","2025-12-07",true),
    Game("g4","Hollow Knight",null,"Souls Like"),
    Game("g5","Shovel Knight",null,"Souls Like"),
    Game("g6","Baldur's Gate",null,"RPG"),
    Game("g7","Elden Ring",null,"Souls Like"),
    Game("g8","Prison Architect",null,"Base Building","2025-12-07",true),
    Game("g9","Satisfactory",null,"Automation"),
    Game("g10","Spider-Man",null,"Action"),
)

val AlreadyCommented=listOf(
    CommentedGame(
        id = "c1",
        gameName = "CyberPunk",
        commentText = "Great game!",
        date = "2023-10-25"
    )
    ,
    CommentedGame(
        id = "c2",
        gameName = "Satisfactory",
        commentText = "Amazing graphics.",
        date = "2023-10-23"
    )
    ,
    CommentedGame(
        id = "c3",
        gameName = "Baldur's Gate",
        commentText = "Great storytelling.",
        date = "2023-10-22"
    )

)
data class ProfileHeaders(
    val username: String,
    val imageUrl: String?=null, // Veya Int (drawable id)
    val gamesPlayed: Int,
    val commentsMade: Int
)
val userProfile=ProfileHeaders(
    "Oyuncu123",
    null,
    25,
    5
)

