package Application.useCases.CreateCompetencia

import Application.model.Competencia
import Application.repositories.implementations.CompetenciaRepository

class CreateCompetenciaUseCase {
    def competenciaRepository

    CreateCompetenciaUseCase(CompetenciaRepository compRepository) {
        this.competenciaRepository = compRepository
    }

    def execute(Competencia competencia){
        competenciaRepository.save(competencia)
    }
}
