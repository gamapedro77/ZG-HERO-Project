import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable, tap } from 'rxjs';
import { Competencia } from '../model/competencia';
@Injectable({
  providedIn: 'root',
})
export class CompetenciaService {
  private readonly API = 'api/competencia';

  constructor(private httpClient: HttpClient) {}

  list() {
    return this.httpClient.get<Competencia[]>(this.API).pipe(tap());
  }

  listCompetenciasCandidato(candidatoId: number) {
    return candidatoId;
  }

  saveCompetencia(competencia: Competencia) {
    return this.httpClient
      .post<Competencia>(this.API, competencia)
      .pipe(first());
  }

  saveCompetenciasCandidato(candidatoId: string, competencias: Competencia[]) {
    competencias.forEach((competencia) => {
      if (competencia._id == null) {
        this.saveCompetencia(competencia).subscribe((result) => {
          console.log(result);
          this.httpClient
            .post(`api/candidato/${candidatoId}/competencia/${result._id}`, {})
            .pipe(first())
            .subscribe((competenciaCandidato) => {
              console.log(competenciaCandidato);
            });
        });
      }
    });
  }
}
