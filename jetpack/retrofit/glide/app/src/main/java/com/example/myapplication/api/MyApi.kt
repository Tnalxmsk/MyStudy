package com.example.myapplication.api

import com.example.myapplication.model.Plant
import retrofit2.http.GET

interface MyApi {
    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>
}