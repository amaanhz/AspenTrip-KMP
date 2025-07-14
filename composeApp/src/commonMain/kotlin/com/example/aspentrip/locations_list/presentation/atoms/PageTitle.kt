package com.example.aspentrip.locations_list.presentation.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.location_list_header_l1
import aspentrip.composeapp.generated.resources.location_list_header_l2
import org.jetbrains.compose.resources.stringResource

@Composable
fun DrawPageTitle() {
    Column(modifier = Modifier
        .width(200.dp)
        .padding(horizontal = 0.dp, vertical = 5.dp)) {
        Text(stringResource(Res.string.location_list_header_l1),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(stringResource(Res.string.location_list_header_l2),
            style = MaterialTheme.typography.headlineLarge
        )
    }
}