package com.example.fetchrewardsexercise.presentation.overview

import com.example.fetchrewardsexercise.data.local.UserEntity
import com.example.fetchrewardsexercise.domain.User

fun List<User>.toUserUis(): List<UserUi> {
    val users: MutableList<UserUi> = mutableListOf()
    this.forEach {
        users.add(
            UserUi(
                id = it.id,
                name = it.name
            )
        )
    }
    return users
}