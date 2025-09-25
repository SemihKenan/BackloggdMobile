package com.example.myapplication.data

import com.google.firebase.firestore.FirebaseFirestore


class GameRepository {
    private val db = FirebaseFirestore.getInstance()
    private val gameCollection = db.collection("GameList")

    fun getGames(onResult: (List<GameDataModel>) -> Unit) {
        gameCollection
            .get()
            .addOnSuccessListener { result ->
                val oyunlar = result.toObjects(GameDataModel::class.java)
                onResult(oyunlar)
            }
            .addOnFailureListener {
                onResult(emptyList())
            }
    }
    fun pushGames(onResult: (List<GameDataModel>),onComplete: (Boolean) -> Unit){
            AllGamesList.forEach { dbGame ->
                gameCollection
                    .document(dbGame.gameName)
                    .set(dbGame)
                    .addOnSuccessListener { onComplete(true) }
                    .addOnFailureListener { onComplete(false) }
            }
    }
    fun removeDuplicates(onComplete:(Boolean)-> Unit) {
        gameCollection
            .get()
            .addOnSuccessListener { snapshot ->
                val seenIds = mutableSetOf<String>()
                val batch = db.batch()

                snapshot.documents.forEach { doc ->
                    val samegame = doc.toObject(GameDataModel::class.java)
                    if (samegame != null) {
                        if (seenIds.contains(samegame.gameName)) {
                            // duplicate -> sil
                            doc.reference.delete()
                        } else {
                            seenIds.add(samegame.gameName)
                        }
                    }
                }
                batch.commit()
                    .addOnSuccessListener { onComplete(true) }
                    .addOnFailureListener { onComplete(false) }
            }
    }
}
