package Application.repositories

import Application.model.Candidato

interface ICandidatoRepositorio {

    def save(Candidato candidato)
    def findByEmail()
    def listAll()
}
