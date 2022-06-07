package Application.repositories.implementations

import Application.DAO.IDAO
import Application.model.Competencia

class CompetenciaRepository {
    private IDAO CompetenciasDAO

    CompetenciaRepository(IDAO competenciasDAO) {
        this.CompetenciasDAO = competenciasDAO
    }

    def save(Competencia competencia){
        CompetenciasDAO.insert(competencia)
    }

    def searchByName(){}
    def listAll() {}
    def remove(){}
}
