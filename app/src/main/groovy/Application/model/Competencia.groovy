package Application.model

import Application.DAO.implementations.CompetenciaCandidatoDAO
import Application.DAO.implementations.CompetenciasDAO

class Competencia implements IModel {
    def nome

    Competencia(String nome) {
        this.nome = nome
    }

}
