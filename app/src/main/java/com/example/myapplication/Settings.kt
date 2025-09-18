package com.example.myapplication

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


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

@Composable
fun Settings(navController: NavController) {
    Scaffold(
        content = { paddingValues ->
            LazyColumn(
                state = rememberLazyListState(),
                modifier = Modifier.padding(paddingValues),
                flingBehavior = ScrollableDefaults.flingBehavior(),
                userScrollEnabled = true,
                reverseLayout = false,
            ) {
                allSettingSection.forEachIndexed { sectionIndex, section ->
                    item(key = "header_${section.sectionTitle}") {
                        Text(
                            text = section.sectionTitle,
                            modifier = Modifier
                                .padding(top = 20.dp, start = 3.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Start,

                        )
                    }
                    items(
                        count = section.options.size,
                        key = { optionIndex ->
                            "option_${section.sectionTitle}_${section.options[optionIndex].title}" }
                    ) 
                    { optionIndex ->
                        val settingOption = section.options[optionIndex]
                        TextButton(
                            modifier = Modifier,
                            onClick = {
                                settingOption.route?.let { route ->
                                    navController.navigate(route)
                                }
                            },
                        ){
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                text = settingOption.title
                            )
                        }
                    }
                    if (sectionIndex<allSettingSection.size - 1)
                    {
                        item (key = "divider $sectionIndex"){
                            HorizontalDivider(
                                modifier = Modifier,
                                thickness = 2.dp,
                                color = MaterialTheme.colorScheme.outline
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun SettingsPreview() {
    Settings(navController = rememberNavController())
}