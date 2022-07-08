package ms.vagas

import grails.core.GrailsApplication
import grails.plugins.*
import io.swagger.annotations.Api


@Api(value = "Controller default", tags="Ignore")
class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }
}
