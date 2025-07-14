package com.example.aspentrip.locations_list.data.service

import com.example.aspentrip.locations_list.domain.Location
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.http.GET

interface LocationsAPI {
    @GET("locations")
    suspend fun getLocations(): List<Location>
}

class LocationsService {
    val kfit = Ktorfit.Builder().baseUrl("http://192.168.0.189:3001/").build()
    val locationsAPI = kfit.create<LocationsAPI>()


    suspend fun fetchLocations() {
        val response = locationsAPI.getLocations()
        println(response)
    }
}