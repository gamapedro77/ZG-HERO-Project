package Application.useCases.ListarCandidatos

import Application.repositories.ICandidatoRepositorio

class ListarCandidatosUseCase {
    def pessoaRepository

    ListarCandidatosUseCase(ICandidatoRepositorio pessoaRepository) {
        this.pessoaRepository = pessoaRepository
    }

    def listAll() {
        def candidatos = pessoaRepository.listAll()
        return candidatos
    }
}
