import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Candidato } from '../model/candidato';
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
    private service: CandidatoService,
    private router: Router
  ) {
    this.form = this.formBuilder.group({
      nome: [null],
      email: [null],
      senha: [null],
      cpf: [null],
      cnpj: [null],
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    if (this.form.value.cnpj != null) {
      //cadastrar empresa
    }
    if (this.form.value.cpf != null) {
      this.service
        .save({
          _id: '',
          nome: this.form.value.nome,
          email: this.form.value.email,
          senha: this.form.value.senha,
          cpf: this.form.value.cpf,
        })
        .subscribe((candidato: Candidato) => {
          this.router.navigate(['cadastro/proximo/candidato', candidato._id]);
        });
    }
  }

  onReturn() {
    this.router.navigate(['/login']);
  }
}
