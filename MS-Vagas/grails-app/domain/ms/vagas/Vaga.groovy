package ms.vagas

class Vaga {
        Long id
        String nome
        String descricao
        String local

        static belongsTo = [empresa: Empresa]
        static hasMany = [competencia : Competencia]
        static constraints = {
        }
        static mapping = {
                version false
        }
}

