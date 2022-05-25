package Application.useCases.CreateUser

import Application.model.Candidato

import java.sql.Date

class CreateUserController{
    def createUserUseCase

    CreateUserController(def CreateUserUseCase) {
        this.createUserUseCase = CreateUserUseCase
    }

    def handle(String nome, String sobrenome, String email, String senha, String descricao, String CPF, String CEP, String pais, String data) {
        Date date = Date.valueOf(data)
        this.createUserUseCase.execute(new Candidato(nome: nome,
                sobrenome: sobrenome,
                email: email,
                senha: senha,
                data_nascimento: date,
                descricao: descricao,
                CPF: CPF,
                CEP: CEP,
                pais: pais
        ))
    }
}