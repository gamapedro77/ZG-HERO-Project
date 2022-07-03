package Application.Controllers.Candidatos

import Application.DAO.implementations.CandidatosDAO
import Application.repositories.DatabaseFactory
import Application.repositories.implementations.CandidatoRepository
import Application.repositories.implementations.PostgresDB
import Application.useCases.UpdateCandidato.UpdateCandidatoController
import Application.useCases.UpdateCandidato.UpdateCandidatoUseCase
import groovy.json.JsonSlurper
import io.undertow.io.Receiver
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers
import io.undertow.util.HttpString

class putCandidatoController implements HttpHandler {
    PostgresDB postgresdb = DatabaseFactory.getDatabase('postgres')
    CandidatoRepository candidatoRepository = new CandidatoRepository(new CandidatosDAO(postgresdb))

    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json")
        def email = exchange.getQueryParameters().get('email')
        println email

        exchange.getRequestReceiver().receiveFullBytes( new Receiver.FullBytesCallback() {
            @Override
            void handle(HttpServerExchange innerExchange, byte[] message) {
                def jsonParser = new JsonSlurper()
                def data = jsonParser.parseText(new String(message))
                def UpdateCandidatoUseCase = new UpdateCandidatoUseCase(candidatoRepository)
                def UpdateCandidatoController = new UpdateCandidatoController(UpdateCandidatoUseCase)

                UpdateCandidatoController.handle(email[0], data)
            }
        })
        exchange.setStatusCode(201)
        exchange.getResponseSender().send("{\"response\": \"success\"}")
    }
}
