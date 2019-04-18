import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GregsTestPageComponent } from './gregs-test-page.component';

describe('GregsTestPageComponent', () => {
  let component: GregsTestPageComponent;
  let fixture: ComponentFixture<GregsTestPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GregsTestPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GregsTestPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
