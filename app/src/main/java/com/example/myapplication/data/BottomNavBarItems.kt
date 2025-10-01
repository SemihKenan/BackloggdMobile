package com.example.myapplication.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavBarItems(
    val title: String,
    val icon: ImageVector,
    val route: String
)
val bottomNavItemsList = listOf(
    BottomNavBarItems("Profile", Icons.Default.Person, "profile_route"),
    BottomNavBarItems("Home", Icons.Default.Home, "home_route"),
    BottomNavBarItems("Settings", Icons.Default.Settings, "settings_route")
)
