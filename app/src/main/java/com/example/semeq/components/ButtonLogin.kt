package com.example.semeq.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.semeq.R
import com.example.semeq.ui.theme.Pink
import com.example.semeq.ui.theme.White

@Composable
fun ButtonLogin(
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Pink,
        )
    ) {
        Text(
            text = stringResource(id = R.string.login),
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

    }
}