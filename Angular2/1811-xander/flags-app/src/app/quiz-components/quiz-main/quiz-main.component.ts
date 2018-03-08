import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'quiz-main',
  templateUrl: './quiz-main.component.html',
  styleUrls: ['./quiz-main.component.css']
})
export class QuizMainComponent implements OnInit {
  @Input('header') header: string;
  @Input('dataSource') dataSource : any;

  constructor() { }

  ngOnInit() {
    console.log(this.dataSource);
  }

}
