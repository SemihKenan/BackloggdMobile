package com.example.myapplication.data

import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore


data class GameList(
    val id: String?=null,
    //val ownerid: String? = null,
    val gameName: String,
    val imageUrl: String? = null,
    val genre: String,
    val reviewDate: String?=null,
)

val AllGamesList=listOf(
    GameList("","CyberPunk",null,"Action"),
    GameList("","Batman Arkham Knight",null,"Action"),
    GameList("","Zelda BOTW",null,"Action"),
    GameList("","Hollow Knight",null,"Souls Like"),
    GameList("","Shovel Knight",null,"Souls Like"),
    GameList("","Baldur's Gate",null,"RPG"),
    GameList("","Elden Ring",null,"Souls Like"),
    GameList("","Prison Architect",null, "Strategy"),
    GameList("","Satisfactory",null,"Automation"),
    GameList("","Spider-Man",null,"Action"),
    GameList("","Spider-Man",null,"Action"),
)

val UserAllGamesList=listOf(
    GameList("","CyberPunk",null,"Action"),
    GameList("","Batman Arkham Knight",null,"Action"),
    GameList("","Zelda BOTW",null,"Action"),
    GameList("","Hollow Knight",null,"Souls Like"),
    GameList("","Shovel Knight",null,"Souls Like"),
    GameList("","Baldur's Gate",null,"RPG"),
    GameList("","Elden Ring",null,"Souls Like"),
    GameList("","Prison Architect",null, "Strategy"),
    GameList("","Satisfactory",null,"Automation"),
    GameList("","Spider-Man",null,"Action"),
    GameList("","Spider-Man",null,"Action"),
)

val RecentlyPlayedGames=listOf(
    GameList("","CyberPunk bu recently",null,"Action"),
    GameList("","Batman Arkham Knight",null,"Action"),
    GameList("","Zelda BOTW",null,"Action"),
    GameList("","Hollow Knight",null,"Souls Like"),
    GameList("","Shovel Knight",null,"Souls Like"),
    GameList("","Baldur's Gate",null,"RPG"),
    GameList("","Elden Ring",null,"Souls Like"),
    GameList("","Prison Architect",null, "Strategy"),
    GameList("","Satisfactory",null,"Automation"),
    GameList("","Spider-Man",null,"Action"),
    GameList("","Spider-Man",null,"Action"),
)




