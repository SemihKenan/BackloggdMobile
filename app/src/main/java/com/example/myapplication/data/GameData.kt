package com.example.myapplication.data

data class GameDataModel(
    val id: String = "",
    val ownerid: List<String> = emptyList(),
    val gameName: String= "",
    val imageUrl: String? = null,
    val genre: String = "",
    val reviewDate: String?=null,
)

//val playedGames: Int = activeUser.profileOwnerId.size
val AllGamesList=listOf(
    GameDataModel("1",listOf("p1","p2"),"CyberPunk",null,"Action"),
    GameDataModel("2",listOf("p1"),"Batman Arkham Knight",null,"Action"),
    GameDataModel("3",listOf("p1","p2"),"Zelda BOTW",null,"Action"),
    GameDataModel("4",listOf("p1","p2"),"Hollow Knight",null,"Souls Like"),
    GameDataModel("5",listOf("p1","p2"),"Shovel Knight",null,"Souls Like"),
    GameDataModel("6",listOf("p1","p2"),"Baldur's Gate",null,"RPG"),
    GameDataModel("7",listOf("p1"),"Elden Ring",null,"Souls Like"),
    GameDataModel("8",listOf("p1","p2"),"Prison Architect",null, "Strategy"),
    GameDataModel("9",listOf("p1"),"Satisfactory",null,"Automation"),
    GameDataModel("10",listOf("p1"),"Spider-Man",null,"Action"),
)

val UserAllGamesList=listOf(
    GameDataModel("1",listOf("p1"),"CyberPunk",null,"Action"),
    GameDataModel("2",listOf("p1"),"Batman Arkham Knight",null,"Action"),
    GameDataModel("3",listOf("p1"),"Zelda BOTW",null,"Action"),
    GameDataModel("4",listOf("p1","p2"),"Hollow Knight",null,"Souls Like"),
    GameDataModel("5",listOf("p1","p2"),"Shovel Knight",null,"Souls Like"),
    GameDataModel("6",listOf("p1","p2"),"Baldur's Gate",null,"RPG"),
    GameDataModel("7",listOf("p1"),"Elden Ring",null,"Souls Like"),
    GameDataModel("8",listOf("p1","p2"),"Prison Architect",null, "Strategy"),
    GameDataModel("9",listOf("p1","p2"),"Satisfactory",null,"Automation"),
    GameDataModel("10",listOf("p1","p2"),"Spider-Man",null,"Action"),
)

val RecentlyPlayedGames=listOf(
    GameDataModel("1",listOf("p1","p2"),"CyberPunk",null,"Action"),
    GameDataModel("2",listOf("p1"),"Batman Arkham Knight",null,"Action"),
    GameDataModel("3",listOf("p1","p2"),"Zelda BOTW",null,"Action"),
    GameDataModel("4",listOf("p1","p2"),"Hollow Knight",null,"Souls Like"),
    GameDataModel("5",listOf("p1","p2"),"Shovel Knight",null,"Souls Like"),
    GameDataModel("6",listOf("p1","p2"),"Baldur's Gate",null,"RPG"),
    GameDataModel("7",listOf("p1"),"Elden Ring",null,"Souls Like"),
    GameDataModel("8",listOf("p1","p2"),"Prison Architect",null, "Strategy"),
    GameDataModel("9",listOf("p1"),"Satisfactory",null,"Automation"),
    GameDataModel("10",listOf("p1"),"Spider-Man",null,"Action"),
)


data class CustomGameData(
    val ownerId: String? = null,
    val gamedata: GameDataModel? = null
)
val userItems = listOf(
    CustomGameData(
        "p1",

        )
)

