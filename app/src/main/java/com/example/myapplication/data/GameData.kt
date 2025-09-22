package com.example.myapplication.data



data class Game(
    val id: String,
    //val ownerid: String? = null,
    val gameName: String,
    val imageUrl: String? = null,
    val genre: String,
    val reviewDate: String?=null,
    val isFavorite: Boolean = false
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
    Game("g10","Spider-Man",null,"Action"),
)




