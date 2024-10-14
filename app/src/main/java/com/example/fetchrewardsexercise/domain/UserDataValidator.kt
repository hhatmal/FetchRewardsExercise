package com.example.fetchrewardsexercise.domain

class UserDataValidator {
    fun isUserValid(name: String): Boolean {
        return name.isNotEmpty()
    }
}