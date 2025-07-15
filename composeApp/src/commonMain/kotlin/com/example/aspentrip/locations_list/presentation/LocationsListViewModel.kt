package com.example.aspentrip.locations_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aspentrip.locations_list.domain.Location
import com.example.aspentrip.locations_list.domain.LocationResponse
import com.example.aspentrip.locations_list.domain.LocationsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LocationsListViewModel(
    val locationsRepository: LocationsRepository
) : ViewModel() {
    private val _locationsListState = MutableStateFlow(LocationsListState())

    val locationsListState = _locationsListState
        .onStart {
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _locationsListState.value
        )

    fun onAction(action: LocationsListAction) {
        when (action) {
            is LocationsListAction.OnTabSelected -> {
                _locationsListState.update {
                    it.copy(tabSelected = action.index)
                }
            }
        }
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

    fun getRecommended(): List<Location>? {
        var response : LocationResponse? = null
        runBlocking {
            launch  {
                response = locationsRepository.fetchRecommended()
            }
        }
        val landmarks = response?.body
        return landmarks
    }
}