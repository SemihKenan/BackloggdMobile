package com.example.myapplication.VM

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Firabase.UserRepository
import com.example.myapplication.data.UserList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class user_VM: ViewModel() {
    private val repo= UserRepository()
    private val _users = MutableStateFlow<List<UserList>>(emptyList())
    val users: StateFlow< List<UserList>> = _users

    init {
        loadUsers()
    }
    fun loadUsers(){
        repo.getUsers(){ulist->
            _users.value=ulist
        }
    }
    fun uploadUsers(mockUsers: List<UserList>) {
        repo.uploadUsers(mockUsers)
        { success->
            loadUsers()
        }
    }
}