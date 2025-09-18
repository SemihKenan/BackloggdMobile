package com.example.myapplication.data

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
            SettingItems("Notifications","account_route"),
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