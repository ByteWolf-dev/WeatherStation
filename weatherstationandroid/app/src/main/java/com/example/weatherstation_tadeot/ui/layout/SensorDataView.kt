package com.example.weatherstation_tadeot.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherstation_tadeot.model.SensorDto
import com.example.weatherstation_tadeot.ui.layout.SensorViewModel

@Composable
fun SensorDataView(sensor: SensorDto, viewModel: SensorViewModel) {
    LaunchedEffect(sensor) {
        viewModel.fetchMeasurements(sensor.id)
    }

    val measurements = viewModel.measurements

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Sensor Data for ${sensor.type}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        measurements.forEach { measurement ->
            Text(
                text = "Measurement: ${measurement.humidity}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}