import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { IPosts } from './iposts';
import { CountryCodes } from './country-codes'

@Injectable()
export class ProductService {  
  // private _postsURL = "https://jsonplaceholder.typicode.com/posts";
   
   //End point
   private _getCountryCodes = '/assets/data/api/countrycodes.json';
 
   // to initialize http object
   constructor(private http: Http) {
   }
 
   // Create observer for CountryCodes
   getCountryCodes() : Observable<CountryCodes[]> {
         return this.http
             .get(this._getCountryCodes)
             .map((responseCC: Response) => {
                 //return  Array.of(<CountryCodes[]>responseCC.json());
				 return  <CountryCodes[]>responseCC.json();
             })
             .catch(this.handleError);
     }
	 
   // Handle error
     private handleError(error: Response) {
         return Observable.throw(error.statusText);
     }  
}