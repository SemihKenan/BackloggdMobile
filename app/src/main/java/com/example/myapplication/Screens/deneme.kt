package com.example.myapplication.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.VM.GetGames

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreentest(viewModel: GetGames = viewModel()) {
    val mockgames by viewModel.games.collectAsState()
    Column(modifier = Modifier) {
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
        ){
            items(mockgames) { profileGameItem ->
                Column(
                    modifier = Modifier
                        .weight(1f)
                    ){
                        Box(modifier = Modifier
                            .padding(10.dp)
                            .size(150.dp,200.dp)
                            .border(3.dp, Color.Black)
                            .background(color = MaterialTheme.colorScheme.secondary)
                        )
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = profileGameItem.gameName)
                    }
            }
        }
        Row(Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize())
        {
            Button(onClick = {
                    viewModel.uploadMockData(mockgames)
                }
            ) {
                Text("upload et")
            }
            Button(
                onClick = {
                    viewModel.clean()
                }
            ) {
                Text("sil")
            }
        }
    }

}

@Preview
@Composable
fun HomeScreentestPreview() {
    HomeScreentest()
}
//fun unitCallback() {
//    val listener: () -> Unit = {
//
//    }
//
//}



