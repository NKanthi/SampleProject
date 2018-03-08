import { Component, OnInit, Injectable } from '@angular/core';
import { DarksoulsService } from './darksouls.service';


@Component({
  selector: 'app-darksouls-quiz',
  templateUrl: './darksouls-quiz.component.html',
  styleUrls: ['./darksouls-quiz.component.css']
})

@Injectable()
export class DarksoulsQuizComponent implements OnInit {
  quizHeader: String = 'Darksouls Quiz' ;
  bossList : any;

  constructor(private darksoulsService: DarksoulsService) { }

  ngOnInit() {
    this.getBossList().subscribe(data => {
      var tempBossList = data['DSbosses'];
      this.addsourcesToBossList(tempBossList);
      this.bossList = tempBossList;
    });
  }

  getBossList() {
    return this.darksoulsService.getDSbossList();
  }

  addsourcesToBossList(bossList: any) {
    this.darksoulsService.addsourcesToBossList(bossList);
  }



}
