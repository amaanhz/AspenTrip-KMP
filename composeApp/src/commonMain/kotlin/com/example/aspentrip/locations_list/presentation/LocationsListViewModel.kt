package com.example.aspentrip.locations_list.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LocationsListViewModel : ViewModel() {
    var selected by mutableStateOf(0)
    //val locationsService = LocationsService()

    fun selectTab(tabIndex: Int) {
        selected = tabIndex
    }

    /*fun getLocations() {
        runBlocking {
            launch  {
                val landmarks = locationsService.fetchLocations()
                print(landmarks)
            }
        }
    }*/
}