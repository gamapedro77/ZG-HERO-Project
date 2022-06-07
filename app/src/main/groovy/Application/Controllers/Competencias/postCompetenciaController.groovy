package Application.Controllers.Competencias

import groovy.json.JsonSlurper
import io.undertow.io.Receiver
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers
import io.undertow.util.HttpString

class postCompetenciaController implements HttpHandler {

    @Override
    void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*")
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json")

        exchange.getRequestReceiver().receiveFullBytes( new Receiver.FullBytesCallback() {
            @Override
            void handle(HttpServerExchange innerExchange, byte[] message) {
                def jsonParser = new JsonSlurper()
                def data = jsonParser.parseText(new String(message))

            }
        })
    }
}
