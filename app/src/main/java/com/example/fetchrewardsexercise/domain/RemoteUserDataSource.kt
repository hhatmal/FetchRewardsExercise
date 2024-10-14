package com.example.fetchrewardsexercise.domain

import com.example.fetchrewardsexercise.domain.util.DataError
import com.example.fetchrewardsexercise.domain.util.Result

interface RemoteUserDataSource {
    suspend fun getUsers(): Result<List<User>, DataError.Network>
}