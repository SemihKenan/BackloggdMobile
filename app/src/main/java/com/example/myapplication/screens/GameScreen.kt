package com.example.myapplication.screens

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.R
import com.example.myapplication.data.GameDataModel

@Composable
fun GameScreen(navController: NavController? = null) {
    val textFieldVal by remember { mutableStateOf("") }
    val game = navController?.previousBackStackEntry?.savedStateHandle?.get<GameDataModel>("gameItem")
    game?.let {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.padding(),
            flingBehavior = ScrollableDefaults.flingBehavior(),
            userScrollEnabled = true,
            reverseLayout = false,
        ) {
            //Oyun içi görseller
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
                val gameImages = game.imageUrl
                items(gameImages) { url ->

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(url)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.placeholder),
                        error=painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "ContentImage",
                        modifier = Modifier.size(400.dp),

                        )
                    }
                }
                HorizontalDivider()
                //Detay Kısmı (Konu, Tags, Platformlar vs



                HorizontalDivider()
                //İnceleme yapma alanı
                //İncelemeler

            }
            }

        }
    }

@Preview
@Composable
private fun GamePageView() {
GameScreen(null)
}