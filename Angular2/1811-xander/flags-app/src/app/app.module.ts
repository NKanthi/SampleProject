import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { FlagsService } from './flags/flags.service';
import { CountriesService } from './countries-quiz/countries.service';

import { FlagsComponent } from './flags/flags.component';
import { MatButtonModule } from '@angular/material/button';
import { TestcompComponent } from './testcomp/testcomp.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CountriesQuizComponent } from './countries-quiz/countries-quiz.component';
import { DarksoulsQuizComponent } from './darksouls-quiz/darksouls-quiz.component';
import { QuizButtonComponent } from './quiz-components/quiz-button/quiz-button.component';
import { QuizMainComponent } from './quiz-components/quiz-main/quiz-main.component';



@NgModule({
  declarations: [
    AppComponent,
    FlagsComponent,
    TestcompComponent,
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
  providers: [FlagsService, CountriesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
