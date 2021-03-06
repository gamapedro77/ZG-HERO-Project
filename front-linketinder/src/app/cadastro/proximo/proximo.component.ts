import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatChipInputEvent } from '@angular/material/chips';
import { ActivatedRoute, Router } from '@angular/router';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { Competencia } from '../model/competencia';
import { CompetenciaService } from '../services/competencia.service';
import { CandidatoService } from '../services/candidato.service';

@Component({
  selector: 'app-proximo',
  templateUrl: './proximo.component.html',
  styleUrls: ['./proximo.component.scss'],
})
export class ProximoComponent implements OnInit {
  candidatoId;
  habilidades: Competencia[] = [];
  formDescricao: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private competenciaService: CompetenciaService,
    private candidatoService: CandidatoService,
    private router: Router
  ) {
    this.candidatoId = this.route.snapshot.paramMap.get('candidatoId');
    this.formDescricao = this.formBuilder.group({
      dataNascimento: [null],
      pais: [null],
      descricao: [null],
    });
  }

  addOnBlur = true;
  readonly separatorKeysCodes = [ENTER, COMMA] as const;

  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();

    // Add our fruit
    if (value) {
      this.habilidades.push({ _id: null, nome: value });
    }

    // Clear the input value
    event.chipInput!.clear();
  }

  remove(competencia: Competencia): void {
    const index = this.habilidades.indexOf(competencia);

    if (index >= 0) {
      this.habilidades.splice(index, 1);
    }
  }

  onSubmit() {
    console.log(this.formDescricao.value);
    if (this.candidatoId != null) {
      this.competenciaService.saveCompetenciasCandidato(
        this.candidatoId,
        this.habilidades
      );

      this.candidatoService
        .update(this.formDescricao.value, this.candidatoId)
        .subscribe();
    }

    this.router.navigate(['/login']);
  }
  onReturn() {}

  ngOnInit(): void {}
}
