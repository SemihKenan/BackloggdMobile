package com.example.myapplication.widget

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar() {
    var searchQuery by remember { mutableStateOf("") }
    val searchbaritems = listOf("SilkSong", "ZartZurt", "CartCurt")
    var active by remember { mutableStateOf(false) }
    val filteredItems = searchbaritems.filter { it.contains(searchQuery, ignoreCase = true) }
    
    SearchBar(
        query = searchQuery,
        onQueryChange = { searchQuery = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = { active = it },
        modifier = Modifier,
        placeholder = { Text("Search Games") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        tonalElevation = 3.dp,


    ) {
        filteredItems.forEach { item->
            Text(item)} }

}

@Preview
@Composable
private fun SearchPrev() {CustomSearchBar()

}