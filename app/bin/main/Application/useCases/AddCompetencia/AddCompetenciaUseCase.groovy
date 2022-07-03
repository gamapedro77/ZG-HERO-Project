package Application.useCases.AddCompetencia

import Application.DAO.IDAO
import Application.model.IModel
import Application.repositories.implementations.CompetenciaCandidatoRepository

class AddCompetenciaUseCase {
    CompetenciaCandidatoRepository competenciaCandidato;

    AddCompetenciaUseCase(CompetenciaCandidatoRepository CompetenciaCandidato) {
        this.competenciaCandidato = CompetenciaCandidato
    }

    def execute(IModel competenciaCandidato) {
        competenciaCandidato.save(competenciaCandidato)
    }
}
