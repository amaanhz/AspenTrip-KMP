package com.example.aspentrip.locations_list.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.aspentrip.locations_list.presentation.atoms.DrawPageTitle
import com.example.aspentrip.locations_list.presentation.components.DrawLocationSelect
import com.example.aspentrip.locations_list.presentation.molecules.DrawNavBar
import com.example.aspentrip.locations_list.presentation.molecules.TabBar
import com.example.aspentrip.locations_list.presentation.organisms.DrawLocationsScrollableLists
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
fun LocationsListRoot(navController: NavController?) {
    val viewModel = koinInject<LocationsListViewModel>()

    val state by viewModel.locationsListState.collectAsStateWithLifecycle()

    LocationsList(
        state = state,
        onAction = {action ->
            viewModel.onAction(action)
                   },
        navController = navController
    )
}

@Composable
@Preview()
fun LocationsList(navController: NavController?,
                  state: LocationsListState,
                  onAction: (LocationsListAction) -> Unit) {
    val viewModel = koinInject<LocationsListViewModel>()
    Column(modifier = Modifier
        .fillMaxSize()
        .windowInsetsPadding(WindowInsets.safeContent)
        ) {
        Row(modifier = Modifier.fillMaxWidth().height(90.dp)) {
            DrawPageTitle()
            Spacer(Modifier.weight(1.0f))
            DrawLocationSelect()
        }
        TabBar(state.tabSelected, onAction)
        Column(modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .weight(1f, fill = false)
        ) {
            DrawLocationsScrollableLists(
                viewModel.getLocations(),
                viewModel.getRecommended()
            )
        }
        DrawNavBar()
    }
}