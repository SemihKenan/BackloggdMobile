package com.example.myapplication.Screens

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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.MainView
import com.example.myapplication.data.GameDataModel
import com.example.myapplication.data.GameRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(repository: GameRepository = GameRepository()) {
    var games by remember { mutableStateOf<List<GameDataModel>>(emptyList()) }

    LaunchedEffect(Unit) {
        repository.getGames { fetchedGames ->
            games = fetchedGames
        }
    }
    val playedGameInRow = games.chunked(userGamePerRow)
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
//    LazyColumn(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxSize(),
//        state = rememberLazyListState(),
//        reverseLayout = false,
//        verticalArrangement = Arrangement.spacedBy(20.dp),
//        flingBehavior = ScrollableDefaults.flingBehavior(),
//        userScrollEnabled = true
//    ) {
//        items(playedGameInRow) { gamelist ->
//            Row(
//                Modifier
//                    .fillMaxWidth(),
//                //.padding(horizontal = 3.dp),
//                horizontalArrangement = Arrangement.spacedBy(4.dp),
//            ) {
//                Column(
//                    modifier = Modifier
//                        .weight(1f)
//                        .wrapContentHeight()
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .padding(3.dp)
//                            .fillMaxWidth()
//                            .height(150.dp)
//                            .clip(MaterialTheme.shapes.medium)
//                            .border(3.dp, Color.Black)
//                            .background(color = MaterialTheme.colorScheme.secondary)
//                    ) {
//                        Text(
//                            text = gamelist.gameName,
//                            modifier = Modifier
//                                .padding(5.dp)
//                                .align(Alignment.Center),
//                            Color.White,
//                            textAlign = TextAlign.Center,
//                            style = MaterialTheme.typography.bodyLarge
//                        )
//                    }
//                    Row(
//                        modifier = Modifier
//                            .padding(top = 8.dp)
//                    ) {
//                        Text(text = gamelist.gameName)
//                    }
//                }
//            }
//        }
//    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MainView()
}
//fun unitCallback() {
//    val listener: () -> Unit = {
//
//    }
//
//}



