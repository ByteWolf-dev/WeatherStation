package com.example.weatherstation_tadeot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherstation_tadeot.model.SensorDto
import com.example.weatherstation_tadeot.ui.layout.SensorDataView
import com.example.weatherstation_tadeot.ui.layout.SensorSelectionView
import com.example.weatherstation_tadeot.ui.theme.WeatherStation_TadeotTheme
import com.example.weatherstation_tadeot.ui.layout.SensorViewModel
import com.jakewharton.threetenabp.AndroidThreeTen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)
        setContent {
            WeatherStation_TadeotTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val selectedSensor = remember { mutableStateOf<SensorDto?>(null) }
    val viewModel: SensorViewModel = viewModel()

    if (selectedSensor.value == null) {
        SensorSelectionView { sensor ->
            selectedSensor.value = sensor
            viewModel.selectSensor(sensor)
        }
    } else {
        SensorDataView(sensor = selectedSensor.value!!, viewModel = viewModel)
    }
}