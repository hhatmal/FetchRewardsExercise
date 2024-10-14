package com.example.fetchrewardsexercise.data

import com.example.fetchrewardsexercise.domain.LocalUserDataSource
import com.example.fetchrewardsexercise.domain.RemoteUserDataSource
import com.example.fetchrewardsexercise.domain.User
import com.example.fetchrewardsexercise.domain.UserRepository
import com.example.fetchrewardsexercise.domain.util.DataError
import com.example.fetchrewardsexercise.domain.util.EmptyResult
import com.example.fetchrewardsexercise.domain.util.asEmptyDataResult
import com.example.fetchrewardsexercise.domain.util.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

class OfflineFirstUserRepositoryImpl(
    private val applicationScope: CoroutineScope,
    private val localUserDataSource: LocalUserDataSource,
    private val remoteUserDataSource: RemoteUserDataSource
): UserRepository {
    override fun getUsers(): Flow<List<User>> {
        return localUserDataSource.getUsers()
    }

    override suspend fun fetchUsers(): EmptyResult<DataError> {
        // fetch users remotely and if we succeed then update local database
        return when (val result = remoteUserDataSource.getUsers()) {
            is Result.Error -> {
                result.asEmptyDataResult()
            }

            is Result.Success -> {
                applicationScope.async {
                    localUserDataSource.upsertUsers(result.data).asEmptyDataResult()
                }.await()
            }
        }
    }
}
