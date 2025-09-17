package com.example.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


val settingsTitles = listOf("Notifications", "Account","Privacy")
val settingTabs = listOf("Game Notifications", "Social Notifications", "Other Notifications")

@Composable
fun Settings() {
    Scaffold(
        content = { paddingValues -> Column(
            Modifier
                .padding(paddingValues)
        )
        {
            Text("Bildirimler")
            Box {
                Column {
                    Text("Oyun Bilirimleri")
                    Text("Sosyal Bildirimler")
                    }
                }
            }
        }
    )


}

@Preview
@Composable
private fun SettingsPrev() {
    Settings()
}