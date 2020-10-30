//package com.example.sg_api_call.Room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(entities = [TokenModel::class],version = 1,exportSchema = false)
//abstract class TokenDatabase:RoomDatabase() {
//    abstract fun tokenDao():TokenDao
//
//    companion object{
//        @Volatile
//        private var INSTANCE:TokenDatabase?=null
//        fun getTokenDatabase(context: Context):TokenDatabase{
//            val tempInstance = INSTANCE
//            if (tempInstance != null){
//                return tempInstance
//            }
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    TokenDatabase::class.java,
//                    "token_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//
//        }
//    }
//}