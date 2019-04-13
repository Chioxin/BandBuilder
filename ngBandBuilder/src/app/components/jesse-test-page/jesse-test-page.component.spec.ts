import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JesseTestPageComponent } from './jesse-test-page.component';

describe('JesseTestPageComponent', () => {
  let component: JesseTestPageComponent;
  let fixture: ComponentFixture<JesseTestPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JesseTestPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JesseTestPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
