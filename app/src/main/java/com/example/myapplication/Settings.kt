package com.example.myapplication

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


val Titles = listOf("Notifications", "Account","Privacy")
val settingTabs = listOf("Game Notifications", "Social Notifications", "Other Notifications")
val accountTabs = listOf("Theme", "Account Info", "Language")
val privacyTabs = listOf("Profile Privacy", "Change Password", "Others")
@Composable
fun Settings(navController: NavController) {
    Scaffold(
        content = { paddingValues -> LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.padding(paddingValues),
            flingBehavior = ScrollableDefaults.flingBehavior(),
            userScrollEnabled = true,
            reverseLayout = false,
            content = {
                items(Titles.size)
                {
                    index->
                    TextButton(
                        onClick = {navController.navigate("game_route") }
                    ) {
                        Row {
                            Text("Deneme")
                        }
                    }
                    val currentTitle = Titles[index]
                    Column { Text(currentTitle) }
                    val tabstoShow = when (currentTitle) {
                        "Notifications"-> settingTabs
                        "Account" -> accountTabs
                        "Privacy" -> privacyTabs
                        else -> emptyList()
                    }
                    tabstoShow.forEach { tabTitle ->
                        Text(tabTitle)
                    }
                    if (index < Titles.size - 1) {
                        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
        )}
    )
}
