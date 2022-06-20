package ms.vagas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class CompetenciaServiceSpec extends Specification {

    CompetenciaService competenciaService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Competencia(...).save(flush: true, failOnError: true)
        //new Competencia(...).save(flush: true, failOnError: true)
        //Competencia competencia = new Competencia(...).save(flush: true, failOnError: true)
        //new Competencia(...).save(flush: true, failOnError: true)
        //new Competencia(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //competencia.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        competenciaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Competencia> competenciaList = competenciaService.list(max: 2, offset: 2)

        then:
        competenciaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        competenciaService.count() == 5
    }

    void "test delete"() {
        Long competenciaId = setupData()

        expect:
        competenciaService.count() == 5

        when:
        competenciaService.delete(competenciaId)
        datastore.currentSession.flush()

        then:
        competenciaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Competencia competencia = new Competencia()
        competenciaService.save(competencia)

        then:
        competencia.id != null
    }
}
