package Application.useCases.CreateUser

import Application.model.Candidato

import java.sql.Date

class CreateUserController{
    def createUserUseCase

    CreateUserController(def CreateUserUseCase) {
        this.createUserUseCase = CreateUserUseCase
    }

    def handle(String nome, String sobrenome, String email, String senha) {
        String dataString = "1969-01-01"
        Date date = Date.valueOf(dataString)

        this.createUserUseCase.execute(new Candidato(nome: nome,
                sobrenome: sobrenome,
                email: email,
                senha: senha,
                data_nascimento: date,
                descricao: "template",
                CPF: "11122233344",
                CEP: "25000024",
                pais: "Brasil"
        ))
    }
}