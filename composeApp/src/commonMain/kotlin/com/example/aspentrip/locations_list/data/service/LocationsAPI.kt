package com.example.aspentrip.locations_list.data.service

import com.example.aspentrip.locations_list.domain.LocationResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Header

interface LocationsAPI {
    @GET("landmarks")
    suspend fun getLocations(
        @Header("location") location: String
    ): LocationResponse

    @GET("recommended")
    suspend fun getRecommended(): LocationResponse

}