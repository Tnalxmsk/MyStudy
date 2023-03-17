package com.example.myapplication.repository

import android.content.Context
import com.example.myapplication.db.TextDatabase
import com.example.myapplication.entity.TextEntity

class Repository(context: Context){
    val db = TextDatabase.getDatabase(context)

    fun getTextList() = db.textDao().getAllData()

    fun getWordList() = db.wordDao().getAllData()

    fun insertTextList(text: String) = db.textDao().insert(TextEntity(0, text))

    fun insertWordList(text: String) = db.textDao().insert(TextEntity(0, text))

    fun deleteTextData() = db.textDao().deleteAllData()

    fun deleteWordData() = db.wordDao().deleteAllData()
}