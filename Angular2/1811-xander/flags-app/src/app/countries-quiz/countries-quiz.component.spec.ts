import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CountriesQuizComponent } from './countries-quiz.component';
import { CountriesService } from './countries.service';
import { HttpClientTestingModule } from '@angular/common/http/testing'
import { QuizButtonComponent } from '../quiz-components/quiz-button/quiz-button.component';
import { QuizMainComponent } from '../quiz-components/quiz-main/quiz-main.component';



describe('CountriesQuizComponent', () => {
  let component: CountriesQuizComponent;
  let fixture: ComponentFixture<CountriesQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountriesQuizComponent, QuizMainComponent, QuizButtonComponent],
      providers: [CountriesService]
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
