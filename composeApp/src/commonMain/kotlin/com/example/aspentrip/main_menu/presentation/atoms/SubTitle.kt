package com.example.aspentrip.main_menu.presentation.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.main_sub_heading_l1
import aspentrip.composeapp.generated.resources.main_sub_heading_l2
import org.jetbrains.compose.resources.stringResource

@Composable
fun DrawSubTitle() {
    Column {
        Text(stringResource(Res.string.main_sub_heading_l1),
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp))
        Text(stringResource(Res.string.main_sub_heading_l2),
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 45.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth().padding(30.dp, 10.dp))
    }
}