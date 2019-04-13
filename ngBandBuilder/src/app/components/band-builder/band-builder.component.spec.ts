import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BandBuilderComponent } from './band-builder.component';

describe('BandBuilderComponent', () => {
  let component: BandBuilderComponent;
  let fixture: ComponentFixture<BandBuilderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BandBuilderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BandBuilderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
