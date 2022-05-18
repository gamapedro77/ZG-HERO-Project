package Application.Controllers

import Application.DAO.implementations.CandidatosDAO
import Application.DAO.implementations.EmpresasDAO
import Application.model.Candidato
import Application.model.Empresa
import Application.repositories.implementations.PostgresDB
import Application.repositories.DatabaseFactory
import Application.repositories.implementations.CandidatoRepository
import Application.repositories.implementations.EmpresaRepository
import Application.useCases.CreateUser.CreateUserController
import Application.useCases.CreateUser.CreateUserUseCase
import Application.useCases.ListarCandidatos.ListarCandidatosController
import Application.useCases.ListarCandidatos.ListarCandidatosUseCase
import Application.useCases.ListarEmpresas.ListarEmpresasController
import Application.useCases.ListarEmpresas.ListarEmpresasUseCase

class Server {
    static def listen() {
        println 'Insira qual instrução deseja realizar: LC - Listar todos candidatos || LE - Listar todas as empresas || IC - Inserir Candidato || IE = Inserir Empresa'
        def reader = System.in.newReader()
        String instrucao = reader.readLine()
        PostgresDB postgresdb = DatabaseFactory.getDatabase('postgres')
        CandidatoRepository candidatoRepository = new CandidatoRepository(new CandidatosDAO(postgresdb))
        EmpresaRepository empresaRepository = new EmpresaRepository(new EmpresasDAO(postgresdb))
        switch(instrucao) {
            case "IC":
                print "nome: "
                String nome = reader.readLine()
                print "sobrenome: "
                String sobrenome = reader.readLine()
                print "email: "
                String email = reader.readLine()
                print "senha: "
                String senha = reader.readLine()
                def CreateUserUseCase = new CreateUserUseCase(candidatoRepository)
                def CreateUser = new CreateUserController(CreateUserUseCase)
                CreateUser.handle(nome, sobrenome, email, senha)
                break
            case 'LC':
                def ListarCandidatosUseCase = new ListarCandidatosUseCase(candidatoRepository)
                def ListarCandidatos = new ListarCandidatosController(ListarCandidatosUseCase)
                def candidatos = ListarCandidatos.handle()
                for(Candidato candidato : candidatos) {
                    println "nome: ${candidato.nome}, sobrenome: ${candidato.sobrenome}, email: ${candidato.email}"
                }
                break
            case 'LE':
                def ListarEmpresasUseCase = new ListarEmpresasUseCase(empresaRepository)
                def ListarEmpresas = new ListarEmpresasController(ListarEmpresasUseCase)
                def empresas = ListarEmpresas.handle()
                for(Empresa empresa : empresas) {
                    println "nome: ${empresa.nome}, email: ${empresa.email}, cnpj: ${empresa.cnpj}"
                }
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