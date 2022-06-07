package Application.useCases.UpdateCandidato

import groovy.json.JsonSlurper


class UpdateCandidatoController {
    def updateCandidatoUseCase

   UpdateCandidatoController(def UpdateCandidatoUseCase) {
        this.updateCandidatoUseCase = UpdateCandidatoUseCase
    }

    def handle(String email, Map novosValores) {
        def get = new URL("http://localhost:9999/candidatos/${email}").openConnection()
        def data = get.getInputStream().getText();

        def jsonParser = new JsonSlurper()
        def candidato = jsonParser.parseText(data)

        println(candidato.candidatos[0].id)

        updateCandidatoUseCase.execute(1, novosValores)
    }
}
