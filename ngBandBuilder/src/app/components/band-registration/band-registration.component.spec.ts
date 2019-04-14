import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BandRegistrationComponent } from './band-registration.component';

describe('BandRegistrationComponent', () => {
  let component: BandRegistrationComponent;
  let fixture: ComponentFixture<BandRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BandRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BandRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
