package ms.vagas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class VagaController {

    VagaService vagaService
    EmpresaService empresaService

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

    def listVagas(Long id) {
        if (empresaService.get(id)) {
            respond empresaService.get(id).vaga
        } else {
            respond "Não existe vagas registradas para o usuario de id: $id"
        }

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
