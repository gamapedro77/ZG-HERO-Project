package Application.Controllers.Candidatos

import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange

class postCandidatoCompetenciaController implements HttpHandler{
    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {
        def candidatoEmail = exchange.getQueryParameters().get("email")
    }
}
