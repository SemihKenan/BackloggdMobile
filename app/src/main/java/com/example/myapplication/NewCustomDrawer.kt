package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.AppbarRenk
import com.example.myapplication.ui.theme.YaziRenk
import kotlinx.coroutines.launch

data class DrawerMenuItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

val drawerItems = listOf(
    DrawerMenuItem("Ana Sayfa", Icons.Default.Home, "home_route"),
    DrawerMenuItem("Profil", Icons.Default.Person, "profile_route")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDrawer(
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
        ModalDrawerSheet {
            Text("Menü")
            HorizontalDivider(modifier = Modifier, thickness = 5.dp, color = DividerDefaults.color)
            drawerItems.forEach { item ->
                NavigationDrawerItem(
                    label = { Text(item.title) },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route)
                        scope.launch { drawerState.close() }
                    },
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)

                )
            }
        }
    },
        content = {
            Scaffold(
                modifier = Modifier.wrapContentSize(),
                containerColor = Color.White,
                topBar = {
                    TopAppBar(
                        { Text("Appbar") },
                        navigationIcon = {
                            IconButton(
                                onClick = { scope.launch { drawerState.open() } }){
                                Icon(
                                    Icons.Default.Menu,
                                    contentDescription = "Menüyü Aç"
                                )
                            }
                        },
                        colors = TopAppBarDefaults
                            .topAppBarColors(
                                containerColor = AppbarRenk,
                                titleContentColor = YaziRenk
                            ),

                        modifier = Modifier
                    )
                },
                content = {
                        innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding).wrapContentSize()) {
                        NavHost(
                            navController = navController,
                            startDestination = "home_route",
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.wrapContentSize(),
                        )
                        {
                            composable("home_route"){HomeScreen()}
                            composable("profile_route"){Profil()}
                        }
                    }


                }


            )
        }
    )
}