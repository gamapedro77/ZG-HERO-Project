package Application.Controllers.Candidatos

import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.HttpString

class postCandidatoCompetenciaController implements HttpHandler{
    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
        def candidatoEmail = exchange.getQueryParameters().get("email")
    }
}
