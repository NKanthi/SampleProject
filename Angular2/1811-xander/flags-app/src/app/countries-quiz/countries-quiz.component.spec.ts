import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountriesQuizComponent } from './countries-quiz.component';

describe('CountriesQuizComponent', () => {
  let component: CountriesQuizComponent;
  let fixture: ComponentFixture<CountriesQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountriesQuizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountriesQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
