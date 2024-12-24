import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SensorOverviewComponent } from './components/sensor-overview/sensor-overview.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { SensorDetailedViewComponent } from './components/sensor-detailed-view/sensor-detailed-view.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    SensorOverviewComponent,
    SensorDetailedViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
