import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import 'rxjs/add/operator/map';
import { ProductService } from './product.service';
import { IPosts } from './iposts';
import { CountryCodes } from './country-codes';
import { trigger,state,style,transition,animate,keyframes } from '@angular/animations';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers: [ProductService]
})

export class ProductComponent implements OnInit{
	
	 // to store the respose josn array
	_postCountryFlagList: CountryCodes[];
	
	 //to get the button name (based on flag value.name)
	 btnTextOne: string = '';
	 btnTextTwo: string = '';	 
	 btnGenerateNew: string = 'Another!';	 
	 //to get the index of flag code
	 countryOneIndex: number = 0;
	 countryTwoIndex:  number = 0;
	 flag: string = '';	 
	 //to store correct answer
	 correctAnswer: string = '';	  	 
	 //message
	 userAnswer: string = '';	 
	 message: string = '';
	 successMessage: string = ': is correct answer.'
	 failedMessage: string = 'Nope! Correct answer is :';
	 
  
    //to initialize ProductService
	constructor(private productService:ProductService){				
	}
	
	 // Subscribe getCountryCodes service
	 getCountryCodes(): void {
        this.productService.getCountryCodes()
             .subscribe(
                 resultCountryArray => this._postCountryFlagList = resultCountryArray,
                 error => console.log("Error :: " + error)				 				
             )	
     }
	 	
	 //run on load of page
	 ngOnInit() {		
		//to print and check response on console.		
		this.getCountryCodes();
		//this.getPosts();		
		this.productService.getCountryCodes().subscribe(country => {			
			this.getRandomCoutriesToDisplay();					
		});			 
	}
	
	//Method to generate country name randomly
	getRandomCoutriesToDisplay() {
		this.message = '';	
				
		//get country code
		this.countryOneIndex = this.getRandomCountry();
		this.countryTwoIndex = this.getRandomCountry();
		
				
		//initiate image index.
		this.flag = '/assets/data/svg/' + this._postCountryFlagList[this.countryOneIndex].code + '.svg';
		this.correctAnswer = this._postCountryFlagList[this.countryOneIndex].name;		
				
		//generate button text		
		this.btnTextOne = this._postCountryFlagList[this.countryOneIndex].name;
		this.btnTextTwo = this._postCountryFlagList[this.countryTwoIndex].name;				
		
		//print values on console
		console.log(this._postCountryFlagList);
		console.log(this._postCountryFlagList[this.countryOneIndex].name);
		console.log(this._postCountryFlagList[this.countryTwoIndex].name);		
	}
	
	//random country generator
	getRandomCountry() {
		return Math.floor(Math.random() * (this._postCountryFlagList.length));	
    }
	
	//to check for correct answer (on click event)
	checkCountryInput(event) {
		 //get button text
		 this.userAnswer = event.target.id;
		 
		 //compare button text with actual answer
		if (this.userAnswer == this.correctAnswer) {
          this.message = this.correctAnswer + this.successMessage;
        }
        else {
          this.message = this.failedMessage + this.correctAnswer;
        }
	}		
}
