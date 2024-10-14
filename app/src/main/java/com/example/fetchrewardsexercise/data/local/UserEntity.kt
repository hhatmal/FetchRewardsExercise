package com.example.fetchrewardsexercise.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val listId: String,
    val name: String,
)
