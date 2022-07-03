import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Candidato } from '../candidatos/model/candidato';

@Injectable({
  providedIn: 'root',
})
export class CandidatosService {
  constructor(private httpClient: HttpClient) {}

  save(candidato: Candidato) {
    console.log(candidato);
  }
}
