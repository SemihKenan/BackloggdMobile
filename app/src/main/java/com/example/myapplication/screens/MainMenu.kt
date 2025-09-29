package com.example.myapplication.screens

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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.VM.Game_VM
import com.example.myapplication.VM.user_VM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    gameVM: Game_VM = viewModel(),
    userVM: user_VM= viewModel()
) {
    val windowInfo = LocalWindowInfo.current
    val screenSize = windowInfo.containerSize
    val screenWidthPx = screenSize.width
    val screenHeightPx = screenSize.height
    val density = LocalDensity.current
    val screenWidthDp = with(density){screenWidthPx.toDp()}
    val screenHeightDp = with(density){screenHeightPx.toDp()}
    val mockgames by gameVM.games.collectAsState()
    val mockUsers by userVM.users.collectAsState()
    Column(modifier = Modifier) {
        LazyRow(
        modifier = Modifier
            //.weight(1f)
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        state = rememberLazyListState(),
        reverseLayout = false,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        flingBehavior = ScrollableDefaults.flingBehavior(),
        userScrollEnabled = true
        ){
            items(mockgames) { GameItems ->
                Column(
                    modifier = Modifier
                        //.weight(1f)
                    ){
                        Box(modifier = Modifier
                            .height(screenHeightDp/4)
                            .width(screenWidthDp/2)
                            .border(3.dp, Color.Black)
                            .background(color = MaterialTheme.colorScheme.secondary)
                        )
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = GameItems.gameName)
                    }
            }
        }
        Row(Modifier
            .fillMaxWidth()
            .padding(10.dp),
            Arrangement.spacedBy(6.dp)
        )
        {
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    gameVM.uploadMockData(mockgames)
                }
            ) {
                Text("oyun upload et")
            }
            Button(
                modifier = Modifier
                        .weight(1f),
                onClick = {
                    gameVM.clean()
                }
            ) {
                Text("sil")
            }
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    userVM.uploadUsers(mockUsers = mockUsers)
                }
            ) {
                Text("user upload et")
            }
        }
    }

}

@Preview
@Composable
fun HomeScreentestPreview() {
    HomeScreen()
}
//fun unitCallback() {
//    val listener: () -> Unit = {
//
//    }
//
//}



