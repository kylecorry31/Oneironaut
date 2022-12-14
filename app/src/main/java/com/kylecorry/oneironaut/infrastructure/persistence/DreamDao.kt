package com.kylecorry.oneironaut.infrastructure.persistence

import androidx.room.*

@Dao
interface DreamDao {
    @Query("SELECT * FROM dreams WHERE date = :date LIMIT 1")
    suspend fun get(date: String): DreamEntity?

    @Query("SELECT * FROM dreams WHERE _id = :id LIMIT 1")
    suspend fun get(id: Long): DreamEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dream: DreamEntity): Long

    @Delete
    suspend fun delete(dream: DreamEntity)

    @Update
    suspend fun update(dream: DreamEntity)
}