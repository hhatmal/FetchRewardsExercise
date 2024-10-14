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
        return try {
            val users = userApi.getUsers().toUsers()
            Result.Success(users)
        } catch (e: Exception) {
            // might not be the case, but just assume for now
            Result.Error(DataError.Network.NO_INTERNET)
        }
    }
}