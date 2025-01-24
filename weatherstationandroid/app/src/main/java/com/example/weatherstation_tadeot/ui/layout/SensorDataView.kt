package com.example.weatherstation_tadeot.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherstation_tadeot.model.MeasurementDto
import com.example.weatherstation_tadeot.model.SensorDto
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

@Composable
fun SensorDataView(
    sensor: SensorDto,
    viewModel: SensorViewModel,
    onBack: () -> Unit
) {
    LaunchedEffect(sensor) {
        viewModel.fetchMeasurements(sensor.id)
    }

    val measurements = viewModel.measurements.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Title
        Text(
            text = "Measurements for Sensor: ${sensor.model?: sensor.type}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

//        // Display Line Charts
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
////            LineChartComponent(
////                title = "Temperature (°C)",
////                data = measurements.value.map { it.temperature.toFloat() }
////            )
////            LineChartComponent(
////                title = "Pressure (hPa)",
////                data = measurements.value.map { it.pressure.toFloat() }
////            )
////            LineChartComponent(
////                title = "Humidity (%)",
////                data = measurements.value.map { it.humidity.toFloat() }
////            )
//        }

        // Display Table
        TableComponent(measurements.value)

        // Back Button
        Button(
            onClick = { onBack() },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp)
        ) {
            Text(text = "Back to Overview")
        }
    }
}

//@Composable
//fun LineChartComponent(title: String, data: List<Float>) {
//    Column(
//        modifier = Modifier.width(200.dp)
//    ) {
//        Text(text = title, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 8.dp))
//        LineChart(
//            data = data,
//            lineDrawer = SolidLineDrawer(),
//            modifier = Modifier.height(150.dp)
//        )
//    }
//}

@Composable
fun TableComponent(measurements: List<MeasurementDto>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        // Table Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Timestamp",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Temperature (°C)",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Humidity (%)",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Pressure (hPa)",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
        }

        // Table Rows
        measurements.forEach { measurement ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = formatTimestamp(measurement.timestamp), modifier = Modifier.weight(1f))
                Text(text = measurement.temperature.toString(), modifier = Modifier.weight(1f))
                Text(text = measurement.humidity.toString(), modifier = Modifier.weight(1f))
                Text(text = measurement.pressure.toString(), modifier = Modifier.weight(1f))
            }
        }
    }
}

fun formatTimestamp(timestamp: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")
    val dateTime = LocalDateTime.parse(timestamp, inputFormatter)
    return dateTime.format(outputFormatter)
}
