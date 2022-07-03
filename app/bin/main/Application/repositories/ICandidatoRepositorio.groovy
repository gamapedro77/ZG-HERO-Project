package Application.repositories

import Application.model.Candidato

interface ICandidatoRepositorio {

    def save(Candidato candidato)
    def findByEmail(String email)
    def listAll()
    def findByCpf(String cpf)
}
