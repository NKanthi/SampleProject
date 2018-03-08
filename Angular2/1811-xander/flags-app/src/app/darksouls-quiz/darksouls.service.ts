import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DarksoulsService {

  constructor(private http: HttpClient) { }

  getDSbossList() {
    return this.http.get('../assets/DSbosses.json');
  }

  addsourcesToBossList(bossList: any) {
    for (var boss of bossList) {
      this.getGoogleImageSrcFromResponse(boss);
    }
  }

  getGoogleImageSrcFromResponse(boss) {
    this.getGoogleImagesResponseByBoss(boss.name).subscribe(data => {
      var myRe = new RegExp(/<img class=\"rg_ic rg_i\"(?: data-src=\"(.+?)\").+?>/g);
      var match = myRe.exec(data);
      boss.src = match[1];
    });
  }

  getGoogleImagesResponseByBoss(bossName) {
    var url: string = this.createGoogleSearchQuery(bossName);
    return this.http.get(url, {responseType: 'text'});
  }

  createGoogleSearchQuery(bossName) {
    if((bossName == 'Chaos Witch Quelaag') || (bossName == 'The Dukes Dear Freja')) {
          bossName = 'puppy';
        }
        while(bossName.includes(' ')) {
          bossName = bossName.replace(' ', '+')
        }
        return 'https://www.google.nl/search?tbm=isch&as_q=' + bossName + '+darksouls';
  }




}
