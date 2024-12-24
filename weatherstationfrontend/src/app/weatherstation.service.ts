import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Measurement, Sensor } from './models';

@Injectable({
  providedIn: 'root'
})
export class WeatherStationService {
  private baseUrl = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  getSensors(): Observable<Sensor[]> {
    return this.http.get<Sensor[]>(this.baseUrl + 'sensors');
  }

  getMeasurementsBySensorId(sensorId: number): Observable<Measurement[]> {
    return this.http.get<Measurement[]>(this.baseUrl + 'measurements/sensor/' + sensorId);
  }
}
