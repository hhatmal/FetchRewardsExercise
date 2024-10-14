package com.example.fetchrewardsexercise.presentation.overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardsexercise.domain.User
import com.example.fetchrewardsexercise.domain.UserDataValidator
import com.example.fetchrewardsexercise.domain.UserRepository
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val userRepository: UserRepository,
    private val userDataValidator: UserDataValidator,
) : ViewModel() {
    var state by mutableStateOf(
        OverviewState(
            userUis = listOf()
        )
    )
        private set

    init {
        // observe local database
        userRepository
            .getUsers()
            .map { users ->
                val filteredUsers: MutableList<User> = mutableListOf()
                users.forEach { user ->
                    if (userDataValidator.isUserValid(user.name)) {
                        filteredUsers.add(user)
                    }
                }
                return@map filteredUsers
            }
            .onEach {
                val userUis = it.toUserUis()
                state = state.copy(userUis = userUis)
            }
            .launchIn(viewModelScope)

        // fetch remotely
        // will update local database if successful
        viewModelScope.launch {
            userRepository.fetchUsers()
        }
    }
}