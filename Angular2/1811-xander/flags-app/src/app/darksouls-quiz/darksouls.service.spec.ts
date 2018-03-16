import { TestBed, inject } from '@angular/core/testing';

import { DarksoulsService } from './darksouls.service';

describe('DarksoulsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DarksoulsService]
    });
  });

  it('should be created', inject([DarksoulsService], (service: DarksoulsService) => {
    expect(service).toBeTruthy();
  }));
});
