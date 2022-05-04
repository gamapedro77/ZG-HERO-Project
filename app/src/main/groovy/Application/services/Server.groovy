package Application.services

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
                def CreateUserUseCase = new CreateUserUseCase()
                def CreateUser = new CreateUserController()
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