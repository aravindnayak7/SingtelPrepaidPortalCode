import { TestBed } from '@angular/core/testing';

import { PlannamesService } from './plannames.service';

describe('PlannamesService', () => {
  let service: PlannamesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlannamesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
