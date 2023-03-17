package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entity.TextEntity
import com.example.myapplication.entity.WordEntity
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val context = getApplication<Application>().applicationContext
    val repository = Repository(context)

    private var _textList = MutableLiveData<List<TextEntity>>()
    val textList : LiveData<List<TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList : LiveData<List<WordEntity>>
        get() = _wordList

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        _textList.postValue(repository.getTextList())
        _wordList.postValue(repository.getWordList())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertTextList(text)
        repository.insertWordList(text)
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteTextData()
        repository.deleteWordData()
    }
}