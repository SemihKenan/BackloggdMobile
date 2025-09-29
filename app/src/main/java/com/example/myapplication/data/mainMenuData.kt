package com.example.myapplication.data

data class mainMenuButtons(
    val Text:String,
    val route: String,
)
val AllButtonList = listOf<mainMenuButtons>(
    mainMenuButtons("Tüm Oyunlar","AllGames_Route"),
    mainMenuButtons("Kategoriler","GameCategory_Route"),
    mainMenuButtons("Yeni Çıkanlar","NewReleases_Route"),
    mainMenuButtons("Gelecek Oyunlar","Upcoming_Route")
)