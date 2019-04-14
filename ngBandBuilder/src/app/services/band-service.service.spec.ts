import { TestBed } from '@angular/core/testing';

import { BandServiceService } from './band-service.service';

describe('BandServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BandServiceService = TestBed.get(BandServiceService);
    expect(service).toBeTruthy();
  });
});
