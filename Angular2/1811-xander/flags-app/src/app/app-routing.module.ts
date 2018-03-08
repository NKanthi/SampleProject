import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TestcompComponent } from './testcomp/testcomp.component';
import { FlagsComponent } from './flags/flags.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CountriesQuizComponent } from './countries-quiz/countries-quiz.component';
import { DarksoulsQuizComponent } from './darksouls-quiz/darksouls-quiz.component';

const appRoutes: Routes = [
  { path: '', component: FlagsComponent },
  { path: 'countries-quiz', component: CountriesQuizComponent },
  { path: 'darksouls-quiz', component: DarksoulsQuizComponent },
  { path: 'testcomp', component: TestcompComponent },
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
