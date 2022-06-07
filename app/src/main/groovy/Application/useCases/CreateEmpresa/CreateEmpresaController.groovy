package Application.useCases.CreateEmpresa

import Application.model.Empresa

class CreateEmpresaController {
    def createEmpresaUseCase

    CreateEmpresaController(CreateEmpresaUseCase CEUseCase) {
        this.createEmpresaUseCase= CEUseCase
    }

    def handle(String nome, String email, String cnpj, String senha) {
        Empresa empresa = new Empresa(nome: nome, email: email, cnpj: cnpj, senha: senha)

        createEmpresaUseCase.execute(empresa)
    }
}
