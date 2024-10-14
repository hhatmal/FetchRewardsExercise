package com.example.fetchrewardsexercise.data

import com.example.fetchrewardsexercise.data.network.UserApi
import com.example.fetchrewardsexercise.data.network.toUsers
import com.example.fetchrewardsexercise.domain.RemoteUserDataSource
import com.example.fetchrewardsexercise.domain.User
import com.example.fetchrewardsexercise.domain.util.DataError
import com.example.fetchrewardsexercise.domain.util.Result

class RemoteUserDataSourceImpl(
    private val userApi: UserApi
): RemoteUserDataSource {
    override suspend fun getUsers(): Result<List<User>, DataError.Network> {
        val users = userApi.getUsers().toUsers()
        return Result.Success(users)
    }
}