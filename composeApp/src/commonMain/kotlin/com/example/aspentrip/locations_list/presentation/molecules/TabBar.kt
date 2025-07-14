package com.example.aspentrip.locations_list.presentation.molecules

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aspentrip.locations_list.presentation.LocationsListViewModel
import com.example.aspentrip.locations_list.presentation.atoms.DrawTabSelectButton

val tabs = arrayOf("Locations", "Hotels", "Food", "Adventure", "Nightlife", "Beach")

@Composable
fun TabBar(viewModel: LocationsListViewModel) {
    Row(modifier = Modifier
        .horizontalScroll(rememberScrollState())
        .padding(horizontal = 0.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically) {
        for ((i, _) in tabs.withIndex()) {
            DrawTabSelectButton(tabs[i], i, viewModel)
        }
    }
}