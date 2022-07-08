import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CandidatoService } from 'src/app/cadastro/services/candidato.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: CandidatoService,
    private router: Router
  ) {
    this.form = this.formBuilder.group({
      email: [null],
      senha: [null],
    });
  }
  ngOnInit(): void {}

  onSubmit() {
    console.log('doideira maluco');
  }

  onCadastro() {
    console.log('maconha');
    //this.router.navigate(['/cadastro']);
  }
}
