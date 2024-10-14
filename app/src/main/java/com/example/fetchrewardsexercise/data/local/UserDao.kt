package com.example.fetchrewardsexercise.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Upsert
    suspend fun upsertUsers(users: List<UserEntity>)

    @Query("SELECT * FROM userentity ORDER BY listId ASC, name ASC")
    fun getUsers(): Flow<List<UserEntity>>
}
