import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Candidato } from '../model/candidato';
import { first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CandidatoService {
  private readonly API = 'api/candidatos';
  constructor(private httpClient: HttpClient) {}

  list() {
    return this.httpClient.get(this.API);
  }
  save(candidato: Candidato) {
    console.log('ablubluble');
    return this.httpClient.post<Candidato>(this.API, candidato).pipe(first());
  }
}
