package Application.useCases.CreateUser

import Application.model.Candidato
import Application.repositories.ICandidatoRepositorio

class CreateUserUseCase {
    CreateUserUseCase(private ICandidatoRepositorio pessoaRepository) {}

    def execute(Candidato usuario) {
        pessoaRepository.save(usuario)
    }
}