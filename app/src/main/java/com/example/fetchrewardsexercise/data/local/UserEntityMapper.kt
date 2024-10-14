package com.example.fetchrewardsexercise.data.local

import com.example.fetchrewardsexercise.domain.User

fun List<UserEntity>.toUsers(): List<User> {
    val users: MutableList<User> = mutableListOf()
    this.forEach {
        users.add(
            User(
                id = it.id,
                listId = it.listId,
                name = it.name
            )
        )
    }
    return users
}

fun List<User>.toUserEntities(): List<UserEntity> {
    val users: MutableList<UserEntity> = mutableListOf()
    this.forEach {
        users.add(
            UserEntity(
                id = it.id,
                listId = it.listId,
                name = it.name
            )
        )
    }
    return users
}