package Application.model

import Application.DAO.CompetenciaCandidatoDAO
import Application.DAO.CompetenciasDAO

class Competencia {
    def listaCompetencias

    Competencia(listaCompetencias) {
        this.listaCompetencias = listaCompetencias
    }

    def inserirCompetencias() {
        for(competencia in listaCompetencias) {
            if(!CompetenciasDAO.searchCompetencia(competencia)) {
                CompetenciasDAO.insertCompetencia(competencia)
            }
            List resultado = CompetenciasDAO.searchCompetencia(competencia)
            CompetenciaCandidatoDAO.insertCompetenciaDoCandidato(candidato_id, resultado[0], "Avançado")
        }
    }
}
