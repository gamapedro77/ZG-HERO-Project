package ms.vagas

import grails.gorm.services.Service

@Service(Empresa)
interface EmpresaService {

    Empresa get(Serializable id)

    List<Empresa> list(Map args)

    Long count()

    Empresa delete(Serializable id)

    Empresa save(Empresa empresa)

}
