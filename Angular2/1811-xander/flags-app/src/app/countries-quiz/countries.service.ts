import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CountriesService {

  constructor(private http: HttpClient) { }

  getCountryList() {
    return this.http.get("../assets/countrycodes.json");
  }

}
