package com.example.semeq.screens

import BottomSheet
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semeq.R
import com.example.semeq.SemeqViewModel
import com.example.semeq.ui.theme.Pink
import com.example.semeq.ui.theme.White

@Composable
fun Home(navController: NavController, viewModel: SemeqViewModel) {

    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Pink),
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            modifier = Modifier.padding(start = 12.dp, top = 8.dp).clickable { navController.popBackStack() },
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "back",
            tint = White
        )

        Spacer(modifier = Modifier.weight(0.7f))

            Text(
                text = stringResource(id = R.string.hello),
                modifier = Modifier.padding(8.dp),
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.username),
                modifier = Modifier.padding(8.dp),
                color = White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            )

        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .clip(shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .background(White),
            contentAlignment = Alignment.TopCenter
        ){
            Button(onClick = { showBottomSheet = true }) {
                Text(text = "Ativando o BottomSheet")
            }
            BottomSheet(showBottomSheet = showBottomSheet, onDismiss = { showBottomSheet = false })
        }

    }

}