package com.example.myapplication

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
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


                }
            }
    }
}

@Preview
@Composable
private fun ProfilePrev() {
    Profil()

}