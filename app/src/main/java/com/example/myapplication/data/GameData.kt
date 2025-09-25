package com.example.myapplication.data


data class GameDataModel(
    val id: String?=null,
    //val ownerid: String? = null,
    val gameName: String="",
    val imageUrl: String? = null,
    val genre: String ="",
    val reviewDate: String?=null,
)

val AllGamesList=listOf(
    GameDataModel("","CyberPunk",null,"Action"),
    GameDataModel("","Batman Arkham Knight",null,"Action"),
    GameDataModel("","Zelda BOTW",null,"Action"),
    GameDataModel("","Hollow Knight",null,"Souls Like"),
    GameDataModel("","Shovel Knight",null,"Souls Like"),
    GameDataModel("","Baldur's Gate",null,"RPG"),
    GameDataModel("","Elden Ring",null,"Souls Like"),
    GameDataModel("","Prison Architect",null, "Strategy"),
    GameDataModel("","Satisfactory",null,"Automation"),
    GameDataModel("","Spider-Man",null,"Action"),
    GameDataModel("","Spider-Man",null,"Action"),
)

val UserAllGamesList=listOf(
    GameDataModel("","CyberPunk",null,"Action"),
    GameDataModel("","Batman Arkham Knight",null,"Action"),
    GameDataModel("","Zelda BOTW",null,"Action"),
    GameDataModel("","Hollow Knight",null,"Souls Like"),
    GameDataModel("","Shovel Knight",null,"Souls Like"),
    GameDataModel("","Baldur's Gate",null,"RPG"),
    GameDataModel("","Elden Ring",null,"Souls Like"),
    GameDataModel("","Prison Architect",null, "Strategy"),
    GameDataModel("","Satisfactory",null,"Automation"),
    GameDataModel("","Spider-Man",null,"Action"),
    GameDataModel("","Spider-Man",null,"Action"),
)

val RecentlyPlayedGames=listOf(
    GameDataModel("","CyberPunk bu recently",null,"Action"),
    GameDataModel("","Batman Arkham Knight",null,"Action"),
    GameDataModel("","Zelda BOTW",null,"Action"),
    GameDataModel("","Hollow Knight",null,"Souls Like"),
    GameDataModel("","Shovel Knight",null,"Souls Like"),
    GameDataModel("","Baldur's Gate",null,"RPG"),
    GameDataModel("","Elden Ring",null,"Souls Like"),
    GameDataModel("","Prison Architect",null, "Strategy"),
    GameDataModel("","Satisfactory",null,"Automation"),
    GameDataModel("","Spider-Man",null,"Action"),
    GameDataModel("","Spider-Man",null,"Action"),
)




