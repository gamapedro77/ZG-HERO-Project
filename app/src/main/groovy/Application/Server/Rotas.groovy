package Application.Server

import Application.Controllers.Candidatos.getCandidatoByEmailController
import Application.Controllers.Candidatos.getCandidatoController
import Application.Controllers.Candidatos.postCandidatoController
import Application.Controllers.Candidatos.putCandidatoController
import io.undertow.attribute.ExchangeAttribute
import io.undertow.attribute.ReadOnlyAttributeException
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.server.RoutingHandler
import io.undertow.server.handlers.AccessControlListHandler
import io.undertow.server.handlers.AllowedMethodsHandler
import io.undertow.util.HttpString

class Rotas {
    static HttpHandler ROUTES = new RoutingHandler()
            .get("/candidatos", new getCandidatoController())
            .post("/candidatos", new postCandidatoController())
            .get("/candidatos/{email}", new getCandidatoByEmailController())
            .put("/candidatos/{email}", new putCandidatoController())
            .post("/competencias/{idCandidato}")
            .post("/vagas/{idEmpresa}")
            .post("/empresas")


}
