package com.example.semeq.repository

import com.example.semeq.remote.API.SemeqAPI
import com.example.semeq.remote.ApiClient
import com.example.semeq.remote.DTO.Login.LoginRequest

class SemeqRepository() {

    private val repository = ApiClient.apiService

    suspend fun getLogin(username: String, password: String) = repository.login(LoginRequest(username, password))

    suspend fun getTree(token: String) = repository.getTree(token)

}