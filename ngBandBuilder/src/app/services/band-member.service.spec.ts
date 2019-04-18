import { TestBed } from '@angular/core/testing';

import { BandMemberService } from './band-member.service';

describe('BandMemberService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BandMemberService = TestBed.get(BandMemberService);
    expect(service).toBeTruthy();
  });
});
