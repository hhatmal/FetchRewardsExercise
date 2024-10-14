package com.example.fetchrewardsexercise.domain

import com.example.fetchrewardsexercise.domain.util.DataError
import com.example.fetchrewardsexercise.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>
    suspend fun fetchUsers(): EmptyResult<DataError>
}