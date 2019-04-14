import { TestBed } from '@angular/core/testing';

import { UserInstrumentService } from './user-instrument.service';

describe('UserInstrumentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserInstrumentService = TestBed.get(UserInstrumentService);
    expect(service).toBeTruthy();
  });
});
