package Application.Server

import Application.Controllers.Candidatos.getCandidatoController
import io.undertow.server.HttpHandler
import io.undertow.server.RoutingHandler

class Rotas {
    static HttpHandler ROUTES = new RoutingHandler()
                                .get("/candidatos", new getCandidatoController())



}
