package Application.Controllers.Candidatos

import Application.DAO.implementations.CandidatosDAO
import Application.repositories.DatabaseFactory
import Application.repositories.implementations.CandidatoRepository
import Application.repositories.implementations.PostgresDB
import Application.useCases.CreateUser.CreateUserController
import Application.useCases.CreateUser.CreateUserUseCase
import groovy.json.JsonSlurper
import io.undertow.io.Receiver
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.server.handlers.AccessControlListHandler
import io.undertow.util.Headers
import io.undertow.util.HttpString
import io.undertow.util.StringReadChannelListener

class postCandidatoController implements HttpHandler {

    PostgresDB postgresdb = DatabaseFactory.getDatabase('postgres')
    CandidatoRepository candidatoRepository = new CandidatoRepository(new CandidatosDAO(postgresdb))

    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {

        // exchange.getRequestHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
        exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")

        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json")
        exchange.getRequestReceiver().receiveFullBytes(new Receiver.FullBytesCallback() {
            @Override
            void handle(HttpServerExchange innerExchange, byte[] message) {

                // exchange.getRequestHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
                exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")

                def jsonParser = new JsonSlurper()
                def data = jsonParser.parseText(new String(message))
                def CreateUserUseCase = new CreateUserUseCase(candidatoRepository)
                def CreateUser = new CreateUserController(CreateUserUseCase)
                println data
                CreateUser.handle(data.nome, data.sobrenome, data.email, data.CPF, data.senha)
            }
        })

        exchange.setStatusCode(201)
        exchange.getResponseSender().send("{\"response\": \"success\"}")


    }

    static myReadListener() {

    }

}
