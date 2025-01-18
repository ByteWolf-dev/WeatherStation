package com.example.weatherstation_tadeot.dtos

import java.time.LocalDateTime

data class SensorDto(
    val id: Long,
    val type: String,
    val model: String?,
    val installationDate: LocalDateTime?,
    val status: Boolean
)
