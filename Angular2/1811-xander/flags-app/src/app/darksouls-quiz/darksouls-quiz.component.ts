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
      this.bossList = data['DSbosses'];
      this.addsourcesToBossList(this.bossList);
    });
  }

  getBossList() {
    return this.darksoulsService.getDSbossList();
  }

  addsourcesToBossList(dataList: any) {
    this.darksoulsService.addsourcesToBossList(dataList);
  }


}
