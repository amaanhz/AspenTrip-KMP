package com.example.aspentrip.main_menu.presentation.atoms

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aspentrip.composeapp.generated.resources.Hiatus
import aspentrip.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun DrawMainTitle(title: String) {
    val hiatus = FontFamily(Font(Res.font.Hiatus))
    Text(title,
        color = Color.White,
        fontSize = 100.sp,
        fontFamily = hiatus,
        letterSpacing = 8.sp,
        modifier = Modifier.padding(20.dp, 80.dp))
}