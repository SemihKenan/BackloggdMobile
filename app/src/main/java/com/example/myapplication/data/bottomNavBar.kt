package com.example.myapplication.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

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
