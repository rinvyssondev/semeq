package com.example.semeq.remote.API

import android.provider.SyncStateContract.Constants
import com.example.semeq.remote.DTO.Home.Home
import com.example.semeq.remote.DTO.Home.HomeItem
import com.example.semeq.remote.DTO.Login.LoginRequest
import com.example.semeq.remote.DTO.Login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface SemeqAPI {

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("/tree")
    suspend fun getTree(@Header("Authorization") token: String): Home
}