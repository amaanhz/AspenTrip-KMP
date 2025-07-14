package com.example.aspentrip.locations_list.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("imageURL") val imageURL: String,
    @SerialName("rating") val rating: Double
) {}