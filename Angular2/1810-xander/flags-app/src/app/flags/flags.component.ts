import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatButtonModule } from '@angular/material'

@Component({
  selector: 'app-flags',
  templateUrl: './flags.component.html',
  styleUrls: ['./flags.component.css']
})

@Injectable()
export class FlagsComponent implements OnInit {
  countryA: any;
  countryB: any;
  ImgSrcCountryCode: string;
  correctAnswer: string;
  userAnswer: string;
  countryCodesResponse: any;
  outputMessage: string;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getCountriesFromJson()
  }

  getCountriesFromJson() {
    this.http.get('../assets/countrycodes.json').subscribe(data => {
      this.countryCodesResponse = data['countrycodes'];
      this.setCountriesAndAwnser();
    });
  }

  setCountriesAndAwnser() {
      this.countryA = this.countryCodesResponse[this.getRandomCountry()];
      this.countryB = this.countryCodesResponse[this.getRandomCountry()];

    if(this.countryA == this.countryB) {
      this.setCountriesAndAwnser();
    }

    if ( Math.round(Math.random()) ) {
      this.correctAnswer = this.countryA.name;
      this.ImgSrcCountryCode = this.countryA.code;
    } else {
      this.correctAnswer = this.countryB.name;
      this.ImgSrcCountryCode = this.countryB.code;
    }
  }

  getRandomCountry() {
    return Math.floor(Math.random() * (this.countryCodesResponse.length));
  }

  UserSelectanswer(event: any) {
    if(this.correctAnswer == event.target.textContent) {
      this.outputMessage = "Correct"
    } else {
      this.outputMessage = "Wrong"
    }
  }

  reset() {
    this.setCountriesAndAwnser()
    this.outputMessage = "";
  }

}
