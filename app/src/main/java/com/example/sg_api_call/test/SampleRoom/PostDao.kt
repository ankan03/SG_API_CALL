package com.example.sg_api_call.test.SampleRoom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PostDao {
    @Insert
    suspend fun insert(modelTable: PostTable)

    @Update
    suspend fun update(modelTable: PostTable)

    @Query("SELECT * from post_table WHERE id = :key")
    suspend fun get(key: Long): PostTable?

    @Query("DELETE FROM post_table")
    suspend fun clear()

    @Query("SELECT * FROM post_table ORDER BY id DESC")
    fun getAllPosts(): LiveData<List<PostTable>>

    @Query("SELECT * FROM post_table ORDER BY id DESC LIMIT 1")
    suspend fun getRecentPost(): PostTable?
}