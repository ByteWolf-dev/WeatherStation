package com.example.weatherstation_tadeot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherstation_tadeot.ui.layout.SensorDataView
import com.example.weatherstation_tadeot.ui.layout.SensorSelectionView
import com.example.weatherstation_tadeot.ui.layout.SensorViewModel
import com.example.weatherstation_tadeot.ui.theme.WeatherStation_TadeotTheme
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
    val viewModel: SensorViewModel = viewModel()
    val selectedSensor = viewModel.selectedSensor.observeAsState()

    if (selectedSensor.value == null) {
        SensorSelectionView { sensor ->
            viewModel.selectSensor(sensor)
        }
    } else {
        SensorDataView(sensor = selectedSensor.value!!, viewModel = viewModel, onBack = {
            viewModel.selectSensor(null)
        })
    }
}