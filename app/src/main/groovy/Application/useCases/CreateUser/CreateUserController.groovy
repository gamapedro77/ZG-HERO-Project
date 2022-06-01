package Application.useCases.CreateUser

import Application.model.Candidato

import java.sql.Date

class CreateUserController{
    def createUserUseCase

    CreateUserController(def CreateUserUseCase) {
        this.createUserUseCase = CreateUserUseCase
    }

    def handle(String nome, String sobrenome, String email, String senha) {
        Date date = Date.valueOf('2022-02-02')
        this.createUserUseCase.execute(new Candidato(nome: nome,
                sobrenome: sobrenome,
                email: email,
                senha: senha,
                data_nascimento: date,
                descricao: 'template',
                CPF: 'template',
                CEP: 'template',
                pais: 'template'
        ))
    }
}