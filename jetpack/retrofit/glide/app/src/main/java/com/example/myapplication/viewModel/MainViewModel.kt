package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.MyApi
import com.example.myapplication.api.RetrofitInstance
import com.example.myapplication.model.Plant
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val instance : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result

    fun getAllData() = viewModelScope.launch {
        Log.d("MainViewModel", instance.getAllPlants().toString())
        _result.value = instance.getAllPlants()
    }
}