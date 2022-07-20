package ms.vagas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class CompetenciaController {

    CompetenciaService competenciaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond competenciaService.list(params), model:[competenciaCount: competenciaService.count()]
    }

    def show(Long id) {
        respond competenciaService.get(id)
    }

    @Transactional
    def save(Competencia competencia) {

        def vaga = Vaga.get(params.idempresa)

        if (competencia == null) {
            render status: NOT_FOUND
            return
        }
        if (competencia.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond competencia.errors
            return
        }

        try {
            vaga.addToCompetencia(competencia)
        } catch (ValidationException e) {
            respond competencia.errors
            return
        }

        respond competencia, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Competencia competencia) {
        if (competencia == null) {
            render status: NOT_FOUND
            return
        }
        if (competencia.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond competencia.errors
            return
        }

        try {
            competenciaService.save(competencia)
        } catch (ValidationException e) {
            respond competencia.errors
            return
        }

        respond competencia, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || competenciaService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
