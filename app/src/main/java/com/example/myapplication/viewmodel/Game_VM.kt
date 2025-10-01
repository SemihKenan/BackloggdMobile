package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.GameDataModel
import com.example.myapplication.data.Firabase.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class Game_VM: ViewModel() {
    
    private val repo = GameRepository()
    private val _games = MutableStateFlow<List<GameDataModel>>(emptyList())
    val games: StateFlow<List<GameDataModel>> =_games
    init {
        loadGames()
    }
    fun loadGames(){
        repo.getGames { list ->
            _games.value=list
        }
    }//shared vm   camelcase
}
