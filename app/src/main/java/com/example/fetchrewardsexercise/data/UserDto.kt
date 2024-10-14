package com.example.fetchrewardsexercise.data

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int?,
    val listId: Int?,
    val name: String?,
)