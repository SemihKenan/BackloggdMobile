package com.example.myapplication.data

data class MainMenuButtonModel(
    val Text:String,
    val route: String,
)
val mainMenuButtonList = listOf<MainMenuButtonModel>(
    MainMenuButtonModel("Tüm Oyunlar","AllGames_Route",),
    MainMenuButtonModel("Kategoriler","GameCategory_Route"),
    MainMenuButtonModel("Yeni Çıkanlar","NewReleases_Route"),
    MainMenuButtonModel("Gelecek Oyunlar","Upcoming_Route")
)