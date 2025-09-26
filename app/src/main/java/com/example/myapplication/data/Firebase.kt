package com.example.myapplication.data

import com.google.firebase.firestore.FirebaseFirestore


class GameRepository {
    private val db = FirebaseFirestore.getInstance()
    private val gameCollection = db.collection("GameList")
    private val batch = db.batch()
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

    fun pushGames(onResult: (List<GameDataModel>), onComplete: (Boolean) -> Unit) {
        AllGamesList.forEach { dbGame ->
            gameCollection
                .document(dbGame.gameName)
                .set(dbGame)
                .addOnSuccessListener { onComplete(true) }
                .addOnFailureListener { onComplete(false) }
        }
    }

    fun removeDuplicates(onComplete: (Boolean) -> Unit) {
        gameCollection
            .get()
            .addOnSuccessListener { snapshot ->
                val seenIds = mutableSetOf<String>()

                snapshot.documents.forEach { doc ->
                    val samegame = doc.toObject(GameDataModel::class.java)
                    if (samegame != null) {
                        if (seenIds.contains(samegame.id)) {
                            // duplicate -> sil
                            doc.reference.delete()
                        } else {
                            seenIds.add(samegame.id)
                        }
                    }
                }
                batch.commit()
                    .addOnSuccessListener { onComplete(true) }
                    .addOnFailureListener { onComplete(false) }
            }
    }
    fun clearGameListCollection(onComplete: (Boolean) -> Unit) {
        gameCollection
            .get()
            .addOnSuccessListener { snapshot ->
                snapshot.documents.forEach { doc ->
                    batch.delete(doc.reference)
                }
                batch.commit()
                    .addOnSuccessListener { onComplete(true) }
                    .addOnFailureListener { onComplete(false) }
            }
            .addOnFailureListener { onComplete(false) }
    }
}
