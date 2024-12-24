import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SensorDetailedViewComponent } from './sensor-detailed-view.component';

describe('SensorDetailedViewComponent', () => {
  let component: SensorDetailedViewComponent;
  let fixture: ComponentFixture<SensorDetailedViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SensorDetailedViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SensorDetailedViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
