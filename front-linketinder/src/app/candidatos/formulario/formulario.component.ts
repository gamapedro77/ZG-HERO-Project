import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CandidatoService } from '../services/candidato.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.scss'],
})
export class FormularioComponent implements OnInit {
  isCpfUser = true;
  form: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private service: CandidatoService
  ) {
    this.form = this.isCpfUser
      ? this.formBuilder.group({
          nome: [null],
          email: [null],
          senha: [null],
          cpf: [null],
        })
      : this.formBuilder.group({
          nome: [null],
          email: [null],
          senha: [null],
          cnpj: [null],
        });
  }

  ngOnInit(): void {}

  onSubmit() {
    this.service.save(this.form.value).subscribe();
  }

  onReturn() {}
}
