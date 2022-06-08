package Application.Controllers.Empresas

import Application.DAO.implementations.EmpresasDAO
import Application.repositories.DatabaseFactory
import Application.repositories.implementations.EmpresaRepository
import Application.repositories.implementations.PostgresDB
import Application.useCases.CreateEmpresa.CreateEmpresaController
import Application.useCases.CreateEmpresa.CreateEmpresaUseCase
import Application.useCases.CreateUser.CreateUserController
import Application.useCases.CreateUser.CreateUserUseCase
import groovy.json.JsonSlurper
import io.undertow.io.Receiver
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers
import io.undertow.util.HttpString

class postEmpresaController implements HttpHandler{

    PostgresDB postgresdb = DatabaseFactory.getDatabase('postgres')
    CreateEmpresaUseCase useCase = new CreateEmpresaUseCase(new EmpresaRepository(new EmpresasDAO(postgresdb)))

    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {


        exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")

        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json")
        exchange.getRequestReceiver().receiveFullBytes(new Receiver.FullBytesCallback() {
            @Override
            void handle(HttpServerExchange innerExchange, byte[] message) {

                exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
                def jsonParser = new JsonSlurper()
                def data = jsonParser.parseText(new String(message))
                def CreateEmpresa = new CreateEmpresaController(useCase)
                println data
                CreateEmpresa.handle(data.nome, data.email, data.cnpj, data.senha)
            }
        })

        exchange.setStatusCode(201)
        exchange.getResponseSender().send("{\"response\": \"success\"}")
    }
}
