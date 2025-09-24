package com.example.myapplication.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.data.ProfileFilter
import com.example.myapplication.data.RecentlyPlayedGames
import com.example.myapplication.data.UserAllGamesList
import com.example.myapplication.data.activeUser
import com.example.myapplication.data.playedGames
import com.example.myapplication.data.profileFilterButtonsDataList
import com.example.myapplication.widget.proflieSections.ProfileFilterButton
import kotlin.collections.chunked
const val userGamePerRow=2
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profil(
    profileNavController: NavHostController
    )
    {

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
            if (activeUser.profileImage != null) {
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
                  text = activeUser.profileUsername,
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
                        "Oynanan Oyunlar: $playedGames",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.Create, contentDescription = "Yapılan Yorumlar", tint = MaterialTheme.colorScheme.secondary)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Yorum Sayısı: ${activeUser.profileReviewedGames}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

        }
        var currentSelectedFilter by remember { mutableStateOf(ProfileFilter.AllGames) }
        val profileNavController = rememberNavController()
        //Filter Buttons
        Row(Modifier
            .fillMaxWidth()
            .padding(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            profileFilterButtonsDataList.forEach {buttonData ->

                ProfileFilterButton(
                    text = buttonData.text,
                    icon = buttonData.icon,
                    isSelected = currentSelectedFilter==buttonData.filterType,
                    onClick = {
                        currentSelectedFilter = buttonData.filterType

                    }
                )
            }
        }
        val gamesList = when (currentSelectedFilter) {
            ProfileFilter.AllGames -> {
                UserAllGamesList
            }
            ProfileFilter.Favorites -> {
                UserAllGamesList
            }
            ProfileFilter.RecentlyPlayed -> {
                RecentlyPlayedGames
            }
        }
        val playedGameInRow = gamesList.chunked(userGamePerRow)
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            state = rememberLazyListState(),
            reverseLayout = false,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            flingBehavior = ScrollableDefaults.flingBehavior(),
            userScrollEnabled = true
        )
        {
            items(playedGameInRow) { profileGameItem ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    profileGameItem.forEach { profileGame ->

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                        )
                        {
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .border(3.dp, Color.Black)
                                .background(color = MaterialTheme.colorScheme.secondary)
                            )
                            Text(text = profileGame.gameName)
                        }
                        if (profileGameItem.size%2 != 0){
                            Spacer(modifier = Modifier.weight(1f))
                        }

                    }
                }
            }
        }

    }
}



