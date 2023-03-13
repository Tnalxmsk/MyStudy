package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.MyApi
import com.example.myapplication.api.RetrofitInstance
import com.example.myapplication.model.Plant
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // 레포지터리 추가
    private val repository = Repository()
    //private val instance : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result

    fun getAllData() = viewModelScope.launch {
        Log.d("MainViewModel", repository.getAllData().toString())
        _result.value = repository.getAllData()
    }
}