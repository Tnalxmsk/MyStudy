package com.example.myapplication.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.TextDatabase
import com.example.myapplication.entity.TextEntity
import com.example.myapplication.entity.WordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val context = getApplication<Application>().applicationContext
    val db = TextDatabase.getDatabase(context)

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("MainActivity", db.textDao().getAllData().toString())
        Log.d("MainActivity", db.wordDao().getAllData().toString())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().insert(TextEntity(0, text))
        db.wordDao().insert(WordEntity(0, text))
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().deleteAllData()
        db.wordDao().deleteAllData()
    }
}