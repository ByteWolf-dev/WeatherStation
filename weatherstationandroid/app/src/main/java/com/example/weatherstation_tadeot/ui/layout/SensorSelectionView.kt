package com.example.weatherstation_tadeot.ui.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherstation_tadeot.model.SensorDto
import com.example.weatherstation_tadeot.ui.layout.SensorViewModel

@Composable
fun SensorSelectionView(onSensorSelected: (SensorDto) -> Unit) {
    val viewModel: SensorViewModel = viewModel()
    val sensors = viewModel.sensors

    LaunchedEffect(Unit) {
        viewModel.fetchSensors()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        sensors.forEach { sensor ->
            Text(
                text = sensor.type,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable { onSensorSelected(sensor) }
            )
        }
    }
}