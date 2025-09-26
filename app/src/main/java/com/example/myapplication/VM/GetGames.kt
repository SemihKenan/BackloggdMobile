package com.example.myapplication.VM

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.GameDataModel
import com.example.myapplication.data.GameRepository


class GetGames: ViewModel() {
    
    private val repo = GameRepository()
    private val _games = mutableStateOf<List<GameDataModel>>(emptyList())
    val games: State<List<GameDataModel>> =_games
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
