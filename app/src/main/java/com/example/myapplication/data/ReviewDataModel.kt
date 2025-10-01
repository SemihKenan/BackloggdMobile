package com.example.myapplication.data

import kotlin.String

data class ReviewDataModel(
    val id: String,
    val commentOwnerId: String? = null,
    val commentGameName: String,
    val commentText: String,
    val date: String
)

fun ReviewDate(gameName: String): String? {return AllGamesList.find { it.gameName == gameName }?.reviewDate}


val AlreadyCommented=listOf<ReviewDataModel>(
    ReviewDataModel(
        id = "c1",
        commentOwnerId = null,
        commentGameName = "CyberPunk",
        commentText = "Great game!",
        date = ReviewDate("CyberPunk")?:"Tarih yok"
    ),
    ReviewDataModel(
        id = "c2",
        commentOwnerId = null,
        commentGameName = "Satisfactory",
        commentText = "Amazing graphics.",
        date = ReviewDate("Satisfactory")?:"Tarih yok"
    ),
    ReviewDataModel(
        id = "c3",
        commentOwnerId = null,
        commentGameName = "Baldur's Gate",
        commentText = "Great storytelling.",
        date = ReviewDate("Baldur's Gate")?:"Tarih yok"
    )

)