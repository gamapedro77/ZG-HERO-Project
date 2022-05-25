package Application.Server

import io.undertow.Undertow
import io.undertow.server.HttpHandler

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
