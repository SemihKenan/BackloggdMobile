package com.example.myapplication.screens

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.VM.user_VM
import com.example.myapplication.data.ProfileFilter
import com.example.myapplication.data.profileFilterButtonsDataList
import com.example.myapplication.widget.proflieSections.ProfileFilterButton

const val userGamePerRow=2


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profil(
    userVm: user_VM = viewModel(),
    profileId: String
    )
{

    val userList by userVm.users.collectAsState()
    val games by userVm.repogames.collectAsState()
    val activeUser = userList.firstOrNull()
    val loaded = remember { mutableStateOf(false) }
    LaunchedEffect(profileId) {
            userVm.loadUserWithGames(profileId)
            loaded.value = true
    }
    if (activeUser!=null) {
        var currentSelectedFilter by remember { mutableStateOf(ProfileFilter.AllGames) }


        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
        ){
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
                } else {
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
                            text = activeUser.profilename,
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Bold
                        )
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
                                text = "Oynanan oyunlar: ${activeUser.profileGamesPlayed.size}",
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
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                    }
                }
            }

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
                val filteredGames =
                    when (currentSelectedFilter) {
                        ProfileFilter.AllGames -> games
                        ProfileFilter.Favorites -> games.filter { it.id in (activeUser?.profilfavPlayed ?: emptyList()) }
                        ProfileFilter.RecentlyPlayed -> games.filter { it.id in (activeUser?.profileRecentlyPlayed ?: emptyList()) }
                    }
                val playedGameinRow = filteredGames.chunked(userGamePerRow)
                items(playedGameinRow) { playedGamesItem ->
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        filteredGames.forEach { chunkedGames -> //chunka almıyor profilde gözükmüyor, eğer kullanılmazsa sorunsuz çalışıyor.
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .wrapContentHeight()
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .border(3.dp, Color.Black)
                                        .background(color = MaterialTheme.colorScheme.secondary)
                                )
                                Text(text = chunkedGames.gameName)
                            }
                        }
                            if (filteredGames.size % 2 != 0) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

        }
    else{
        Text("Kullanıcı Bulunamadı",
            fontWeight = FontWeight.Bold,
        )
    }
}





