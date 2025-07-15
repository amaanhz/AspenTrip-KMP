package com.example.aspentrip.locations_list.presentation

sealed interface LocationsListAction {
    data class OnTabSelected(val index: Int): LocationsListAction
}