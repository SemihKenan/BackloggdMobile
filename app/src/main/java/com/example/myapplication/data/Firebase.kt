package com.example.myapplication.data

import com.google.firebase.firestore.FirebaseFirestore

data class oyun(
    val ID: String = "",
    val gameName: String = "",
    val Genre: String = "",
)

class GameRepository {
    private val db = FirebaseFirestore.getInstance()

    fun getGames(onResult: (List<oyun>) -> Unit) {
        db.collection("GameList")
            .get()
            .addOnSuccessListener { result ->
                val oyunlar = result.toObjects(oyun::class.java)
                onResult(oyunlar)
            }
            .addOnFailureListener {
                onResult(emptyList())
            }
    }
}
/* @Composable
fun GameItem(repository: GameRepository = GameRepository()) {
    var games by remember { mutableStateOf<List<oyun>>(emptyList()) }

    LaunchedEffect(Unit) {
        repository.getGames { fetchedGames ->
            games = fetchedGames
        }
    }

    LazyColumn {
        items(games) { game ->
            GameListScreen(game)
        }
    }
}

@Composable
fun GameListScreen(game:oyun) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = game.gameName, style = MaterialTheme.typography.titleMedium)
        Text(text = game.Genre, style = MaterialTheme.typography.bodyMedium)
    }
}
*/
 