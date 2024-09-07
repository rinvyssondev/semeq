package com.example.semeq.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.semeq.SemeqViewModel

@Composable
fun Home(navController: NavController, viewModel: SemeqViewModel) {

    val tree by viewModel.tree.observeAsState()

    tree?.let {
        Column {
            it.forEach {
                Text(text = it.name)
                Text(text = it.level.toString())
            }
        }
    }

}