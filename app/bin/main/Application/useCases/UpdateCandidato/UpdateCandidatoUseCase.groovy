package Application.useCases.UpdateCandidato


import Application.repositories.ICandidatoRepositorio

class UpdateCandidatoUseCase {
    def pessoaRepository
    UpdateCandidatoUseCase(ICandidatoRepositorio pessoaRepository) {
        this.pessoaRepository = pessoaRepository
    }

    def execute(int idCandidato, Map novosValores) {
        this.pessoaRepository.update(idCandidato, novosValores)
    }
}
