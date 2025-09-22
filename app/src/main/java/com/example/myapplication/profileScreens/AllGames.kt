package com.example.myapplication.profileScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.AllGames
import com.example.myapplication.data.Game
import com.example.myapplication.data.activeUser
import kotlin.collections.chunked

const val userGamePerRow=2

@Composable
fun FilterAllGames(modifier: Modifier = Modifier) {

    val playedGameIds=activeUser.profileGamesPlayed
    var userPlayedGamesFullData by remember { mutableStateOf<List<Game>>(emptyList()) }
    LaunchedEffect(playedGameIds, AllGames) {
        userPlayedGamesFullData=AllGames.filter { playedgame-> playedgame.id in playedGameIds }
    }
    val playedGameInRow = userPlayedGamesFullData.chunked(userGamePerRow)
    LazyColumn(
    modifier = Modifier
        .padding(8.dp)
        .fillMaxSize(),
    state = rememberLazyListState(),
    reverseLayout = false,
    verticalArrangement = Arrangement.spacedBy(10.dp),
    flingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled = true
)
{
    items(playedGameInRow) { profileGameItem ->
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            profileGameItem.forEach { profileGame ->

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight()
                )
                {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .border(3.dp, Color.Black)
                        .background(color = MaterialTheme.colorScheme.secondary)
                    )
                    Text(text = profileGame.gameName)
                }
                if (profileGameItem.size%2 != 0){
                    Spacer(modifier = Modifier.weight(1f))
                }

            }
        }
    }
}

}