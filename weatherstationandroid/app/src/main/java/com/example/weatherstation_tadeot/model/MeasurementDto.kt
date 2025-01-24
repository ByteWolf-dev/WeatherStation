package com.example.weatherstation_tadeot.model


data class MeasurementDto(
    val id: Long,
    val sensorId: Long,
    val timestamp: String,
    val temperature: Float,
    val humidity: Float,
    val pressure: Float
)
