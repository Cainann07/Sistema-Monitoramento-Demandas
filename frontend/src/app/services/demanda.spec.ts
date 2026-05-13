import { TestBed } from '@angular/core/testing';

import { Demanda } from './demanda';

describe('Demanda', () => {
  let service: Demanda;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Demanda);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
