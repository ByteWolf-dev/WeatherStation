package com.example.weatherstation_tadeot.ui.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherstation_tadeot.model.SensorDto
import java.util.logging.Logger

@Composable
fun SensorSelectionView(onSensorSelected: (SensorDto) -> Unit) {
    val viewModel: SensorViewModel = viewModel()
    val sensors = viewModel.sensors.observeAsState(emptyList())
    val logger = Logger.getLogger(SensorViewModel::class.java.name)
    logger.info("Sensors: ${sensors.value}")

    LaunchedEffect(Unit) {
        viewModel.fetchSensors()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Sensors",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        sensors.value.forEach { sensor ->
            SensorCard(sensor = sensor, onClick = { onSensorSelected(sensor) })
        }
    }
}

@Composable
fun SensorCard(sensor: SensorDto, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .wrapContentWidth() // Adjust the width
            .height(150.dp) // Adjust the height
            .clickable { onClick() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Sensor model or type
            Text(
                text = sensor.model ?: sensor.type,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Sensor ID
            Text(
                text = "Sensor type: ${sensor.type}",
                style = MaterialTheme.typography.bodyMedium
            )

            // Button to view details
            Button(
                onClick = { onClick() },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 8.dp)
            ) {
                Text(text = "View Details")
            }
        }
    }
}