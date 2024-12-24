import { Component, OnInit, AfterViewChecked } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Measurement } from '../../models';
import { WeatherStationService } from '../../weatherstation.service';
import { Chart, CategoryScale, LinearScale, Title, Tooltip, Legend, LineElement, PointElement, ArcElement, LineController } from 'chart.js';

// Register all necessary components including the LineController
Chart.register(
  CategoryScale,
  LinearScale,
  Title,
  Tooltip,
  Legend,
  LineElement,
  PointElement,
  ArcElement,
  LineController // Ensure the LineController is registered
);

@Component({
  selector: 'app-sensor-detailed-view',
  templateUrl: './sensor-detailed-view.component.html',
  styleUrls: ['./sensor-detailed-view.component.css'],
  standalone: false
})
export class SensorDetailedViewComponent implements OnInit, AfterViewChecked {
  measurements: Measurement[] = [];
  sensorId!: number;
  chartCreated: boolean = false; // Flag to track if the chart is created

  constructor(
    private weatherStationService: WeatherStationService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.sensorId = +params['id'];
      this.loadMeasurements(this.sensorId);
    });
  }

  ngAfterViewChecked(): void {
    if (this.measurements.length > 0 && !this.chartCreated) {
      this.renderTemperatureChart();
      this.renderPressureChart();
      this.renderHumidityChart();
    }
  }

  loadMeasurements(sensorId: number): void {
    this.weatherStationService.getMeasurementsBySensorId(sensorId).subscribe(
      (data: Measurement[]) => {
        this.measurements = data;
        // Re-render charts after measurements are loaded
        this.renderTemperatureChart();
        this.renderPressureChart();
        this.renderHumidityChart();
      },
      (error: any) => {
        console.error('Error fetching measurements', error);
      }
    );
  }

  getMinMax(data: number[]): { min: number, max: number } {
    const min = Math.min(...data);
    const max = Math.max(...data);
    return { min, max };
  }

  renderTemperatureChart(): void {
    if (this.measurements.length === 0) return; // No measurements to display
  
    const temperatureData: number[] = this.measurements.map(m => m.temperature);
    const timestamps: string[] = this.measurements.map(m => m.timestamp);
  
    const ctx: HTMLCanvasElement | null = document.getElementById('temperatureChart') as HTMLCanvasElement;
  
    if (!ctx) {
      console.error('Canvas element not found!');
      return;
    }
  
    if (this.chartCreated) {
      this.destroyChart('temperatureChart');
    }
  
    const { min: tempMin, max: tempMax } = this.getMinMax(temperatureData);
  
    this.createChart(ctx, timestamps, temperatureData, tempMin, tempMax, 'Temperature (°C)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 0.2)');
    this.chartCreated = true;
  }

  renderPressureChart(): void {
    if (this.measurements.length === 0) return; // No measurements to display
  
    const pressureData: number[] = this.measurements.map(m => m.pressure);
    const timestamps: string[] = this.measurements.map(m => m.timestamp);
  
    const ctx: HTMLCanvasElement | null = document.getElementById('pressureChart') as HTMLCanvasElement;
  
    if (!ctx) {
      console.error('Canvas element not found!');
      return;
    }
  
    if (this.chartCreated) {
      this.destroyChart('pressureChart');
    }
  
    const { min: pressureMin, max: pressureMax } = this.getMinMax(pressureData);
  
    this.createChart(ctx, timestamps, pressureData, pressureMin, pressureMax, 'Pressure (hPa)', 'rgba(54, 162, 235, 1)', 'rgba(54, 162, 235, 0.2)');
  }

  renderHumidityChart(): void {
    if (this.measurements.length === 0) return; // No measurements to display
  
    const humidityData: number[] = this.measurements.map(m => m.humidity);
    const timestamps: string[] = this.measurements.map(m => m.timestamp);
  
    const ctx: HTMLCanvasElement | null = document.getElementById('humidityChart') as HTMLCanvasElement;
  
    if (!ctx) {
      console.error('Canvas element not found!');
      return;
    }
  
    if (this.chartCreated) {
      this.destroyChart('humidityChart');
    }
  
    const { min: humidityMin, max: humidityMax } = this.getMinMax(humidityData);
  
    this.createChart(ctx, timestamps, humidityData, humidityMin, humidityMax, 'Humidity (%)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 0.2)');
  }

  createChart(ctx: HTMLCanvasElement, timestamps: string[], data: number[], min: number, max: number, label: string, borderColor: string, backgroundColor: string): void {
    const chartInstance = new Chart(ctx, {
      type: 'line',
      data: {
        labels: timestamps,
        datasets: [{
          label: label,
          data: data,
          borderColor: borderColor,
          backgroundColor: backgroundColor,
          fill: true,
          tension: 0.1
        }]
      },
      options: {
        responsive: true,
        scales: {
          x: {
            type: 'category',
            title: {
              display: true,
              text: 'Timestamp'
            },
            ticks: {
              autoSkip: true,
              maxTicksLimit: 5
            }
          },
          y: {
            type: 'linear',
            title: {
              display: true,
              text: label
            },
            suggestedMin: min - 5,
            suggestedMax: max + 5,
          }
        }
      }
    });

    (ctx as any)['chart'] = chartInstance;
  }

  destroyChart(chartId: string): void {
    const ctx: HTMLCanvasElement | null = document.getElementById(chartId) as HTMLCanvasElement;
    if (ctx && (ctx as any)['chart']) {
      (ctx as any)['chart'].destroy();
      console.log(`Chart destroyed: ${chartId}`);
      this.chartCreated = false;
    }
  }

  goBack(): void {
    this.router.navigate(['/']);
  }
}
