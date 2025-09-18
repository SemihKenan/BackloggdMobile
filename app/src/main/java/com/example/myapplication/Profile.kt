package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.YaziRenk

val profileTitles= listOf("Recent Comment","Wish List","Favorites")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profil() {
    Column(
        modifier = Modifier.background(color = Color.White)){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding()
                .fillMaxWidth()
                .background(color = Color.Black)
        )

        {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(7.dp)
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.White)


            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    tint = Color.DarkGray,
                    modifier = Modifier.size(60.dp),
                    contentDescription = "Profil Resmi",
                )
            }
            Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.CenterEnd) {
                Text(
                    modifier = Modifier.padding(end = 7.dp),
                    color = YaziRenk,
                    text = "Oynanan Oyunlar:120"
                )
            }

        }
        LazyColumn(
            Modifier,
            state = rememberLazyListState(),
            reverseLayout = false,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            flingBehavior = ScrollableDefaults.flingBehavior(),
            userScrollEnabled = false
        )
            {
                items(count = profileTitles.size)
                {
                    index ->Text(profileTitles[index])
                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        state = rememberLazyListState(),
                        reverseLayout = false,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        flingBehavior = ScrollableDefaults.flingBehavior(),
                        userScrollEnabled =true
                    )
                    {
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

@Preview
@Composable
private fun ProfilePrev() {
    Profil()

}