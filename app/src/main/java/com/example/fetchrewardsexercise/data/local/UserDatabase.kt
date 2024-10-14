package com.example.fetchrewardsexercise.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        UserEntity::class
    ],
    exportSchema = false,
    version = 2
)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao
}