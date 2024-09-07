package com.example.semeq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.semeq.navigation.SemeqNavigation
import com.example.semeq.navigation.SemeqScreens
import com.example.semeq.screens.Login
import com.example.semeq.ui.theme.SemeqTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SemeqTheme {
                SemeqApp()
            }
        }
    }
}

@Composable
fun SemeqApp() {
    SemeqNavigation()
}