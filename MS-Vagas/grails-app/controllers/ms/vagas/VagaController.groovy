package ms.vagas

import grails.validation.ValidationException
import io.swagger.annotations.Api

import javax.ws.rs.Path

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@Api(tags="Rotas de Vaga")
@Path("/vagas")
@ReadOnly
class VagaController {

    VagaService vagaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vagaService.list(params), model:[vagaCount: vagaService.count()]
    }

    def show(Long id) {
        respond vagaService.get(id)
    }


    @Transactional
    def save(Vaga vaga) {
        def empresa = Empresa.get(params.idempresa)

        if (vaga == null) {
            render status: NOT_FOUND
            return
        }
        if (vaga.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vaga.errors
            return
        }

        try {
            empresa.addToVaga(vaga)
        } catch (ValidationException e) {
            respond vaga.errors
            return
        }

        respond vaga, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Vaga vaga) {
        if (vaga == null) {
            render status: NOT_FOUND
            return
        }
        if (vaga.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vaga.errors
            return
        }

        try {
            vagaService.save(vaga)
        } catch (ValidationException e) {
            respond vaga.errors
            return
        }

        respond vaga, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || vagaService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
