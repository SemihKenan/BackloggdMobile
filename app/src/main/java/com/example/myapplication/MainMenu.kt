package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val configuration = LocalConfiguration.current // Ekran yapılandırmasını al
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val boxWidth = screenWidth / 3.4f
    val boxHeight = screenHeight / 5.4f
    val headers = listOf("Popular", "Upcoming", "Popular"," ", " ")
    LazyColumn(
        modifier = Modifier.padding(8.dp),
        state = rememberLazyListState(),
        reverseLayout = false,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        flingBehavior = ScrollableDefaults.flingBehavior(),
        userScrollEnabled = true
    ) {
        items(headers.size) { headerIndex ->
            //Text(text = headers[index], modifier = Modifier.padding(start = 3.dp, bottom = 3.dp))
            LazyRow(
                Modifier
                    .fillMaxWidth(),
                    //.padding(3.dp),
                state = rememberLazyListState(),
                reverseLayout = false,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                flingBehavior = ScrollableDefaults.flingBehavior(),
                userScrollEnabled = false
            ) {
                items(3) { itemindex ->
                    Column(
                        modifier = Modifier.wrapContentHeight()
                    ){
                        Box(
                            modifier = Modifier
                                .border(3.dp, Color.Black)
                                .width(boxWidth)
                                .height(boxHeight)
                                .background(color = Color.DarkGray)
                        ) {
                            Text(
                                "Game_Image $itemindex",
                                modifier = Modifier
                                    .padding(5.dp)
                                    .align(Alignment.Center),
                                Color.White,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 8.dp)
                        ) {
                            Text("deneme")
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
    MainView()
}
//fun unitCallback() {
//    val listener: () -> Unit = {
//
//    }
//
//}
