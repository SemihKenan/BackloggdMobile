package com.example.myapplication.data

data class UserList(
    val profileId: String = "",
    val profilename: String = "",
    val profileImage: String?=null,
    val profileGamesPlayed: List<String> = emptyList(),
    val profileReviewedGames: String?=null
)

val userProfile= listOf<UserList>(
    UserList(
    "p1",
    "Username127",
    null,
    listOf("g1","g2","g4","g7","g8","g9"),
    "5"
),
    UserList(
        "p2",
        "Username712",
        null,
        listOf("g3","g6","g4","g2","g8","g9","g1"),
        "3"
    )
)
//val activeUser = userProfile[1]

//val playedGames: Int = activeUser.profileGamesPlayed.size