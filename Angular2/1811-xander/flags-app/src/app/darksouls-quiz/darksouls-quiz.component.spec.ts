import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DarksoulsQuizComponent } from './darksouls-quiz.component';

describe('DarksoulsQuizComponent', () => {
  let component: DarksoulsQuizComponent;
  let fixture: ComponentFixture<DarksoulsQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DarksoulsQuizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DarksoulsQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
