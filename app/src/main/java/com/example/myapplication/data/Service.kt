package com.example.myapplication.data

import com.example.myapplication.data.model.RandomUser
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("?randomapi")
    fun random(): Call<RandomUser>

}