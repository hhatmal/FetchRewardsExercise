package com.example.fetchrewardsexercise.data

import com.example.fetchrewardsexercise.data.local.UserDao
import com.example.fetchrewardsexercise.data.local.toUserEntities
import com.example.fetchrewardsexercise.data.local.toUsers
import com.example.fetchrewardsexercise.domain.LocalUserDataSource
import com.example.fetchrewardsexercise.domain.User
import com.example.fetchrewardsexercise.domain.util.DataError
import com.example.fetchrewardsexercise.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserDataSourceImpl(
    private val userDao: UserDao,
): LocalUserDataSource {
    override fun getUsers(): Flow<List<User>> {
        return userDao.getUsers()
            .map {
                it.toUsers()
            }
    }

    override suspend fun upsertUsers(users: List<User>): Result<List<User>, DataError.Local> {
        val userEntities = userDao.upsertUsers(users.toUserEntities())
        return Result.Success(users)
    }
}