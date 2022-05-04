package Application.services

import Application.DAO.implementations.CandidatosDAO
import Application.repositories.implementations.CandidatoRepository
import Application.repositories.implementations.PostgresDB
import Application.useCases.CreateUser.CreateUserController
import Application.useCases.CreateUser.CreateUserUseCase

class Server {
    static def listen() {
        println 'Insira qual instrução deseja realizar: LC - Listar todos candidatos || LE - Listar todas as empresas || IC - Inserir Candidato || IE = Inserir Empresa'
        def reader = System.in.newReader()
        String instrucao = reader.readLine()
        switch(instrucao){
            case "IC":
                print "nome: "
                String nome = reader.readLine()
                print "sobrenome: "
                String sobrenome = reader.readLine()
                print "email: "
                String email = reader.readLine()
                print "senha: "
                String senha = reader.readLine()
                CandidatoRepository candidatoRepository = new CandidatoRepository(new CandidatosDAO(new PostgresDB()))
                def CreateUserUseCase = new CreateUserUseCase(candidatoRepository)
                def CreateUser = new CreateUserController(CreateUserUseCase)
                CreateUser.handle(nome, sobrenome, email, senha)
                break
            case 'LC':

                break
            case 'LE':

                break
            case 'IC':

                break
            case "IE":

                break
            case "LV":

                break
            default:
                println "comando não reconhecido"
                break
        }
    }
}