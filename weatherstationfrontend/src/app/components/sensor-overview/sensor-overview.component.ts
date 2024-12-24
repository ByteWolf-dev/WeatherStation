import { Component, OnInit } from '@angular/core';
import { WeatherStationService } from '../../weatherstation.service';
import { Sensor } from '../../models';

@Component({
  selector: 'app-sensor-overview',
  templateUrl: './sensor-overview.component.html',
  styleUrls: ['./sensor-overview.component.css'],
  standalone: false
})
export class SensorOverviewComponent implements OnInit {
  sensors: Sensor[] = [];

  constructor(private weatherStationService: WeatherStationService) {}

  ngOnInit(): void {
    this.weatherStationService.getSensors().subscribe(
      (data: Sensor[]) => {
        this.sensors = data;
      },
      (error: any) => {
        console.error('Error fetching sensors', error);
      }
    );
  }
}
