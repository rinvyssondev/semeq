package com.example.semeq

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semeq.remote.DTO.Home.Home
import com.example.semeq.remote.DTO.Home.HomeItem
import com.example.semeq.remote.DTO.Login.LoginRequest
import com.example.semeq.remote.DTO.Login.LoginResponse
import com.example.semeq.repository.SemeqRepository
import com.example.semeq.screens.Home
import kotlinx.coroutines.launch

class SemeqViewModel: ViewModel() {

    private val repository = SemeqRepository()

    private val _login = MutableLiveData<LoginResponse>()
    val login: LiveData<LoginResponse> = _login

    private val _tree = MutableLiveData<Home>()
    val tree: LiveData<Home> = _tree


    fun getLogin(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.getLogin(username, password)
                _login.value = response
                println(response.access_token)
                response.access_token?.let {
                    getTree("Bearer $it")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getTree(token: String) {
        viewModelScope.launch {
            try {
                val response = repository.getTree(token)
                _tree.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}