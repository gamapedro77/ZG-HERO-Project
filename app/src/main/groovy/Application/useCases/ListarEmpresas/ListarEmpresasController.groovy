package Application.useCases.ListarEmpresas

class ListarEmpresasController {
    def listarEmpresasUseCase
    ListarEmpresasController(ListarEmpresasUseCase listarEmpresas) {
        this.listarEmpresasUseCase = listarEmpresas
    }

    def handle() {
        return listarEmpresasUseCase.execute()
    }
}
