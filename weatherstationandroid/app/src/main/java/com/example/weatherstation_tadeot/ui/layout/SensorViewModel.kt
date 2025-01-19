package com.example.weatherstation_tadeot.ui.layout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherstation_tadeot.model.MeasurementDto
import com.example.weatherstation_tadeot.model.RetrofitClient
import com.example.weatherstation_tadeot.model.SensorDto
import kotlinx.coroutines.launch
import java.util.logging.Logger

class SensorViewModel : ViewModel() {
    private val apiService = RetrofitClient.instance
    private val logger = Logger.getLogger(SensorViewModel::class.java.name)

    private val _sensors = MutableLiveData<List<SensorDto>>()
    val sensors: LiveData<List<SensorDto>> get() = _sensors

    private val _measurements = MutableLiveData<List<MeasurementDto>>()
    val measurements: LiveData<List<MeasurementDto>> get() = _measurements

    private val _selectedSensor = MutableLiveData<SensorDto?>()
    val selectedSensor: LiveData<SensorDto?> get() = _selectedSensor

    fun fetchSensors() {
        viewModelScope.launch {
            try {
                val response = apiService.getSensors()
                _sensors.value = response
                logger.info("Fetched sensors: $response")
            } catch (e: Exception) {
                logger.warning("Failed to fetch sensors: ${e.message}")
            }
        }
    }

    fun fetchMeasurements(sensorId: Long) {
        viewModelScope.launch {
            try {
                val response = apiService.getMeasurementBySensorId(sensorId)
                _measurements.value = response
                logger.info("Fetched measurements: $response")
            } catch (e: Exception) {
                logger.warning("Failed to fetch measurements: ${e.message}")
            }
        }
    }

    fun selectSensor(sensor: SensorDto?) {
        _selectedSensor.value = sensor
    }
}