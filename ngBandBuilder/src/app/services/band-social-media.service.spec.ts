import { TestBed } from '@angular/core/testing';

import { BandSocialMediaService } from './band-social-media.service';

describe('BandSocialMediaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BandSocialMediaService = TestBed.get(BandSocialMediaService);
    expect(service).toBeTruthy();
  });
});
