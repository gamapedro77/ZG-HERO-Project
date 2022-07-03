package Application.useCases.CreateCompetencia

import Application.model.Competencia

class CreateCompetenciaController {
    def CreateCompetenciaUseCase

    CreateCompetenciaController(CreateCompetenciaUseCase useCase) {
        this.CreateCompetenciaUseCase = useCase
    }

    def handle(String nomeCompetencia) {

        Competencia competencia = new Competencia(nomeCompetencia)

        CreateCompetenciaUseCase.execute(competencia)
    }


}
