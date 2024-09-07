package com.example.semeq.navigation

enum class SemeqScreens {
    Login,
    Home;


    companion object {
        fun fromRoute(route: String?): SemeqScreens =
            when (route?.substringBefore("/")) {
                Login.name -> Login
                Home.name -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}