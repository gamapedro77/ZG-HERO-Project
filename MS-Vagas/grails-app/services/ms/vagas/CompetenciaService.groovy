package ms.vagas

import grails.gorm.services.Service

@Service(Competencia)
interface CompetenciaService {

    Competencia get(Serializable id)

    List<Competencia> list(Map args)

    Long count()

    Competencia delete(Serializable id)

    Competencia save(Competencia competencia)

}
