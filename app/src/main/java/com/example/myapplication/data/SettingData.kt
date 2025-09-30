package com.example.myapplication.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp

data class SettingItems(
    val title: String,
    val route: String? = null
)

data class SettingSection(
    val sectionTitle: String,
    val options: List<SettingItems>
)

val allSettingSection = listOf(
    SettingSection(
        "General",
        listOf(
            SettingItems("Notifications","notifications_route"),
            SettingItems("Account"),
            SettingItems("Privacy")
        )

    ),
    SettingSection(
        "Notifications",
        listOf(
            SettingItems("Game Notifications"),
            SettingItems("Social Notifications"),
            SettingItems("Other Notifications")
        )
    ),
    SettingSection(
        "Account & Privacy",
        listOf(
            SettingItems("Profile Privacy"),
            SettingItems("Account Info"),
            SettingItems("Change Password"),
            SettingItems("Theme"),

            )
    ),

    )
data class ScreenSize(
    val width: Dp,
    val height: Dp
)
@Composable
fun rememberScreenSize(): ScreenSize {
    val windowInfo = LocalWindowInfo.current
    val screenSize = windowInfo.containerSize
    val density = LocalDensity.current
    return ScreenSize(
        width = with(density) { screenSize.width.toDp() },
        height = with(density) { screenSize.height.toDp() }
    )
}
