package com.example.myapplication.data.Firabase
import com.example.myapplication.data.ProfileDataModel
import com.example.myapplication.data.userProfile
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository{
    private val db = FirebaseFirestore.getInstance()
    private val userCollection= db.collection("Users")
    private val batch = db.batch()

    fun getUser(profileId: String, onResult: (ProfileDataModel?) -> Unit) {
        db.collection("Users")
            .whereEqualTo("profileId", profileId)
            .get()
            .addOnSuccessListener { snapshot ->
                val user = snapshot.toObjects(ProfileDataModel::class.java).firstOrNull()
                onResult(user)
            }
            .addOnFailureListener {
                onResult(null)
            }
    }



    fun uploadUsers(onResult: List<ProfileDataModel>, onComplete: (Boolean) -> Unit){
        userProfile.forEach { dbUsers ->
            val docRef= userCollection.document(dbUsers.profileId)
            batch.set(docRef,dbUsers)
        }
        batch.commit()
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

}