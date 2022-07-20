package ms.vagas

class UrlMappings {

    static mappings = {


        post "/api/vagas/$idempresa(.$format)?"(controller: 'vaga', action: 'save')
        get "/api/vagas/empresas/$id(.$format)?"(controller: 'vaga', action: 'listVagas')
        post "/api/vaga/$idvaga/competencias(.$format)?"(controller: 'vaga', action: 'saveCompetencias')

        delete "/api/$controller/$id(.$format)?"(action:"delete")
        get "/api/$controller(.$format)?"(action:"index")
        get "/api/$controller/$id(.$format)?"(action:"show")
        post "/api/$controller(.$format)?"(action:"save")
        put "/api/$controller/$id(.$format)?"(action:"update")
        patch "/api/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
