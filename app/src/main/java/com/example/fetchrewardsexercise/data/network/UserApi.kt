package com.example.fetchrewardsexercise.data.network

import com.example.fetchrewardsexercise.data.UserDto
import com.example.fetchrewardsexercise.domain.util.Result
import com.example.fetchrewardsexercise.domain.util.DataError
import retrofit2.http.GET

interface UserApi {
    @GET("/hiring.json")
    suspend fun getUsers(): List<UserDto>
}