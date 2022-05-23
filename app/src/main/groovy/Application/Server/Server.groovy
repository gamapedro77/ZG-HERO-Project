package Application.Server

import Application.Controllers.ListarCandidatosUseCase
import io.undertow.Undertow
import io.undertow.server.HttpHandler
import io.undertow.server.RoutingHandler

class Server {
        HttpHandler ROUTES

        Server(HttpHandler routes) {
            this.ROUTES = routes
        }

        def startServer() {
            Undertow server = Undertow.builder()
                    .addHttpListener(9999, "localhost", ROUTES).build()
            server.start()
        }

}
