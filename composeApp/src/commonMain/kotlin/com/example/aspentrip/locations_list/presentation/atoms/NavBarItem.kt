package com.example.aspentrip.locations_list.presentation.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrawNavBarItem(res: DrawableResource) {
    Button(onClick = {},
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .fillMaxHeight(),
        colors = ButtonDefaults.buttonColors().copy(containerColor = Color.White)

    ) {
        Image(painterResource(res),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
        )
    }
}