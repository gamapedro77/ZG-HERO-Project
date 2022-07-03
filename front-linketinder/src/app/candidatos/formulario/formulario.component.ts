import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CandidatosService } from 'src/app/shared/candidatos.service';
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
    private service: CandidatosService
  ) {
    this.form = this.isCpfUser
      ? formBuilder.group({
          nome: [null],
          email: [null],
          senha: [null],
          cpf: [null],
        })
      : formBuilder.group({
          nome: [null],
          email: [null],
          senha: [null],
          cnpj: [null],
        });
  }

  ngOnInit(): void {}

  onSubmit() {
    this.service.save(this.form.value);
  }

  onReturn() {}
}
