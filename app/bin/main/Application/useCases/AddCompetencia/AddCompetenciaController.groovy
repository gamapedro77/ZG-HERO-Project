package Application.useCases.AddCompetencia

import Application.model.CompetenciaCandidato

class AddCompetenciaController {
    AddCompetenciaUseCase addCompetencia

    AddCompetenciaController(AddCompetenciaUseCase AddCompetencia) {
        this.addCompetencia = AddCompetencia
    }

    def handle(int candidatoId, int competenciaId, String nivel) {
        def competenciaCandidato = new CompetenciaCandidato(candidatoId, competenciaId, nivel)

        addCompetencia.execute(competenciaCandidato)
    }
}
