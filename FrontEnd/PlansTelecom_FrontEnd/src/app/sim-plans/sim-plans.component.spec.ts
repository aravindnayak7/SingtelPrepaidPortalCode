import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimPlansComponent } from './sim-plans.component';

describe('SimPlansComponent', () => {
  let component: SimPlansComponent;
  let fixture: ComponentFixture<SimPlansComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SimPlansComponent]
    });
    fixture = TestBed.createComponent(SimPlansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
