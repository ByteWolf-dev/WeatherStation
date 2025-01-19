package com.example.weatherstation_tadeot.model

data class SensorDto(
    val id: Long,
    val type: String,
    val model: String?,
    val installationDate: String?,
    val status: Boolean
)
