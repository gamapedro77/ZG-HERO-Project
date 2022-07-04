package Application.useCases.ListarEmpresas

import Application.repositories.IEmpresaRepository

class ListarEmpresasUseCase {

    IEmpresaRepository empresaRepository

    ListarEmpresasUseCase(IEmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository
    }

    def execute() {
        return empresaRepository.listAll()
    }
}
