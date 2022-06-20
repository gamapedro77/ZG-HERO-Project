package ms.vagas

class Empresa {
    String nome
    static hasMany = [vaga: Vaga]
    static constraints = {
    }
}
