package Application.Controllers.Candidatos

import Application.DAO.implementations.CandidatosDAO
import Application.model.Candidato
import Application.repositories.DatabaseFactory
import Application.repositories.implementations.CandidatoRepository
import Application.repositories.implementations.PostgresDB
import Application.useCases.ListarCandidatos.ListarCandidatosController
import Application.useCases.ListarCandidatos.ListarCandidatosUseCase
import groovy.json.JsonOutput
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers

class getCandidatoController implements HttpHandler{

    PostgresDB postgresdb = DatabaseFactory.getDatabase('postgres')
    CandidatoRepository candidatoRepository = new CandidatoRepository(new CandidatosDAO(postgresdb))

    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json")

        def ListarCandidatosUseCase = new ListarCandidatosUseCase(candidatoRepository)
        def ListarCandidatos = new ListarCandidatosController(ListarCandidatosUseCase)
        def candidatos = ListarCandidatos.handle()

        def result = []

        for(Candidato candidato : candidatos) {
            result << JsonOutput.toJson(candidato)
        }
        exchange.setStatusCode(200)
        exchange.getResponseSender().send("{\"candidatos\": ${result}}")

    }
}
