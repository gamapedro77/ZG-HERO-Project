package Application.Controllers.Competencias

import Application.DAO.implementations.CompetenciaCandidatoDAO
import Application.repositories.DatabaseFactory
import Application.useCases.AddCompetencia.AddCompetenciaController
import Application.useCases.AddCompetencia.AddCompetenciaUseCase
import groovy.json.JsonSlurper
import io.undertow.io.Receiver
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers
import io.undertow.util.HttpString

class postCompetenciaCandidatoController implements HttpHandler {



    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json")
        def AddCompetenciaUseCase = new AddCompetenciaUseCase(new CompetenciaCandidatoDAO(DatabaseFactory.getDatabase('postgres')))
        def AddCompetenciaController = new AddCompetenciaController(AddCompetenciaUseCase)
        def candidatoId = exchange.getQueryParameters().get('id')
        exchange.getRequestReceiver().receiveFullBytes( new Receiver.FullBytesCallback() {
            @Override
            void handle(HttpServerExchange innerExchange, byte[] message) {
                def jsonParser = new JsonSlurper()
                def data = jsonParser.parseText(new String(message))

                AddCompetenciaController.handle(candidatoId, data.competenciaId, data.nivel)
            }
        })
    }
}
