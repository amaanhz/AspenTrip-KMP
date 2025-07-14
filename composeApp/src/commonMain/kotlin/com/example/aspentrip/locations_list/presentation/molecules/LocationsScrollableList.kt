package com.example.aspentrip.locations_list.presentation.molecules

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aspentrip.locations_list.domain.Location

@Composable
fun DrawLocationsScrollableList(locations: List<Location>?) {
    Row(modifier = Modifier
        .horizontalScroll(rememberScrollState())
        .padding(horizontal = 0.dp, vertical = 5.dp)) {
        if (locations != null) {
            for (loc in locations) {
                DrawLocationItem(loc)
            }
        }
    }
}