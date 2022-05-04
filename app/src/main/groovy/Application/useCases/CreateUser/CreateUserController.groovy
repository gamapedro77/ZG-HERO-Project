package Application.useCases.CreateUser

import Application.model.Candidato

class CreateUserController{
    def CreateUserUseCase

    CreateUserController(CreateUserUseCase CreateUserUseCase) {
        this.CreateUserUseCase = CreateUserUseCase
    }

    handle(String nome, String sobrenome, String email, String senha) {

        this.CreateUserUseCase.execute(new Candidato(nome, sobrenome, email, senha))
    }
}