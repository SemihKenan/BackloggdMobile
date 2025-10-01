package com.example.myapplication.screens

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.myapplication.data.GameDataModel

@Composable
fun GameScreen(navController: NavController? = null) {

    val game = navController?.previousBackStackEntry?.savedStateHandle?.get<GameDataModel>("gameItem")
    game?.let {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.padding(),
            flingBehavior = ScrollableDefaults.flingBehavior(),
            userScrollEnabled = true,
            reverseLayout = false,
        ) {
            item{
            LazyRow(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                state = rememberLazyListState(),
                reverseLayout = false,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                flingBehavior = ScrollableDefaults.flingBehavior(),
                userScrollEnabled = true
            ) {
                item {
                    AsyncImage(
                        model = game.imageUrl,
                        contentDescription = "resim"
                    )
                }
                }
            }
        }
        }
    }




@Preview
@Composable
private fun GamePageView() {
GameScreen(null)
}