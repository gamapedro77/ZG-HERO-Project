package Application.repositories.implementations

import Application.DAO.IDAO
import Application.model.Candidato
import Application.model.IModel

class CompetenciaCandidatoRepository {
    private IDAO compCandDAO

    CompetenciaCandidatoRepository(IDAO CompetenciaCandidatoDAO) {
        this.compCandDAO = CompetenciaCandidatoDAO
    }

    def save(IModel competenciaCandidato) {
        compCandDAO.insert(competenciaCandidato)
    }
}
