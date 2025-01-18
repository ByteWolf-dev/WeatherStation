package com.example.weatherstation_tadeot.services

import com.example.weatherstation_tadeot.dtos.LocationDto
import com.example.weatherstation_tadeot.dtos.MeasurementDto
import com.example.weatherstation_tadeot.dtos.SensorDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("locations")
    fun getLocations(): Call<List<LocationDto>>

    @GET("sensors")
    fun getSensors(): Call<List<SensorDto>>

    @GET("measurements")
    fun getMeasurements(): Call<List<MeasurementDto>>

    @GET("locations/{id}")
    fun getLocationById(@Path("id") id: Long): Call<LocationDto>

    @GET("sensors/{id}")
    fun getSensorById(@Path("id") id: Long): Call<SensorDto>

    @GET("measurements/{id}")
    fun getMeasurementById(@Path("id") id: Long): Call<MeasurementDto>

    @GET("measurements/{sensorId}")
    fun getMeasurementBySensorId(@Path("sensorId") sensorId: Long): Call<MeasurementDto>
}