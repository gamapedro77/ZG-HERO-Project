package Application.Controllers.Competencias

import Application.DAO.IDAO
import Application.DAO.implementations.CompetenciasDAO
import Application.repositories.implementations.CompetenciaRepository
import Application.repositories.implementations.PostgresDB
import Application.useCases.CreateCompetencia.CreateCompetenciaController
import Application.useCases.CreateCompetencia.CreateCompetenciaUseCase
import groovy.json.JsonSlurper
import io.undertow.io.Receiver
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers
import io.undertow.util.HttpString

class postCompetenciaController implements HttpHandler {
    IDAO competenciasDAO = new CompetenciasDAO(new PostgresDB())
    CreateCompetenciaUseCase CreateCompetencia = new CreateCompetenciaUseCase(new CompetenciaRepository(competenciasDAO))
    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json")
        CreateCompetenciaController CreateCompetenciaController = new CreateCompetenciaController(CreateCompetencia)

        exchange.getRequestReceiver().receiveFullBytes( new Receiver.FullBytesCallback() {
            @Override
            void handle(HttpServerExchange innerExchange, byte[] message) {
                def jsonParser = new JsonSlurper()
                def data = jsonParser.parseText(new String(message))
                CreateCompetenciaController.handle(data.competencia)
            }
        })

        exchange.setStatusCode(201)
        exchange.getResponseSender().send("{\"response\": \"success\"")
    }
}
