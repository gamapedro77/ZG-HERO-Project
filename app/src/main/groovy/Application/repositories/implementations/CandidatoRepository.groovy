package Application.repositories.implementations

import Application.DAO.IDAO
import Application.model.Candidato
import Application.repositories.ICandidatoRepositorio

class CandidatoRepository implements ICandidatoRepositorio{

    private IDAO candidatosDAO

    CandidatoRepository(IDAO candidatoDAO) {
        this.candidatosDAO = candidatoDAO
    }

    def save(Candidato candidato) {
        candidatosDAO.insert(candidato)
    }


    def findByEmail(String email) {
        return null
    }

    def findByCpf(String cpf) {

    }

    def listAll() {
        def candidatos = candidatosDAO.readAll()
        return candidatos
    }
}