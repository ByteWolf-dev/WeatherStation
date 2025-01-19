package com.example.weatherstation_tadeot.ui.layout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherstation_tadeot.model.SensorDto
import com.example.weatherstation_tadeot.model.MeasurementDto
import com.example.weatherstation_tadeot.model.RetrofitClient
import kotlinx.coroutines.launch
import java.util.logging.Logger

class SensorViewModel : ViewModel() {
    private val apiService = RetrofitClient.instance
    private val logger = Logger.getLogger(SensorViewModel::class.java.name)

    var sensors: List<SensorDto> = emptyList()
        private set

    var measurements: List<MeasurementDto> = emptyList()
        private set

    var selectedSensor: SensorDto? = null
        private set

    fun fetchSensors() {
        viewModelScope.launch {
            try {
                val response = apiService.getSensors()
                sensors = response
                logger.info("Fetched sensors: $sensors")
            } catch (e: Exception) {
                logger.warning("Failed to fetch sensors: ${e.message}")
            }
        }
    }

    fun fetchMeasurements(sensorId: Long) {
        viewModelScope.launch {
            try {
                val response = apiService.getMeasurementBySensorId(sensorId)
                measurements = response
                logger.info("Fetched measurements: $measurements")
            } catch (e: Exception) {
                logger.warning("Failed to fetch measurements: ${e.message}")
            }
        }
    }

    fun selectSensor(sensor: SensorDto) {
        selectedSensor = sensor
    }
}