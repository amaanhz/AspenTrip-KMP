package com.example.aspentrip.locations_list.presentation.organisms

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.popular
import aspentrip.composeapp.generated.resources.recommended
import com.example.aspentrip.locations_list.domain.Location
import com.example.aspentrip.locations_list.presentation.molecules.DrawLocationItem
import com.example.aspentrip.locations_list.presentation.molecules.DrawRecommendedItem
import org.jetbrains.compose.resources.stringResource

@Composable
fun DrawLocationsScrollableLists(locations: List<Location>?, recommended: List<Location>?) {
    Text(stringResource(Res.string.popular),
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
    )
    Row(modifier = Modifier
        .horizontalScroll(rememberScrollState())
        .padding(horizontal = 0.dp, vertical = 5.dp)) {
        if (locations != null) {
            for (loc in locations) {
                DrawLocationItem(loc)
            }
        }
    }
    Text(stringResource(Res.string.recommended),
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
    )
    Row(modifier = Modifier
        .horizontalScroll(rememberScrollState())
        .padding(horizontal = 0.dp, vertical = 5.dp)) {
        if (recommended != null) {
            for (rec in recommended) {
                DrawRecommendedItem(rec)
            }
        }
    }
}