package com.example.fetchrewardsexercise.data.network

import com.example.fetchrewardsexercise.data.UserDto
import com.example.fetchrewardsexercise.domain.User

fun List<UserDto>.toUsers(): List<User> {
    val users: MutableList<User> = mutableListOf()
    this.forEach {
        users.add(
            User(
                id = it.id.toString(),
                listId = it.listId.toString(),
                name = it.name ?: "" // null will be empty string and we filter later
            )
        )
    }
    return users
}
