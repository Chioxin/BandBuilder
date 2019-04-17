import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserInstrumentComponent } from './user-instrument.component';

describe('UserInstrumentComponent', () => {
  let component: UserInstrumentComponent;
  let fixture: ComponentFixture<UserInstrumentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserInstrumentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserInstrumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
