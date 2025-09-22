package com.example.myapplication.data

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