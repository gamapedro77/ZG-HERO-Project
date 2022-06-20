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
class EmpresaController {

    EmpresaService empresaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond empresaService.list(params), model:[empresaCount: empresaService.count()]
    }

    def show(Long id) {
        respond empresaService.get(id)
    }

    def listVagas(Long id) {
        if (empresaService.get(id)) {
            respond empresaService.get(id).vaga
        } else {
            respond "Não existe vagas registradas para o usuario de id: $id"
        }

    }

    @Transactional
    def save(Empresa empresa) {
        if (empresa == null) {
            render status: NOT_FOUND
            return
        }
        if (empresa.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond empresa.errors
            return
        }

        try {
            empresaService.save(empresa)
        } catch (ValidationException e) {
            respond empresa.errors
            return
        }

        respond empresa, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Empresa empresa) {
        if (empresa == null) {
            render status: NOT_FOUND
            return
        }
        if (empresa.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond empresa.errors
            return
        }

        try {
            empresaService.save(empresa)
        } catch (ValidationException e) {
            respond empresa.errors
            return
        }

        respond empresa, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || empresaService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
