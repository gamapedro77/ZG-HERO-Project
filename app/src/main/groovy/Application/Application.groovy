package Application

import Application.Server.Rotas
import Application.Server.Server


class Application {
    static void main(String[] args){

        def server = new Server(Rotas.ROUTES)
        server.startServer()

    }

}
