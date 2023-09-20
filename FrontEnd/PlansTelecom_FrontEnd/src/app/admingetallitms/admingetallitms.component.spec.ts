import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmingetallitmsComponent } from './admingetallitms.component';

describe('AdmingetallitmsComponent', () => {
  let component: AdmingetallitmsComponent;
  let fixture: ComponentFixture<AdmingetallitmsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdmingetallitmsComponent]
    });
    fixture = TestBed.createComponent(AdmingetallitmsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
