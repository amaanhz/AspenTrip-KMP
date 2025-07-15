package com.example.aspentrip.locations_list.domain

interface LocationsRepository {
    suspend fun fetchLocations(): LocationResponse
    suspend fun fetchRecommended(): LocationResponse
}