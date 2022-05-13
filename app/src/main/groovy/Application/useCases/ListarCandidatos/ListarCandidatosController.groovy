package Application.useCases.ListarCandidatos

class ListarCandidatosController {
    def listarCandidatosUseCase

    ListarCandidatosController(ListarCandidatosUseCase listarCandidatosUseCase) {
        this.listarCandidatosUseCase = listarCandidatosUseCase
    }

    def handle() {
        def candidatos = listarCandidatosUseCase.execute()
        return candidatos
    }

}
