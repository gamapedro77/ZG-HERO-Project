package Application.useCases.CreateEmpresa

import Application.model.Empresa
import Application.repositories.implementations.EmpresaRepository

class CreateEmpresaUseCase {
    def empresaRepository

    CreateEmpresaUseCase(EmpresaRepository EmRepository) {
        this.empresaRepository = EmRepository
    }

    execute(Empresa empresa) {
        empresaRepository.save(empresa)
    }
}
