package com.example.myapplication.data

data class Game(
    val id:String,
    val title:String,
    val imageurl:String?=null,
    val genre: String
)
val mockGames=listOf(
    Game("1","CyberPunk",null,"Action"),
    Game("2","Batman Arkham Knight",null,"Action"),
    Game("3","Zelda BOTW",null,"Action"),
    Game("4","Hollow Knight",null,"Souls Like"),
    Game("5","Shovel Knight",null,"Souls Like"),
    Game("6","Baldur's Gate",null,"RPG"),
    Game("7","Elden Ring",null,"Souls Like"),
    Game("8","Prison Architect",null,"Base Building"),
    Game("9","Satisfactory",null,"Automation"),
    Game("10","Spider-Man",null,"Action"),
)

val AlreadyCommented=listOf(
    Game("1","CyberPunk",null,"Action"),
    Game("2","Batman Arkham Knight",null,"Action"),
    Game("3","Zelda BOTW",null,"Action"),
    Game("4","Hollow Knight",null,"Souls Like"),
    Game("5","Prison Architect",null,"Base Building"),
    Game("6","Satisfactory",null,"Automation"),
    Game("7","Spider-Man",null,"Action"),
)
val Favorites=listOf(
    Game("1","Batman Arkham Knight",null,"Action"),
    Game("2","Zelda BOTW",null,"Action"),
    Game("3","Hollow Knight",null,"Souls Like"),
    Game("4","Prison Architect",null,"Base Building"),
)
val WishList=listOf(
    Game("5","Shovel Knight",null,"Souls Like"),
    Game("9","Satisfactory",null,"Automation"),
)

