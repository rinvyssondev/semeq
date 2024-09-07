package com.example.semeq.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.semeq.R
import com.example.semeq.ui.theme.Pink
import com.example.semeq.ui.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonBottomSheet(
    onDismiss: () -> Unit,
    contentColorButton: Color,
    containerColorButton: Color,
    colorText: Color,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    scope: CoroutineScope,
    text: String
) {

    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColorButton,
            containerColor = containerColorButton
        ),
        onClick = {
            scope.launch {
                bottomSheetScaffoldState.bottomSheetState
                onDismiss()
            }
        }) {
        Text(
            text = text,
            color = colorText,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }
}