package com.example.myapplication.data


data class GameDataModel(
    val id: String = "",
    //val ownerid: String? = null,
    val gameName: String= "",
    val imageUrl: String? = null,
    val genre: String = "",
    val reviewDate: String?=null,
)

val AllGamesList=listOf(
    GameDataModel("1","CyberPunk",null,"Action"),
    GameDataModel("2","Batman Arkham Knight",null,"Action"),
    GameDataModel("3","Zelda BOTW",null,"Action"),
    GameDataModel("4","Hollow Knight",null,"Souls Like"),
    GameDataModel("5","Shovel Knight",null,"Souls Like"),
    GameDataModel("6","Baldur's Gate",null,"RPG"),
    GameDataModel("7","Elden Ring",null,"Souls Like"),
    GameDataModel("8","Prison Architect",null, "Strategy"),
    GameDataModel("9","Satisfactory",null,"Automation"),
    GameDataModel("10","Spider-Man",null,"Action"),
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
)




