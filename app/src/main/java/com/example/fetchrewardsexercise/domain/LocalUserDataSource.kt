package com.example.fetchrewardsexercise.domain

import com.example.fetchrewardsexercise.domain.util.Result
import com.example.fetchrewardsexercise.domain.util.DataError
import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {
    fun getUsers(): Flow<List<User>>
    suspend fun upsertUsers(users: List<User>): Result<List<User>, DataError.Local>
}