package com.example.aspentrip.locations_list.presentation.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.heart
import aspentrip.composeapp.generated.resources.home
import aspentrip.composeapp.generated.resources.profile
import aspentrip.composeapp.generated.resources.ticket
import com.example.aspentrip.locations_list.presentation.atoms.DrawNavBarItem

@Composable
fun DrawNavBar() {
    Row(Modifier
        .fillMaxWidth()
        .height(80.dp)
        .background(Color.White,
            shape = RoundedCornerShape(30.dp)
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        DrawNavBarItem(Res.drawable.home)
        DrawNavBarItem(Res.drawable.ticket)
        DrawNavBarItem(Res.drawable.heart)
        DrawNavBarItem(Res.drawable.profile)
    }
}