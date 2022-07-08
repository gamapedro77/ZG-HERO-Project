package ms.vagas

class UrlMappings {

    static mappings = {

        post "/vagas/$idempresa(.$format)?"(controller: 'vaga', action: 'save')
        get "/vagas/empresa/$id(.$format)?"(controller: 'empresa', action: 'listVagas')
        post "/competencia/$idvaga(.$format)?"(controller: 'competencia', action: 'save')

        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")



        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
