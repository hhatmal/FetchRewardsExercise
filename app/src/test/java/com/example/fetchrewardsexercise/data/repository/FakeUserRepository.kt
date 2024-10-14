package com.example.fetchrewardsexercise.data.repository

import com.example.fetchrewardsexercise.domain.User
import com.example.fetchrewardsexercise.domain.UserRepository
import com.example.fetchrewardsexercise.domain.util.DataError
import com.example.fetchrewardsexercise.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.fetchrewardsexercise.domain.util.Result
import com.example.fetchrewardsexercise.domain.util.asEmptyDataResult

class FakeUserRepository : UserRepository {
    val users: MutableList<User> = mutableListOf()

    override fun getUsers(): Flow<List<User>> {
        return flow {
            emit(users)
        }
    }

    override suspend fun fetchUsers(): EmptyResult<DataError> {
        return Result.Success(listOf(User(id = "1", listId = "1", name = "tim"))).asEmptyDataResult()
    }
}