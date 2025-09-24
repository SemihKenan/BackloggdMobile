package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Screens.GameItem
import com.example.myapplication.Screens.GameListScreen
import com.example.myapplication.Screens.GamePage
import com.example.myapplication.Screens.HomeScreen
import com.example.myapplication.Screens.Settings
import com.example.myapplication.Screens.SettingsTabsScreens.AccountPage
import com.example.myapplication.data.oyun
import com.example.myapplication.ui.theme.AppbarRenk
import com.example.myapplication.ui.theme.YaziRenk
import com.example.myapplication.widget.proflieSections.ProfileScreen
import com.google.firebase.firestore.CollectionReference

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)
val bottomNavItems = listOf(
    BottomNavItem("Profile", Icons.Default.Person, "profile_route"),
    BottomNavItem("Home", Icons.Default.Home, "home_route"),
    BottomNavItem("Settings", Icons.Default.Settings, "settings_route")
)
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
                    composable("game_route") { GameItem() }
                    composable("settings_route") { Settings(navController) }
                    composable("home_route") { HomeScreen() }
                    composable("profile_route") { ProfileScreen()}
                    composable("account_route") { AccountPage() }
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