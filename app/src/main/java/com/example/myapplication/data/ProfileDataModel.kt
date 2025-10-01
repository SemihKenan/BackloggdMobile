package com.example.myapplication.data

object Constants {
    const val activeProfileId = "p2"}

    data class ProfileDataModel(
        val profileId: String = "",
        val profilename: String = "",
        val profileImage: String? = null,
        val profileGamesPlayed: List<String> = emptyList(),
        val profileRecentlyPlayed: List<String> = emptyList(),
        val profilfavPlayed: List<String> = emptyList(),
        val profileReviewedGames: String? = null
    )

    val userProfile = listOf<ProfileDataModel>(
        ProfileDataModel(
            "p1",
            "Username127",
            null,
            listOf("1", "2", "4", "7", "8", "9"),
            listOf("1", "7", "8"),
            listOf("7", "8", "9"),
            "5"
        ),
        ProfileDataModel(
            "p2",
            "Username712",
            null,
            listOf("3", "6", "3", "2", "8", "9", "1"),
            listOf("3", "2", "1"),
            listOf("8", "9", "1"),
            "3"
        )
    )

//val activeUser = userProfile[1]

//val playedGames: Int = activeUser.profileGamesPlayed.size