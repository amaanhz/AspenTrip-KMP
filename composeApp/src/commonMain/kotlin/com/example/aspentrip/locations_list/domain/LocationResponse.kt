package com.example.aspentrip.locations_list.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    @SerialName("body") val body: List<Location>
) {
}