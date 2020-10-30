//package com.example.sg_api_call.Room
//
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//
//interface TokenDao {
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun addToken(token:TokenModel)
//
//    @Query("SELECT token FROM token_table")
//    suspend fun getToken(tokenModel: TokenModel):String?
//
//}