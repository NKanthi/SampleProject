import { Component, OnInit, Input } from '@angular/core';
import { MatButtonModule } from '@angular/material';

@Component({
  selector: 'quiz-button',
  templateUrl: './quiz-button.component.html',
  styleUrls: ['./quiz-button.component.css']
})
export class QuizButtonComponent implements OnInit {
  @Input('option') option : string = 'option';

  constructor() { }

  ngOnInit() {
  }

}
