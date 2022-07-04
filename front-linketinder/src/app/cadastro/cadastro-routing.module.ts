import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ProximoComponent } from './proximo/proximo.component';

const routes: Routes = [
  { path: '', component: CadastroComponent },
  { path: 'proximo/candidato/:candidatoId', component: ProximoComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CandidatosRoutingModule {}
