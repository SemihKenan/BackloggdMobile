package com.example.myapplication.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp

data class SettingsItemDataModel(
    val title: String,
    val route: String? = null
)

data class SettingSection(
    val sectionTitle: String,
    val options: List<SettingsItemDataModel>
)

val allSettingSection = listOf(
    SettingSection(
        "General",
        listOf(
            SettingsItemDataModel("Notifications","notifications_route"),
            SettingsItemDataModel("Account"),
            SettingsItemDataModel("Privacy")
        )

    ),
    SettingSection(
        "Notifications",
        listOf(
            SettingsItemDataModel("Game Notifications"),
            SettingsItemDataModel("Social Notifications"),
            SettingsItemDataModel("Other Notifications")
        )
    ),
    SettingSection(
        "Account & Privacy",
        listOf(
            SettingsItemDataModel("Profile Privacy"),
            SettingsItemDataModel("Account Info"),
            SettingsItemDataModel("Change Password"),
            SettingsItemDataModel("Theme"),

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
