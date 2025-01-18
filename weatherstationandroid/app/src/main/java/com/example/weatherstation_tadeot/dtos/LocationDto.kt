package com.example.weatherstation_tadeot.dtos

data class LocationDto(
    val id: Long,
    val sensorId: Long,
    val name: String,
    val description: String?
)
