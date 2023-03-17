package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.dao.TextDao
import com.example.myapplication.dao.WordDao
import com.example.myapplication.entity.TextEntity

@Database(entities = [TextEntity::class], version = 2)
abstract class TextDatabase : RoomDatabase() {
    abstract fun textDao() : TextDao
    abstract fun wordDao() : WordDao

    companion object {
        @Volatile
        private var INSTANCE : TextDatabase? = null

        fun getDatabase(context: Context) : TextDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, TextDatabase::class.java, "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}