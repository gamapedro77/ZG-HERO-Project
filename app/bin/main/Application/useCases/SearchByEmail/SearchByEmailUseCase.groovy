package Application.useCases.SearchByEmail

import Application.repositories.ICandidatoRepositorio

class SearchByEmailUseCase {
    def repository
    SearchByEmailUseCase(ICandidatoRepositorio repository) {
        this.repository = repository
    }

    def execute(String email) {
        return this.repository.findByEmail(email)
    }

}
