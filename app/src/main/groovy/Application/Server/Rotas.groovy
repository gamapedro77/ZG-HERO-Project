package Application.Server

import Application.Controllers.Candidatos.getCandidatoController
import Application.Controllers.Candidatos.postCandidatoController
import io.undertow.server.HttpHandler
import io.undertow.server.RoutingHandler

class Rotas {
    static HttpHandler ROUTES = new RoutingHandler()
                                .get("/candidatos", new getCandidatoController())
                                .post("/candidatos", new postCandidatoController())



}
