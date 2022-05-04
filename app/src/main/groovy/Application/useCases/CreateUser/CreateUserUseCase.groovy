package Application.useCases.CreateUser

import Application.model.Candidato
import Application.repositories.ICandidatoRepositorio

class CreateUserUseCase {
    def pessoaRepository
    CreateUserUseCase(ICandidatoRepositorio pessoaRepository) {
        this.pessoaRepository = pessoaRepository
    }

    def execute(Candidato usuario) {
        this.pessoaRepository.save(usuario)
    }
}