package com.example.semeq.remote

import com.example.semeq.remote.API.SemeqAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "https://apitestemobile-production.up.railway.app"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: SemeqAPI by lazy {
        RetrofitClient.retrofit.create(SemeqAPI::class.java)
    }
}