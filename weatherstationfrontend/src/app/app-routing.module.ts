import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SensorOverviewComponent } from './components/sensor-overview/sensor-overview.component';
import { SensorDetailedViewComponent } from './components/sensor-detailed-view/sensor-detailed-view.component';

const routes: Routes = [
  { path: '', component: SensorOverviewComponent },
  { path: 'sensor-overview', component: SensorOverviewComponent },
  { path: 'sensor/:id', component: SensorDetailedViewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
