package com.example.aspentrip.locations_list.presentation.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.arrow_down
import aspentrip.composeapp.generated.resources.cur_location
import aspentrip.composeapp.generated.resources.location_1
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun DrawLocationSelect() {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxHeight()) {
        Image(painterResource(Res.drawable.location_1),
            contentDescription = null,
            modifier = Modifier.size(20.dp))
        Text(stringResource(Res.string.cur_location),
            style = MaterialTheme.typography.labelSmall
        )
        Image(painterResource(Res.drawable.arrow_down),
            contentDescription = null,
            modifier = Modifier.size(20.dp))
    }
}