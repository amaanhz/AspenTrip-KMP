package com.example.aspentrip.locations_list.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.popular
import com.example.aspentrip.locations_list.presentation.atoms.DrawPageTitle
import com.example.aspentrip.locations_list.presentation.components.DrawLocationSelect
import com.example.aspentrip.locations_list.presentation.molecules.DrawLocationsScrollableList
import com.example.aspentrip.locations_list.presentation.molecules.TabBar
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview()
fun LocationsList(navController: NavController?,
                  viewModel: LocationsListViewModel = viewModel { LocationsListViewModel() }) {
    Column(modifier = Modifier
        .fillMaxSize()
        .windowInsetsPadding(WindowInsets.safeContent)
        .verticalScroll(rememberScrollState())) {
        Row(modifier = Modifier.fillMaxWidth().height(90.dp)) {
            DrawPageTitle()
            Spacer(Modifier.weight(1.0f))
            DrawLocationSelect()
        }
        TabBar(viewModel)
        Text(stringResource(Res.string.popular),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
        )
        DrawLocationsScrollableList(viewModel.getLocations())
    }
}