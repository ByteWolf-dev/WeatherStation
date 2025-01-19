package com.example.weatherstation_tadeot.model

import java.time.LocalDateTime

data class MeasurementDto(
    val id: Long,
    val sensorId: Long,
    val timestamp: LocalDateTime,
    val temperature: Float,
    val humidity: Float,
    val pressure: Float
)
