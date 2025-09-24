package com.example.myapplication.Screens

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.CollectionReference

@Composable
fun GamePage() {
    Column {
        LazyRow(
            state = rememberLazyListState(),
            userScrollEnabled = true,
            flingBehavior = ScrollableDefaults.flingBehavior(),
            reverseLayout = false,
            modifier = Modifier,
        )
        {
            item {
                Text("App Photos")
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            Box(modifier = Modifier)
            {
                Text("Enter Comments")
            }
            Box(modifier = Modifier)
            {
                Text("Konusu and tags")
            }
        }
        Column { Text("comment Line") }
    }

}

@Preview
@Composable
private fun GamePageView() {
GamePage()
}