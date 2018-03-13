import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CountriesQuizComponent } from './countries-quiz/countries-quiz.component';
import { DarksoulsQuizComponent } from './darksouls-quiz/darksouls-quiz.component';

const appRoutes: Routes = [
  { path: '', component: CountriesQuizComponent },
  { path: 'countries-quiz', component: CountriesQuizComponent },
  { path: 'darksouls-quiz', component: DarksoulsQuizComponent },
  { path: '**', component: PageNotFoundComponent }

];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
