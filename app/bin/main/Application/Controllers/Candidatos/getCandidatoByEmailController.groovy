package Application.Controllers.Candidatos

import Application.DAO.implementations.CandidatosDAO
import Application.model.Candidato
import Application.repositories.DatabaseFactory
import Application.repositories.implementations.CandidatoRepository
import Application.repositories.implementations.PostgresDB
import Application.useCases.SearchByEmail.SearchByEmailController
import Application.useCases.SearchByEmail.SearchByEmailUseCase
import groovy.json.JsonOutput
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers
import io.undertow.util.HttpString

class getCandidatoByEmailController implements HttpHandler{

    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json")
        def email = exchange.getQueryParameters().get("email")
        PostgresDB postgresdb = DatabaseFactory.getDatabase('postgres')
        println("get candidato by email controller")
        CandidatoRepository candidatoRepository = new CandidatoRepository(new CandidatosDAO(postgresdb))
        SearchByEmailController search = new SearchByEmailController(new SearchByEmailUseCase(candidatoRepository))
        def candidatos = search.handle(email[0])
        def result = []

        for(Candidato candidato : candidatos) {
            result << JsonOutput.toJson(candidato)
        }

        exchange.setStatusCode(200)
        exchange.getResponseSender().send("{\"candidatos\": ${result}}")
    }
}
