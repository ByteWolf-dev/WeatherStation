package com.example.weatherstation_tadeot.model

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("locations")
    suspend fun getLocations(): List<LocationDto>

    @GET("sensors")
    suspend fun getSensors(): ArrayList<SensorDto>

    @GET("measurements")
    suspend fun getMeasurements(): List<MeasurementDto>

    @GET("locations/{id}")
    suspend fun getLocationById(@Path("id") id: Long): LocationDto

    @GET("sensors/{id}")
    suspend fun getSensorById(@Path("id") id: Long): SensorDto

    @GET("measurements/{id}")
    suspend fun getMeasurementById(@Path("id") id: Long): MeasurementDto

    @GET("measurements/{sensorId}")
    suspend fun getMeasurementBySensorId(@Path("sensorId") sensorId: Long): List<MeasurementDto>
}