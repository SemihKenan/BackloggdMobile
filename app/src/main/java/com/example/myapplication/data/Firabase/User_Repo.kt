package com.example.myapplication.data.Firabase
import com.example.myapplication.data.UserList
import com.example.myapplication.data.userProfile
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository{
    private val db = FirebaseFirestore.getInstance()
    private val userCollection= db.collection("Users")
    private val batch = db.batch()

    fun getUsers(onResult: (List<UserList>) -> Unit) {
        userCollection
            .get()
            .addOnSuccessListener { result ->
                val Users = result.toObjects(UserList::class.java)
                onResult(Users)
            }
            .addOnFailureListener {
                onResult(emptyList())
            }
    }



    fun uploadUsers(onResult: List<UserList>, onComplete: (Boolean) -> Unit){
        userProfile.forEach { dbUsers ->
            val docRef= userCollection.document(dbUsers.profileId)
            batch.set(docRef,dbUsers)
        }
        batch.commit()
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

}