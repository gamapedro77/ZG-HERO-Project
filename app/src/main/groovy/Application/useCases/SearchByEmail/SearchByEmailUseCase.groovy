package Application.useCases.SearchByEmail

import Application.repositories.ICandidatoRepositorio

class SearchByEmailUseCase {
    def repository
    SearchByEmailUseCase(ICandidatoRepositorio repository) {
        this.repository = repository
    }

    def execute() {
        this.repository.searchByEmail()
    }

}
