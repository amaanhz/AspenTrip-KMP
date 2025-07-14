package com.example.aspentrip.locations_list.domain

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val id: Int,
    val name: String,
    val imageURL: String,
    val rating: Double
) {}