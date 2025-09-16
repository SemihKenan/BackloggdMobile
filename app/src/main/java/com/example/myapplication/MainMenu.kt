package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
    ) {
        val headers = listOf("Popular", "Upcoming", "Popular")
        Column {
            LazyColumn(
                modifier = Modifier.padding(8.dp),
                state = rememberLazyListState(),
                reverseLayout = false,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                flingBehavior = ScrollableDefaults.flingBehavior(),
                userScrollEnabled = true
            ) {
                items(headers.size) { index ->
                    Text(text = headers[index], modifier = Modifier, Color.White)
                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        state = rememberLazyListState(),
                        reverseLayout = false,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        flingBehavior = ScrollableDefaults.flingBehavior(),
                        userScrollEnabled = true
                    ) {
                        items(10) { index ->
                            Box(
                                modifier = Modifier
                                    .border(5.dp,Color.Black)
                                    .size(height = 210.dp, width = 150.dp)
                                    .background(color = Color.DarkGray)
                            ) {
                                Text(
                                    "Game_Image $index",
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .align(Alignment.Center),
                                    Color.White,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(
                                    "Game Name $index",
                                    Modifier
                                        .align(Alignment.BottomStart)
                                        .padding(10.dp),
                                    Color.White
                                )

                            }
                        }

                    }
                }
            }
        }

    }
}
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
//fun unitCallback() {
//    val listener: () -> Unit = {
//
//    }
//
//}
