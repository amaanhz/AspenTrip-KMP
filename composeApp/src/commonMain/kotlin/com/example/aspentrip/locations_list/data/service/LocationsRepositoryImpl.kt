package com.example.aspentrip.locations_list.data.service

import com.example.aspentrip.locations_list.domain.LocationResponse
import com.example.aspentrip.locations_list.domain.LocationsRepository
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json



class LocationsRepositoryImpl : LocationsRepository {
    val myClient = HttpClient() {
        install(ContentNegotiation) {
            json(Json { isLenient = true; ignoreUnknownKeys = true })
        }
    }
    val kfit = Ktorfit.Builder().httpClient(myClient).baseUrl("http://192.168.0.189:3001/").build()
    val locationsAPI = kfit.createLocationsAPI()

    override suspend fun fetchLocations(): LocationResponse {
        val response = locationsAPI.getLocations("aspen")
        return response
    }

    override suspend fun fetchRecommended(): LocationResponse {
        val response = locationsAPI.getRecommended()
        return response
    }
}