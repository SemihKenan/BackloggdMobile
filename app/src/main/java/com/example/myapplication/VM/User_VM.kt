package com.example.myapplication.VM

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Constants
import com.example.myapplication.data.Firabase.GameRepository
import com.example.myapplication.data.Firabase.UserRepository
import com.example.myapplication.data.GameDataModel
import com.example.myapplication.data.ProfileDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
class User_VM : ViewModel() {
    private val repo= UserRepository()
    private val gameRepo = GameRepository()
    private val _users = MutableStateFlow<List<ProfileDataModel?>>(emptyList())
    val users: StateFlow< List<ProfileDataModel?>> = _users
    private val _games = MutableStateFlow<List<GameDataModel>>(emptyList())
    val repogames: MutableStateFlow<List<GameDataModel>> = _games

    init {
        loadUsers(Constants.activeProfileId)
    }
    fun loadUsers(profileId: String) {
        repo.getUser(profileId) { loadUser ->
            _users.value = listOf(loadUser)
            if (loadUser != null) {
                loadGames(loadUser.profileGamesPlayed)
            }
        }
    }
    fun loadUserWithGames(profileId: String) {
        gameRepo.getUserGames(profileId) { userList, gameList ->
            _users.value = userList
            _games.value = gameList
        }
    }
    fun loadGames(gameIds: List<String>) {
        gameRepo.getGamesByIds(gameIds) { games ->
            _games.value = games
        }
    }
}
