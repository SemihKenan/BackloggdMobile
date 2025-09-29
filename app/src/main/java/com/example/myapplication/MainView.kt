package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.data.bottomNavItems
import com.example.myapplication.screens.GamePage
import com.example.myapplication.screens.HomeScreen
import com.example.myapplication.screens.Profil
import com.example.myapplication.screens.Settings
import com.example.myapplication.screens.mainMenuScreens.AllGames
import com.example.myapplication.screens.mainMenuScreens.Category
import com.example.myapplication.screens.mainMenuScreens.NewReleases
import com.example.myapplication.screens.mainMenuScreens.UpcomingGames
import com.example.myapplication.ui.theme.AppbarRenk
import com.example.myapplication.ui.theme.YaziRenk


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.wrapContentSize(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                {
                    val currentItem = bottomNavItems.find { it.route == currentRoute?.route }
                    Text(currentItem?.title ?: "Başlık Yok")
                },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null && bottomNavItems.none
                        { it.route == currentRoute?.route }
                    ) {
                        IconButton(
                            onClick = { navController.popBackStack() }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Geri"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults
                    .topAppBarColors(
                        navigationIconContentColor = Color.Red,
                        containerColor = AppbarRenk,
                        titleContentColor = YaziRenk
                    ),

                modifier = Modifier
            )
        },
        bottomBar = {
            BottomAppBar {
                bottomNavItems.forEach { screen ->
                    val selected = currentRoute?.route == screen.route ||
                            currentRoute?.parent?.route == screen.route
                    IconButton(
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        modifier = Modifier.weight(1f,fill = true))
                    {
                        Column {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.title,
                                tint = if (selected) Color.Red else Color.Gray
                            )
                        }
                    }
                }
            }
        },
        content =
            { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .wrapContentSize()
            )
            {
                NavHost(
                    navController = navController,
                    startDestination = "home_route",
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.wrapContentSize(),
                )
                {
                    composable("game_route") { GamePage() }
                    composable("settings_route") { Settings(navController) }
                    composable("home_route") { HomeScreen() }
                    composable("profile_route") { Profil() }
                    composable("AllGames_Route") { AllGames() }
                    composable("GameCategory_Route") { Category() }
                    composable("NewReleases_Route") { NewReleases() }
                    composable("Settings_route") { Settings(navController) }
                }
            }
        }
    )
}

@Preview
@Composable
private fun MainviewPrev() {
    MainView()
}