package com.example.semeq.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.semeq.R
import com.example.semeq.SemeqViewModel
import com.example.semeq.components.ButtonLogin
import com.example.semeq.components.FormLogin
import com.example.semeq.navigation.SemeqNavigation
import com.example.semeq.navigation.SemeqScreens
import com.example.semeq.ui.theme.Pink
import com.example.semeq.ui.theme.White
import kotlin.math.log

@Composable
fun Login(navController: NavController, viewModel: SemeqViewModel) {

    val login by viewModel.login.observeAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LaunchedEffect(key1 = login) {
        login?.access_token?.let {
            navController.navigate(SemeqScreens.Home.name)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Pink),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.1f)
                .clip(shape = RoundedCornerShape(topStart = 32.dp, bottomEnd = 32.dp))
                .background(White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                imageVector = Icons.Default.Person,
                contentDescription = "person",
                tint = Pink
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .clip(shape = RoundedCornerShape(topStart = 72.dp))
                .background(White),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = R.string.welcome),
                    color = Pink,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, bottom = 20.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(32.dp))
                FormLogin(
                    text = stringResource(id = R.string.user),
                    value = username,
                    onValueChange = { username = it }
                )

                Spacer(modifier = Modifier.height(40.dp))

                FormLogin(
                    text = stringResource(id = R.string.password),
                    value = password,
                    onValueChange = { password = it }
                )

                Spacer(modifier = Modifier.weight(0.1f))

                ButtonLogin(
                    onClick = {
                        viewModel.getLogin(username, password)
                    }
                )
                Spacer(modifier = Modifier.weight(0.1f))
            }
        }
    }
}