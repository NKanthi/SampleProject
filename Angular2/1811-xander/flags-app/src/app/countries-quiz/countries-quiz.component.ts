import { Component, OnInit, Injectable } from '@angular/core';
import { CountriesService } from './countries.service';

@Component({
  selector: 'app-countries-quiz',
  templateUrl: './countries-quiz.component.html',
  styleUrls: ['./countries-quiz.component.css']
})

@Injectable()
export class CountriesQuizComponent implements OnInit {
  quizHeader: string = "Countries quiz";
  countryList: any;


  constructor(private countriesService: CountriesService) { }

  ngOnInit() {
    this.getCountryList().subscribe(data => {
      this.countryList = data['countrycodes'];
    });
  }

  getCountryList() {
    return this.countriesService.getCountryList();
  }

}
