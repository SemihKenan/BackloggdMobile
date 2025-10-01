package com.example.myapplication.data.Firabase

import com.example.myapplication.data.GameDataModel
import com.example.myapplication.data.UserList
import com.google.firebase.firestore.FirebaseFirestore


class GameRepository {
    private val db = FirebaseFirestore.getInstance()
    private val gameCollection = db.collection("GameList")
    private val userCollection = db.collection("Users")
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
                    gameCollection.whereArrayContains("ownerid",profileId)
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
    fun getGamesByIds(
        gameIds: List<String>,
        onResult: (List<GameDataModel>) -> Unit
    ) {
        if (gameIds.isEmpty()) {
            onResult(emptyList())
            return
        }

        gameCollection
            .whereIn("id", gameIds)
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


