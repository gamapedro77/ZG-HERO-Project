package ms.vagas

import ms.vagas.Vaga

class Empresa {
    Long id
    String nome
    static hasMany = [vaga: Vaga]
    static constraints = {

    }
    static mapping = {
        version false
    }
}
