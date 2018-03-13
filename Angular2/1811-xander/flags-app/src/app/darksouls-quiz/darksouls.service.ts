import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/observable/forkJoin';

@Injectable()
export class DarksoulsService {

  constructor(private http: HttpClient) { }

  getDSbossList() {
    return this.http.get('../assets/DSbosses0.json');
  }

  addsourcesToBossList(dataList:any) {
    var observableArray = this.createObservableArray(dataList);
    Observable.forkJoin(observableArray).subscribe(responses => {
      for (var i = 0; i < responses.length; i++) {
        this.addImgSrc(dataList[i], responses[i]);
      }
    });
  }

  createObservableArray(dataList:any) {
    var observableArray = [];
    for (var boss of dataList) {
      var url = this.constructSearchQuery(boss.name);
      observableArray.push(this.getResponse(url));
    }

    return observableArray;
  }

  getResponse(url:string) {
    return this.http.get(url,{responseType: 'text'})
  }

  constructSearchQuery(bossName:string) {
    if((bossName == 'Chaos Witch Quelaag') || (bossName == 'The Dukes Dear Freja')) {
      bossName = 'puppy';
    }

    while(bossName.includes(' ')) {
      bossName = bossName.replace(' ', '+')
    }

    return 'https://www.google.nl/search?tbm=isch&as_q=' + bossName + '+darksouls';
  }

  addImgSrc(boss:any, response:any) {
    var myRe = new RegExp(/<img class=\"rg_ic rg_i\"(?: data-src=\"(.+?)\").+?>/g);
    var match = myRe.exec(response);
    boss.src = match[1];
  }

  test(tempList:any) {
    tempList[0].name = "test";
  }

}
