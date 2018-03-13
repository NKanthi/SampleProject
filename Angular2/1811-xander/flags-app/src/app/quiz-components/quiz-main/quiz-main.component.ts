import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'quiz-main',
  templateUrl: './quiz-main.component.html',
  styleUrls: ['./quiz-main.component.css']
})
export class QuizMainComponent implements OnInit {
  @Input('header') header: string;
  @Input('dataSource') dataSource : any;

  optionA : any;
  optionB : any;
  correctOption : string;
  imgSrc : string;
  outputMessage: string = "";

  constructor() { }

  ngOnInit() {
    this.setOptions();
  }

  setOptions() {
    this.optionA = this.dataSource[this.getRandomOptionFromDataSource()];
    this.optionB = this.dataSource[this.getRandomOptionFromDataSource()];

    if(this.optionA.name == this.optionB.name){
      this.setOptions();
    }

    if(Math.round(Math.random()) == 1) {
        this.correctOption = this.optionA.name;
        this.imgSrc = this.optionA.src;
    } else {
      this.correctOption = this.optionB.name;
      this.imgSrc = this.optionB.src;
    }
  }

  selectedOption(event: any) {
    if(this.correctOption == event.target.textContent) {
      this.outputMessage = "correct";
    } else {
      this.outputMessage = "incorrect";
    }
  }

  reset() {
    this.outputMessage = "";
    this.setOptions();
  }

  getRandomOptionFromDataSource() {
    return Math.floor(Math.random() * (this.dataSource.length));
  }


}
