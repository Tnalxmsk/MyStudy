package com.example.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TextEntity::class], version = 1)
abstract class TextDatabase : RoomDatabase() {

}