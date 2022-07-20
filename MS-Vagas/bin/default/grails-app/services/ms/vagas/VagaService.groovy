package ms.vagas

import grails.gorm.services.Service

@Service(Vaga)
interface VagaService {

    Vaga get(Serializable id)

    List<Vaga> list(Map args)

    Long count()

    Vaga delete(Serializable id)

    Vaga save(Vaga vaga)

}
