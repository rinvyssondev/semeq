package com.example.semeq.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semeq.SemeqViewModel
import com.example.semeq.screens.Home
import com.example.semeq.screens.Login

@Composable
fun SemeqNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SemeqScreens.Login.name
    ) {
        composable(SemeqScreens.Login.name) {
            Login(navController = navController, viewModel = SemeqViewModel())
        }
        composable(
            route = SemeqScreens.Home.name
        ) {
            Home(navController = navController, viewModel = SemeqViewModel())
        }
    }
}