package com.example.myapplication.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameDataModel(
    val id: String = "",
    val ownerid: List<String> = emptyList(),
    val gameName: String = "",
    val imageUrl: List<String> = emptyList(),
    val genre: String = "",
    val reviewDate: String?=null,
) : Parcelable

//val playedGames: Int = activeUser.profileOwnerId.size
val AllGamesList=listOf(
    GameDataModel("1",listOf("p1","p2"),"CyberPunk",listOf(""),"Action"),
    GameDataModel("2",listOf("p1"),"Batman Arkham Knight",listOf(""),"Action"),
    GameDataModel("3",listOf("p1","p2"),"Zelda BOTW",listOf(""),"Action"),
    GameDataModel("4",listOf("p1","p2"),"Hollow Knight",listOf(""),"Souls Like"),
    GameDataModel("5",listOf("p1","p2"),"Shovel Knight",listOf(""),"Souls Like"),
    GameDataModel("6",listOf("p1","p2"),"Baldur's Gate",listOf(""),"RPG"),
    GameDataModel("7",listOf("p1"),"Elden Ring",listOf(""),"Souls Like"),
    GameDataModel("8",listOf("p1","p2"),"Prison Architect",listOf(""), "Strategy"),
    GameDataModel("9",listOf("p1"),"Satisfactory",listOf(""),"Automation"),
    GameDataModel("10",listOf("p1"),"Spider-Man",listOf(""),"Action"),
)

val UserAllGamesList=listOf(
    GameDataModel("1",listOf("p1"),"CyberPunk",listOf(""),"Action"),
    GameDataModel("2",listOf("p1"),"Batman Arkham Knight",listOf(""),"Action"),
    GameDataModel("3",listOf("p1"),"Zelda BOTW",listOf(""),"Action"),
    GameDataModel("4",listOf("p1","p2"),"Hollow Knight",listOf(""),"Souls Like"),
    GameDataModel("5",listOf("p1","p2"),"Shovel Knight",listOf(""),"Souls Like"),
    GameDataModel("6",listOf("p1","p2"),"Baldur's Gate",listOf(""),"RPG"),
    GameDataModel("7",listOf("p1"),"Elden Ring",listOf(""),"Souls Like"),
    GameDataModel("8",listOf("p1","p2"),"Prison Architect",listOf(""), "Strategy"),
    GameDataModel("9",listOf("p1","p2"),"Satisfactory",listOf(""),"Automation"),
    GameDataModel("10",listOf("p1","p2"),"Spider-Man",listOf(""),"Action"),
)

val RecentlyPlayedGames=listOf(
    GameDataModel("1",listOf("p1","p2"),"bu recently CyberPunk",listOf(""),"Action"),
    GameDataModel("2",listOf("p1"),"Batman Arkham Knight",listOf(""),"Action"),
    GameDataModel("3",listOf("p1","p2"),"Zelda BOTW",listOf(""),"Action"),
    GameDataModel("4",listOf("p1","p2"),"Hollow Knight",listOf(""),"Souls Like"),
    GameDataModel("5",listOf("p1","p2"),"Shovel Knight",listOf(""),"Souls Like"),
    GameDataModel("6",listOf("p1","p2"),"Baldur's Gate",listOf(""),"RPG"),
    GameDataModel("7",listOf("p1"),"Elden Ring",listOf(""),"Souls Like"),
    GameDataModel("8",listOf("p1","p2"),"Prison Architect",listOf(""), "Strategy"),
    GameDataModel("9",listOf("p1"),"Satisfactory",listOf(""),"Automation"),
    GameDataModel("10",listOf("p1"),"Spider-Man",listOf(""),"Action"),
)


data class CustomGameData(
    val ownerId: String? = null,
    val gamedata: GameDataModel? = null
)
val userItems = listOf(
    CustomGameData(
        "p1")
)

