package Application.model

class Vaga {
    String nome
    String descricao
    int empresa_id
    String local

    Vaga(String nome, String descricao, int empresa_id, String local) {
        this.nome = nome
        this.descricao = descricao
        this.empresa_id = empresa_id
        this.local = local
    }
}
