package com.example.myapplication

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.AllGames
import com.example.myapplication.data.Game

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val numberOfItemsPerRow = 3
    val spacingBetweenItems = 4.dp
    val lazyRowHorizontalPadding = 8.dp*2
    val availableWithForRow = screenWidth - lazyRowHorizontalPadding
    val totalSpacingInRow=spacingBetweenItems*(numberOfItemsPerRow-1)
    val boxWidth = (availableWithForRow - totalSpacingInRow) / numberOfItemsPerRow
    val boxHeight = screenHeight / 5.4f
    val gameRows= AllGames.chunked(numberOfItemsPerRow)
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        state = rememberLazyListState(),
        reverseLayout = false,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        flingBehavior = ScrollableDefaults.flingBehavior(),
        userScrollEnabled = true
    ) {
        items(gameRows) { gameRow ->
            Row(
                Modifier
                    .fillMaxWidth(),
                    //.padding(horizontal = 3.dp),
                horizontalArrangement = Arrangement.spacedBy(spacingBetweenItems),
            ) {
                gameRow.forEach {game ->
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight()
                            //.width(boxWidth)
                    ){
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(MaterialTheme.shapes.medium)
                                .height(boxHeight)
                                .border(3.dp, Color.Black)
                                .background(color = MaterialTheme.colorScheme.secondary)
                        ) {
                            Text(
                                text = game.genre,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .align(Alignment.Center),
                                Color.White,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 8.dp)
                        ) {
                            Text(text = game.name)
                        }
                    }
                }
if (gameRow.size<numberOfItemsPerRow&&gameRow.isNotEmpty()){
    for (i in gameRow.size until numberOfItemsPerRow)
        Spacer(Modifier.width(boxWidth))
}
            }
        }
    }
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
