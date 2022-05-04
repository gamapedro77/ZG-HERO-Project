package Application.useCases.CreateUser

import Application.model.Candidato

class CreateUserController{
    CreateUserController(private CreateUserUseCase CreateUserUseCase) {}
    handle(Object dados) {

        CreateUseruseCase.execute(new Candidato(dados as Map))
    }
}