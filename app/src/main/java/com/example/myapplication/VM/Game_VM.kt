package com.example.myapplication.VM

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
    }
    fun uploadMockData(mockGames: List<GameDataModel>) {
        repo.pushGames(mockGames)
        { success->
            loadGames()
        }
    }
    fun deleteduplicate(){
        repo.removeDuplicates { success->
            loadGames()
        }
        }
    fun clean(){
        repo.clearGameListCollection { success->
            loadGames() }
    }
}
