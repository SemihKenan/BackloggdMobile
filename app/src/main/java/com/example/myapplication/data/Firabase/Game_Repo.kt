package com.example.myapplication.data.Firabase

import com.example.myapplication.data.AllGamesList
import com.example.myapplication.data.GameDataModel
import com.example.myapplication.data.UserList
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User


class GameRepository {
    private val db = FirebaseFirestore.getInstance()
    private val gameCollection = db.collection("GameList")
    private val userCollection = db.collection("Users")
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
    fun getUserGames(
        profileId:String,
        onResult: (
            List<UserList>,
            List<GameDataModel>)-> Unit
    ){
        userCollection
            .whereEqualTo("profileId",profileId)
            .get()
            .addOnSuccessListener { userResult ->
                val listUser = userResult.toObjects(UserList::class.java)

                if (listUser != null){
                    gameCollection
                        .whereEqualTo("ownerId", profileId )
                        .get()
                        .addOnSuccessListener { result ->
                            val userGames = result.toObjects(GameDataModel::class.java)
                            onResult(listUser,userGames)
                        }
                        .addOnFailureListener { onResult(listUser,emptyList()) }
                }
                else{
                    onResult(emptyList(),emptyList())
                }
            }
            .addOnFailureListener { onResult(emptyList(),emptyList()) }
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
    fun getGamesByIds(
        gameIds: List<String>,
        onResult: (List<GameDataModel>) -> Unit
    ) {
        if (gameIds.isEmpty()) {
            onResult(emptyList())
            return
        }

        gameCollection
            .whereIn("id", gameIds) // Firestore'da id alanına göre arama
            .get()
            .addOnSuccessListener { snapshot ->
                val games = snapshot.toObjects(GameDataModel::class.java)
                onResult(games)
            }
            .addOnFailureListener {
                onResult(emptyList())
            }
    }
}


