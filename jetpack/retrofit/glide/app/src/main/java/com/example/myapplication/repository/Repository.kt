package com.example.myapplication.repository

import com.example.myapplication.api.MyApi
import com.example.myapplication.api.RetrofitInstance

class Repository {
    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)
    suspend fun getAllData() = client.getAllPlants()
}