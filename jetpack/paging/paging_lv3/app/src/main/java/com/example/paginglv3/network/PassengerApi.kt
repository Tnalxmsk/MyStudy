package com.example.paginglv3.network

import com.example.paginglv3.data.PassengerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PassengerApi {

    @GET("passenger")
    suspend fun getData(
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : Response<PassengerResponse>
}