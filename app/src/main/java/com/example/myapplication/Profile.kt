package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.ProfileFilter
import com.example.myapplication.data.profileFilterButtonsDataList
import com.example.myapplication.data.userProfile
import com.example.myapplication.widget.proflieSections.ProfileFilters
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profil(selectedFilter: ProfileFilter,
           onFilterSelected: (ProfileFilter) -> Unit) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
    //User Profile Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    MaterialTheme.colorScheme.surfaceVariant,
                    MaterialTheme.shapes.small
                )
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        )

        {
            if (userProfile.imageUrl != null) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    "Profil Resmi",
                    Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.secondaryContainer),
                    contentScale = ContentScale.Crop
                )
            } else
            {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profil Resmi",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .padding(16.dp),
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            //User Info
            Column(
                modifier = Modifier.weight(1f)
            )
            {
                Text(
                  text = userProfile.username,
                  style = MaterialTheme.typography.headlineSmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(8.dp))
                Row(verticalAlignment =Alignment.CenterVertically ) {
                    Spacer(
                        modifier = Modifier.width(4.dp)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Outlined.PlayArrow,
                        contentDescription = "Oynanan Oyunlar",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "Oynanan Oyunlar: ${userProfile.gamesPlayed}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.Create, contentDescription = "Yapılan Yorumlar", tint = MaterialTheme.colorScheme.secondary)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Yorum Sayısı: ${userProfile.commentsMade}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

        }
        //Filter Buttons
        Row(Modifier
            .fillMaxWidth()
            .padding(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            profileFilterButtonsDataList.forEach {buttonData ->
                ProfileFilters(
                    text = buttonData.text,
                    icon = buttonData.icon,
                    isSelected = selectedFilter==buttonData.filterType,
                    onClick = {onFilterSelected(buttonData.filterType)}
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
            }
    }
}

@Preview
@Composable
private fun ProfilePrev() {
    Profil(selectedFilter = ProfileFilter.AllActivity, onFilterSelected = {})
}

/*
Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(
                    onClick = {

                    }
                )
                {
                    Text("Recent")
                }
                Text(
                    "Favorite"
                )
            }
            }
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
 */