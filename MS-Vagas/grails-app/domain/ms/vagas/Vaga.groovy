package ms.vagas

class Vaga {

    String nome
    String descricao
    String local

    static belongsTo = Empresa
    static hasMany = Competencia
    static constraints = {
    }
}
