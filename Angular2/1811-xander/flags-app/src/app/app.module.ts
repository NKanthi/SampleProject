import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { CountriesService } from './countries-quiz/countries.service';
import { DarksoulsService } from './darksouls-quiz/darksouls.service';

import { MatButtonModule } from '@angular/material/button';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CountriesQuizComponent } from './countries-quiz/countries-quiz.component';
import { DarksoulsQuizComponent } from './darksouls-quiz/darksouls-quiz.component';
import { QuizButtonComponent } from './quiz-components/quiz-button/quiz-button.component';
import { QuizMainComponent } from './quiz-components/quiz-main/quiz-main.component';



@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    CountriesQuizComponent,
    DarksoulsQuizComponent,
    QuizButtonComponent,
    QuizMainComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatButtonModule,
    AppRoutingModule
  ],
  providers: [CountriesService, DarksoulsService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
