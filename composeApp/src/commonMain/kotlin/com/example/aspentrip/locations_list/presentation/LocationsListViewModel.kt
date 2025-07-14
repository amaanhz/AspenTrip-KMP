package com.example.aspentrip.locations_list.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.aspentrip.locations_list.data.service.LocationsRepository
import com.example.aspentrip.locations_list.domain.Location
import com.example.aspentrip.locations_list.domain.LocationResponse
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LocationsListViewModel : ViewModel() {
    var selected by mutableStateOf(0)
    val locationsRepository = LocationsRepository()

    fun selectTab(tabIndex: Int) {
        selected = tabIndex
    }

    fun getLocations(): List<Location>? {
        var response : LocationResponse? = null
        runBlocking {
            launch  {
                response = locationsRepository.fetchLocations()
            }
        }
        val landmarks = response?.body
        return landmarks
    }
}