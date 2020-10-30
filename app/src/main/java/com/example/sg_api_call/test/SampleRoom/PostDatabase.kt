package com.example.sg_api_call.test.SampleRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostTable::class], version = 1, exportSchema = false)
abstract class PostDatabase : RoomDatabase() {

    abstract val postDao: PostDao
    companion object {
        @Volatile
        private var INSTANCE: PostDatabase? = null
        fun getInstance(context: Context): PostDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,PostDatabase::class.java, "sleep_history_database")
                                .fallbackToDestructiveMigration()
                                .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
